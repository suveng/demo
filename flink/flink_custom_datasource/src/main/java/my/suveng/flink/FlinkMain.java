package my.suveng.flink;

import my.suveng.flink.custom_datasource.MemoryCustomDataSource;
import org.apache.flink.api.common.serialization.SimpleStringSchema;
import org.apache.flink.streaming.api.datastream.DataStreamSource;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.connectors.kafka.FlinkKafkaConsumer011;

import java.util.Properties;

/**
 * flink 程序
 * @author suwenguang
 **/
public class FlinkMain {
	public static void main(String[] args) throws Exception {
		// 1. flink 程序使用 内置的kafka source
		//builtInKafkaSource();
		// 2. flink 程序使用 自定义的mysql source
		customDataSource();
	}

	/**
	 * 使用自定义的  datasource
	 */
	private static void customDataSource() throws Exception {
		//
		final StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
		env.addSource(new MemoryCustomDataSource()).print();
		env.execute("自定义数据源");

	}

	/**
	 * 使用内置的kafka datasource
	 */
	private static void  builtInKafkaSource() throws Exception {
		// 不断读取kafka数据
		final StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();

		Properties props = new Properties();
		props.put("bootstrap.servers", "localhost:9092");
		props.put("zookeeper.connect", "localhost:2181");
		//props.put("group.id", "metric-group");
		props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");  //key 反序列化
		props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
		props.put("auto.offset.reset", "latest"); //value 反序列化

		FlinkKafkaConsumer011<String> kafkaSource = new FlinkKafkaConsumer011<>(
			"flink_kafka_source",
			new SimpleStringSchema(),
			props);

		DataStreamSource<String> objectDataStreamSource = env.addSource(kafkaSource);
		DataStreamSource<String> objectDataStreamSource1 = objectDataStreamSource.setParallelism(1);

		objectDataStreamSource1.print(); //把从 kafka 读取到的数据打印在控制台

		env.execute("Flink add data source");
	}
}
