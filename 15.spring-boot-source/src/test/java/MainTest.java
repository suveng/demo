import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.atomic.AtomicLong;

/**
 *
 * @author suwenguang
 **/
public class MainTest {
	public static  volatile boolean flag = true;
	public static void main(String[] args) {

		AtomicLong atomicLong = new AtomicLong(0);
		ArrayBlockingQueue<String> strings = new ArrayBlockingQueue<>(1000);
		//生产者先生产100个
		for (int i = 0; i < 100; i++) {
			strings.offer(String.valueOf(System.nanoTime()));
		}

		System.out.println("加入e=" + strings.size());

		// 消费者开始消费,每次消费停 2ms, 消费者开启10个
		Thread[] consumers = new Thread[10];

		for (int i = 0; i < consumers.length ; i++) {
			new Thread(new Runnable() {
				@Override
				public void run() {
					while (flag) {
						long start = System.nanoTime();
						String poll = null;
						try {
							poll = strings.take();
							System.out.println("消费到数据" + poll);
							Thread.sleep(1);
							long end = System.nanoTime();
							long cost = (end - start) / 1000000;
							atomicLong.addAndGet(cost);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}

					}
				}
			}).start();
		}


		System.out.println("开始生产");
		// 生产者每3ms 产生1个, 生产者开启10个
		Thread[] produces = new Thread[1];

		for (int i = 0; i < produces.length; i++) {
			Thread produce = new Thread(new Runnable() {
				@Override
				public void run() {
					while (flag) {
						strings.offer(String.valueOf(System.nanoTime()));
						try {
							Thread.sleep(3);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}
			});
			produce.start();

		}


		try {
			Thread.sleep(1000*10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		flag=false;
		System.out.println("结果=" + atomicLong.get());
		System.exit(0);
	}
}
