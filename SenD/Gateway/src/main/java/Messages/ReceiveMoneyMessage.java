package Messages;

public class ReceiveMoneyMessage extends Message{
    @Override
    public int getMessageType() {
        return Message.ReceiveMoneyMessage;
    }
}
