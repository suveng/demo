package my.suveng.netty.learn.promote_protobuf;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import my.suveng.netty.learn.promote_protobuf.proto.MessageProto;
import my.suveng.netty.learn.protobuf.DataInfoPra;

import java.util.UUID;

/**
 * description:
 * @author suwenguang
 * @version 1.0.0
 **/
public class MyServerHandler extends SimpleChannelInboundHandler<MessageProto.Message> {

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
		//super.exceptionCaught(ctx, cause);
		cause.printStackTrace();
		ctx.close();
	}


	@Override
	protected void channelRead0(ChannelHandlerContext ctx, MessageProto.Message msg) throws Exception {
		String uuid = UUID.randomUUID().toString();
		System.out.printf("server#接收到消息#地址=%s#消息=%s#uuid=%s\n", ctx.channel().remoteAddress(), msg.toString(), uuid);
		if (msg.getType().equals(MessageProto.Message.Type.CatType)){
			System.out.println("获取猫类型");
			System.out.println(msg.getCat());
		}
		ctx.channel().writeAndFlush(uuid);
	}
}
