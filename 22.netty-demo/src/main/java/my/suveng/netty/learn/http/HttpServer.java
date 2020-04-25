package my.suveng.netty.learn.http;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * description: 服务器配置
 * @author suwenguang
 * @version 1.0.0
 **/
public class HttpServer {

	public static void main(String[] args) throws InterruptedException {
		EventLoopGroup bossGroup = new NioEventLoopGroup();
		EventLoopGroup workerGroup = new NioEventLoopGroup();
		try {
			//
			ServerBootstrap serverBootstrap = new ServerBootstrap();
			serverBootstrap.group(bossGroup, workerGroup);
			serverBootstrap.channel(NioServerSocketChannel.class);

			//初始化器
			serverBootstrap.childHandler(new HttpServerInitializer());

			ChannelFuture channelFuture = serverBootstrap.bind(30301).sync();
			ChannelFuture sync = channelFuture.channel().closeFuture().sync();
		} finally {
			bossGroup.shutdownGracefully();
			workerGroup.shutdownGracefully();
		}
	}
}
