package my.suveng.netty.learn.socket;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.time.LocalDateTime;

/**
 * description:
 * 
 * @author suwenguang
 * 
 * @version 1.0.0
 **/
public class StringSocketClientHandler extends SimpleChannelInboundHandler<String> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
        System.out.printf("client#接收到消息#地址=%s#消息=%s\n", ctx.channel().remoteAddress(), msg);
        ctx.writeAndFlush(LocalDateTime.now().toString());
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        // super.exceptionCaught(ctx, cause);
        cause.printStackTrace();
        ctx.close();
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        ctx.writeAndFlush("hello,server!");
    }
}
