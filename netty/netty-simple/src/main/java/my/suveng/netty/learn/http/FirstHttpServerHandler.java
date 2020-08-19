package my.suveng.netty.learn.http;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.*;
import io.netty.util.CharsetUtil;

/**
 * description: 处理器
 * 
 * @author suwenguang
 * 
 * @version 1.0.0
 **/
public class FirstHttpServerHandler extends SimpleChannelInboundHandler<HttpObject> {

    /**
     * <strong>Please keep in mind that this method will be renamed to {@code messageReceived(ChannelHandlerContext, I)}
     * in 5.0.</strong>
     *
     * Is called for each message of type {@link }.
     *
     * @param ctx
     *            the {@link ChannelHandlerContext} which this {@link SimpleChannelInboundHandler} belongs to
     * @param msg
     *            the message to handle
     * 
     * @throws Exception
     *             is thrown if an error occurred
     */
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, HttpObject msg) throws Exception {
        if (msg instanceof HttpRequest) {

            // 处理数据
            ByteBuf content = Unpooled.copiedBuffer("hello worldddd", CharsetUtil.UTF_8);

            // 构造返回reponse
            FullHttpResponse response = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.OK,
                    content);
            response.headers().set(HttpHeaderNames.CONTENT_TYPE, "text/plain");
            response.headers().set(HttpHeaderNames.CONTENT_LENGTH, content.readableBytes());

            // 返回
            System.out.println(String.format("接收到请求#uri=%s#返回=%s", ((HttpRequest) msg).uri(),
                    content.toString(CharsetUtil.UTF_8)));
            ctx.writeAndFlush(response);

        }

    }
}
