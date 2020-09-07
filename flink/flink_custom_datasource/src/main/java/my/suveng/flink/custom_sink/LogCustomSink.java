package my.suveng.flink.custom_sink;

import lombok.extern.slf4j.Slf4j;
import org.apache.flink.configuration.Configuration;
import org.apache.flink.streaming.api.functions.sink.RichSinkFunction;

/**
 * 自定义文件sink
 * @author suwenguang
 **/
@Slf4j
public class LogCustomSink extends RichSinkFunction<String> {
	/**
	 * Writes the given value to the sink. This function is called for every record.
	 *
	 * <p>You have to override this method when implementing a {@code SinkFunction}, this is a
	 * {@code default} method for backward compatibility with the old-style method only.
	 *
	 * @param value The input record.
	 * @param context Additional context about the input record.
	 *
	 * @throws Exception This method may throw exceptions. Throwing an exception will cause the operation
	 *                   to fail and may trigger recovery.
	 */
	@Override
	public void invoke(String value, Context context) throws Exception {
		log.info("执行sink...");
		// 操作数据源, 这里直接打印
		log.info("sink --- {}",value );
	}


	@Override
	public void open(Configuration parameters) throws Exception {
		log.info("打开data sink...");
		//super.open(parameters);
	}

	@Override
	public void close() throws Exception {
		//super.close();
		log.info("关闭data sink...");

	}
}
