package my.suveng.flink;

import my.suveng.flink.custom_datasource.MemoryCustomDataSource;
import my.suveng.flink.custom_sink.LogCustomSink;
import org.apache.flink.api.common.serialization.SimpleStringSchema;
import org.apache.flink.streaming.api.datastream.DataStreamSource;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.connectors.kafka.FlinkKafkaConsumer011;
import org.springframework.stereotype.Service;

import java.util.Properties;

/**
 *
 * @author suwenguang
 **/
@Service
public class FlinkService {
	/**
	 * 使用自定义的  datasource
	 */
	void customDataSource() throws Exception {
		//
		final StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
		env.addSource(new MemoryCustomDataSource()).print();
		env.execute("自定义数据源");

	}

	/**
	 * 使用内置的kafka datasource
	 */
	public  void  builtInKafkaSource() throws Exception {
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

	/**
	 * 自定义source 自定义sink
	 */
	public void custom_source_custom_sink() throws Exception {
		final StreamExecutionEnvironment env = StreamExecutionEnvironment.createLocalEnvironment();

		DataStreamSource<String> dataStreamSource = env.addSource(new MemoryCustomDataSource());

		dataStreamSource.addSink(new LogCustomSink());


		env.execute("custom_source_custom_sink");
	}

}
