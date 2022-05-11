package test;


import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

public class ServerHandler extends SimpleChannelInboundHandler<FFMessage> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, FFMessage msg) throws Exception {
        // 简单地打印出server接收到的消息
        System.out.println("接收:"+msg);
    }
}

