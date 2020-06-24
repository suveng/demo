package my.suveng.promethussimpleclientdemo;

import io.prometheus.client.Collector;
import io.prometheus.client.exporter.HTTPServer;
import io.prometheus.client.hotspot.DefaultExports;
import lombok.extern.slf4j.Slf4j;
import my.suveng.promethussimpleclientdemo.metric.HttpApiCounter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.util.List;

@SpringBootApplication
@Slf4j
public class Application {

	public static void main(String[] args) throws IOException {
		log.info("promethues java exporter 启动...");
		SpringApplication.run(Application.class, args);
		log.info("启动完毕!!!");

		log.info("功能1. 实现一个java 的 exporter , 将数据推送到prometheus中");
		log.info("功能2. 编写一些接口, 监控其处理耗时, 并把对应指标推送到prometheus中");


		int metricServerPort = 18081;
		HTTPServer server = new HTTPServer(metricServerPort);
		log.info("metricServer启动, 端口:{}", metricServerPort);

		// 每个指标都不一样, 大致都是这样子写
		HttpApiCounter.http_count.labels("/url", "node1", "v1", "2").inc();

		//List<Collector> collectors = new ArrayList<>();

		// 打印
		//printlnCollectors(collectors);

		// jvm metrics 数据
		DefaultExports.initialize();


	}

	/**
	 * 打印collectors
	 * @author suwenguang
	 */
	private static void printlnCollectors(List<Collector> collectors) {
		StringBuilder sb = new StringBuilder("注册的collector  list: ");
		for (Collector collector : collectors) {
			sb.append(collector.getClass().getSimpleName()).append(" ");
		}
		log.info(sb.toString());
	}

}
