package Messages;

public class ReceivePersonalFileMessage extends Message{
    @Override
    public int getMessageType() {
        return Message.ReceivePersonalFileMessage;
    }
}
