package my.suveng.netty.learn.broadcast;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.util.concurrent.GlobalEventExecutor;

/**
 * description:
 * @author suwenguang
 * @version 1.0.0
 **/
public class BroadcastServerHandler extends SimpleChannelInboundHandler<String> {

	private static final ChannelGroup channelGroup = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);

	@Override
	protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
		Channel channel = ctx.channel();

		channelGroup.forEach(ch -> {
			if (ch.equals(channel)) {
				ch.writeAndFlush("[自己]:" + msg + "\n");
			} else {
				ch.writeAndFlush(channel.remoteAddress() + ":" + msg + "\n");
			}
		});
	}

	@Override
	public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
		Channel channel = ctx.channel();

		channelGroup.add(channel);

		channelGroup.writeAndFlush("[服务器]:" + channel.remoteAddress() + "加入");
	}

	@Override
	public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
		Channel channel = ctx.channel();

		channelGroup.writeAndFlush("[服务器]:" + channel.remoteAddress() + "退出");

		channelGroup.remove(channel);
	}

	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		Channel channel = ctx.channel();
		System.out.println(channel.remoteAddress() + "上线了");
	}

	@Override
	public void channelInactive(ChannelHandlerContext ctx) throws Exception {
		Channel channel = ctx.channel();
		System.out.println(channel.remoteAddress() + "下线了");
	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
		cause.printStackTrace();
		ctx.close();
	}
}
