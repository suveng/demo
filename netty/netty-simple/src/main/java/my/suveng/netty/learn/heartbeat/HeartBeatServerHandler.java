package my.suveng.netty.learn.heartbeat;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.timeout.IdleStateEvent;

/**
 *
 * @author suwenguang
 * 
 * @version 1.0.0
 **/
public class HeartBeatServerHandler extends ChannelInboundHandlerAdapter {

    /**
     * 用户时间触发
     * 
     * @author suwenguang
     * 
     * @date 2019/10/6
     */
    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        // 如果event是IdleStateEvent,强转
        if (evt instanceof IdleStateEvent) {
            IdleStateEvent idleStateEvent = (IdleStateEvent) evt;
            String eventType = null;

            switch (idleStateEvent.state()) {
            case ALL_IDLE:
                eventType = "读写空闲";
                break;
            case READER_IDLE:
                eventType = "读空闲";
                break;
            case WRITER_IDLE:
                eventType = "写空闲";
                break;
            default:

            }
            Channel channel = ctx.channel();
            System.out.println(channel.remoteAddress() + "-" + eventType + ",关闭channel");
            channel.close();
        }
    }
}
