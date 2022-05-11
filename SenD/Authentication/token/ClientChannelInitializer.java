package token;



import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;

public class ClientChannelInitializer extends ChannelInitializer<SocketChannel> {

    private Client client;
    public  ClientChannelInitializer(Client client) {
        // TODO Auto-generated constructor stub
        this.client=client;
    }
    @Override
    protected void initChannel(SocketChannel socketChannel) throws Exception {
        // TODO Auto-generated method stub
        socketChannel.pipeline()
                .addLast("encoder",new MessageEncoder())
                .addLast("decode",new MessageDecode())
                .addLast(new ClientHandle(client));//注册处理器

    }
}
