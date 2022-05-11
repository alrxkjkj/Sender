package nettyxy;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageCodec;

import java.util.List;

public class MessageCodec extends ByteToMessageCodec<Message> {

    @Override
    protected void encode(ChannelHandlerContext channelHandlerContext, Message message, ByteBuf byteBuf) throws Exception {
        byteBuf.writeBytes(new byte[]{1,2,3,4}); //魔数
        byteBuf.writeByte(1); //版本号
        byteBuf.writeByte(1); //序列化方式
        byteBuf.writeByte(message.getMessage()); //指令类型
        byteBuf.writeInt(4);  //请求序号
    }

    @Override
    protected void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws Exception {

    }
}
