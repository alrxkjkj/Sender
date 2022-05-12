package Messages;

public class DeleteGroupUserMessage extends Message{
    @Override
    public int getMessageType() {
        return Message.DeleteGroupUserMessage;
    }
}
