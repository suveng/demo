package my.suveng.netty.learn.http;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpServerCodec;

/**
 * description: 初始化器
 * 
 * @author suwenguang
 * 
 * @version 1.0.0
 **/
public class HttpServerInitializer extends ChannelInitializer<SocketChannel> {

    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        //
        ChannelPipeline pipeline = ch.pipeline();

        //
        pipeline.addLast("httpServerCodec", new HttpServerCodec());
        pipeline.addLast("firstHandler", new FirstHttpServerHandler());

    }
}
