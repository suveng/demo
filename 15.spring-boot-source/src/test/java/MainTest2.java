import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.atomic.AtomicLong;

/**
 *
 * @author suwenguang
 **/
public class MainTest2 {
	public static void main(String[] args) {
		AtomicLong atomicLong = new AtomicLong(0);
		MeArrayBlockingQueue<String> strings = new MeArrayBlockingQueue<>(1000);
		//生产者先生产100个
		Thread produce = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					strings.put(String.valueOf(System.nanoTime()));
					Thread.sleep(3);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});

		for (int i = 0; i < 100; i++) {
			produce.run();
		}

		System.out.println("加入e="+strings.size());

		// 消费者开始消费,每次消费停 2ms, 消费者开启10个
		Thread consumer = new Thread(new Runnable() {
			@Override
			public void run() {
				long start = System.nanoTime();
				String poll = strings.poll();
				System.out.println("消费到数据"+poll);
				try {
					Thread.sleep(2);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				long end = System.nanoTime();

				long cost = (end - start) / 1000000;
				atomicLong.addAndGet(cost);
			}
		});
		for (int i = 0; i < 10; i++) {
			consumer.start();
		}
		// 生产者每3ms 产生1个, 生产者开启10个
		for (int i = 0; i < 10; i++) {
			produce.start();
		}

		try {
			Thread.sleep(60*60*5);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("结果="+atomicLong.get());
	}
}
