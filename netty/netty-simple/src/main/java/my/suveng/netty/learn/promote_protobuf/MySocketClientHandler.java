package my.suveng.netty.learn.promote_protobuf;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import my.suveng.netty.learn.promote_protobuf.proto.MessageProto;
import my.suveng.netty.learn.protobuf.DataInfoPra;

import java.time.LocalDateTime;

/**
 * description:
 * 
 * @author suwenguang
 * 
 * @version 1.0.0
 **/
public class MySocketClientHandler extends SimpleChannelInboundHandler<MessageProto.Message> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, MessageProto.Message msg) throws Exception {
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
        // DataInfoPra.Info build = DataInfoPra.Info.newBuilder().setAge("123").setName("123").setTime("222").build();
        MessageProto.Message message = MessageProto.Message.newBuilder().setType(MessageProto.Message.Type.CatType)
                .setCat(MessageProto.Cat.newBuilder().setName("123")).build();
        ctx.writeAndFlush(message);
    }
}
