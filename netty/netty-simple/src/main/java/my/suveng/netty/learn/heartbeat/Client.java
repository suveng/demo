package my.suveng.netty.learn.heartbeat;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import my.suveng.netty.learn.broadcast.BroadcastClientInitializer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 聊天室客户端
 * @author suwenguang
 * @version 1.0.0
 **/
public class Client {
	public static void main(String[] args) throws InterruptedException {
		EventLoopGroup eventLoopGroup = new NioEventLoopGroup();
		try {
			Bootstrap bootstrap = new Bootstrap();
			bootstrap.group(eventLoopGroup);
			bootstrap.channel(NioSocketChannel.class);
			bootstrap.handler(new BroadcastClientInitializer());

			ChannelFuture channelFuture = bootstrap.connect("localhost", 30301);
			Channel channel = channelFuture.channel();
			//控制台读取
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
			for (; ; ) {
				channel.writeAndFlush(bufferedReader.readLine() + "\r\n");
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			eventLoopGroup.shutdownGracefully();
		}
	}
}
