package my.suveng.flink.controller;

import cn.hutool.core.util.RandomUtil;
import my.suveng.flink.FlinkKafkaSourceApplicationTests;
import my.suveng.flink.send.KafkaTemplateSend;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author suwenguang
 **/
public class WebControllerTest extends FlinkKafkaSourceApplicationTests {

	@Autowired
	private KafkaTemplateSend kafkaTemplateSend;

	/**
	 * 产生topic数据
	 * @throws InterruptedException blah
	 */
	@Test
	void sendSync() throws InterruptedException {
		// 不断发送数据
		while (true){
			kafkaTemplateSend.sendToKafkaSync(RandomUtil.randomNumbers(10));
			Thread.sleep(1000);
		}
	}
}
