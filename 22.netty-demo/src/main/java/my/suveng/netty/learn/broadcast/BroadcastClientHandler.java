package my.suveng.netty.learn.broadcast;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 *
 * @author suwenguang
 * @version 1.0.0
 **/
public class BroadcastClientHandler extends SimpleChannelInboundHandler<String> {
	@Override
	protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
		System.out.println(msg + "\n");
	}


}
