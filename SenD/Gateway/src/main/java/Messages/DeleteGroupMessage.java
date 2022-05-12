package Messages;

public class DeleteGroupMessage extends Message{
    @Override
    public int getMessageType() {
        return Message.DeleteGroupMessage;
    }
}
