package my.suveng.flink;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class FlinkKafkaSourceApplication {

	public static void main(String[] args) throws Exception {

		ConfigurableApplicationContext context = SpringApplication.run(FlinkKafkaSourceApplication.class, args);
		FlinkService flinkService = context.getBean(FlinkService.class);
		// 1. flink 程序使用 内置的kafka source
		//builtInKafkaSource();
		// 2. flink 程序使用 自定义的mysql source
		//flinkService.customDataSource();
		// 3. flink 自定义 sink
		flinkService.custom_source_custom_sink();
	}


}
