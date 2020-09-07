package my.suveng.flink;

import my.suveng.flink.custom_datasource.MemoryCustomDataSource;
import org.apache.flink.api.common.serialization.SimpleStringSchema;
import org.apache.flink.streaming.api.datastream.DataStreamSource;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.connectors.kafka.FlinkKafkaConsumer011;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Properties;

@SpringBootApplication
public class FlinkKafkaSourceApplication {

    public static void main(String[] args) throws Exception {

		ConfigurableApplicationContext context = SpringApplication.run(FlinkKafkaSourceApplication.class, args);
		FlinkService flinkService = context.getBean(FlinkService.class);
		// 1. flink 程序使用 内置的kafka source
		//builtInKafkaSource();
		// 2. flink 程序使用 自定义的mysql source
		flinkService.customDataSource();
    }


}
