package server;

import config.PropertiesStore;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

import java.io.IOException;

public class NettyServer {
    public static void main(String[] args) {
        NioEventLoopGroup nioEventLoopGroup = new NioEventLoopGroup();
        NioEventLoopGroup nioEventLoopGroup1 = new NioEventLoopGroup();
        ServerBootstrap serverBootstrap = new ServerBootstrap();
        PropertiesStore propertiesStore = new PropertiesStore();
        try {
                serverBootstrap.group(nioEventLoopGroup,nioEventLoopGroup1)
                        .channel(NioServerSocketChannel.class)
                        .option(ChannelOption.SO_BACKLOG,1024)
                        .childOption(ChannelOption.SO_KEEPALIVE,true)
                        .childHandler(new ChannelInitializer<SocketChannel>() {
                            @Override
                            protected void initChannel(SocketChannel socketChannel) throws Exception {

                            }
                        });
            ChannelFuture server = serverBootstrap.bind(
                    Integer.parseInt(propertiesStore
                            .value("other.properties","server-port")))
                    .sync();
            server.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            nioEventLoopGroup.shutdownGracefully();
            nioEventLoopGroup1.shutdownGracefully();
        }
    }
}
