package my.suveng.netty.learn.heartbeat;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.timeout.IdleStateHandler;

import java.util.concurrent.TimeUnit;

/**
 *
 * @author suwenguang
 * @version 1.0.0
 **/
public class HeartBeatServerInitializer extends ChannelInitializer<SocketChannel> {
	@Override
	protected void initChannel(SocketChannel ch) throws Exception {
		ChannelPipeline pipeline = ch.pipeline();

		//空闲状态监测处理器
		pipeline.addLast(new IdleStateHandler(5, 7, 10, TimeUnit.SECONDS));
		//自定义处理器
		pipeline.addLast(new HeartBeatServerHandler());
	}
}
