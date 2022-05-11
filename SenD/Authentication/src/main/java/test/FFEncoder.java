package test;


import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

/**
 * 编码器
 *FFMessage
 */
public class FFEncoder extends MessageToByteEncoder<FFMessage> {

    @Override
    protected void encode(ChannelHandlerContext ctx, FFMessage message, ByteBuf out) throws Exception {
        // 将Message转换成二进制数据
        FFHeader header = message.getLuckHeader();
        // 写入Header信息
        out.writeInt(header.getVersion());
        out.writeInt(header.getContentLength());
        out.writeBytes(header.getSessionId().getBytes());

        // 写入消息主体信息
        out.writeBytes(message.getContent().getBytes());
    }
}
