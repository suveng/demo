package my.suveng.netty.learn.socket;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.util.UUID;

/**
 * description:
 * @author suwenguang
 * @version 1.0.0
 **/
public class StringSocketServerHandler extends SimpleChannelInboundHandler<String> {
	@Override
	protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
		String uuid = UUID.randomUUID().toString();
		System.out.printf("server#接收到消息#地址=%s#消息=%s#uuid=%s\n", ctx.channel().remoteAddress(), msg, uuid);
		ctx.channel().writeAndFlush(uuid);
	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
		//super.exceptionCaught(ctx, cause);
		cause.printStackTrace();
		ctx.close();
	}
}
