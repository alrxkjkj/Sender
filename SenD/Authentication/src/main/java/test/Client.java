package test;



import java.util.UUID;


import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

public class Client {

    public static void main(String args[]) throws InterruptedException {

        EventLoopGroup group = new NioEventLoopGroup();
        try {
            Bootstrap b = new Bootstrap();
            b.group(group).channel(NioSocketChannel.class).handler(new ChannelInitializer<SocketChannel>() {
                @Override
                protected void initChannel(SocketChannel ch) throws Exception {
                    ChannelPipeline pipeline = ch.pipeline();
                    // 添加编码器
                    pipeline.addLast(new FFEncoder());
                    // 添加解码器
                    pipeline.addLast(new FFDecoder());
                    // 业务处理类（只打印了消息内容）
                    pipeline.addLast(new ClientHandler());
                }
            });

            // 连接服务端
            Channel ch = b.connect("127.0.0.1", 8888).sync().channel();
            int version = 1;
            String sessionId = UUID.randomUUID().toString();
            String str = "Hello!";

            // 发送1000000条消息
            for (int i = 0; i < 10; i++) {
                String content = str + "----" + i;
                FFHeader header = new FFHeader(version, content.length(), sessionId);
                FFMessage message = new FFMessage(header, content);
                ch.writeAndFlush(message);
            }

            ch.closeFuture().sync();

        } finally {
            group.shutdownGracefully();
        }
    }
}

