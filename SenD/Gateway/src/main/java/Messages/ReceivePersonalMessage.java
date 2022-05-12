package Messages;

public class ReceivePersonalMessage extends Message{
    @Override
    public int getMessageType() {
        return Message.ReceivePersonalMessage;
    }
}
