package Messages;

public class ReceiveGroupMessage extends Message{
    @Override
    public int getMessageType() {
        return Message.ReceiveGroupMessage;
    }
}
