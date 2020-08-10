package my.suveng.netty.learn.socket;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import io.netty.handler.codec.LengthFieldPrepender;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.util.CharsetUtil;

/**
 * description:
 * @author suwenguang
 * @version 1.0.0
 **/
public class SocketClientInitializer extends ChannelInitializer<SocketChannel> {
	@Override
	protected void initChannel(SocketChannel ch) throws Exception {
		ChannelPipeline pipeline = ch.pipeline();

		//pipeline.addLast(new LoggingHandler(LogLevel.INFO));
		pipeline.addLast("LengthFieldBasedFrameDecoder", new LengthFieldBasedFrameDecoder(Integer.MAX_VALUE, 0, 4, 0, 4));
		pipeline.addLast("LengthFieldPrepender", new LengthFieldPrepender(4));
		pipeline.addLast("StringEncoder", new StringEncoder(CharsetUtil.UTF_8));
		pipeline.addLast("StringDecoder", new StringDecoder(CharsetUtil.UTF_8));
		pipeline.addLast("SocketClientHandler", new StringSocketClientHandler());
	}
}
