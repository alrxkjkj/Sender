package token;


import com.liqiang.SimpeEcode.MessageDecode;
import com.liqiang.SimpeEcode.MessageEncoder;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;

public class ServerChannelInitializer extends ChannelInitializer<SocketChannel> {

    private Server server;
    public ServerChannelInitializer(Server server) {
        this.server=server;
    }
    @Override
    protected void initChannel(SocketChannel channel) throws Exception {
        // TODO Auto-generated method stub
        channel.pipeline()

                .addLast("decoder",new MessageDecode())
                .addLast("encoder",new MessageEncoder())
                .addLast(new ServerHandle(server));
    }

}