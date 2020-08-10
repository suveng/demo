package my.suveng.netty.learn.websocket;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.codec.http.websocketx.WebSocketServerProtocolHandler;
import io.netty.handler.stream.ChunkedWriteHandler;

/**
 *
 * @author suwenguang
 * @version 1.0.0
 **/
public class WebsocketChannelInitializer extends ChannelInitializer<SocketChannel> {

	@Override
	protected void initChannel(SocketChannel ch) throws Exception {
		ChannelPipeline pipeline = ch.pipeline();

		//解码器
		pipeline.addLast(new HttpServerCodec());

		//以块 写的方式
		pipeline.addLast(new ChunkedWriteHandler());

		//消息聚合到一个对象的处理器
		pipeline.addLast(new HttpObjectAggregator(8192));

		//websocket协议处理器
		pipeline.addLast(new WebSocketServerProtocolHandler("/ws"));

		//自定义处理器
		pipeline.addLast(new WebSocketServerHandler());
	}
}
