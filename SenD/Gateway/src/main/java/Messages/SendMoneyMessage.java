package Messages;

public class SendMoneyMessage extends Message{
    @Override
    public int getMessageType() {
        return Message.SendMoneyMessage;
    }
}
