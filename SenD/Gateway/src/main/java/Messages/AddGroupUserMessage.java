package Messages;

public class AddGroupUserMessage extends Message{
    @Override
    public int getMessageType() {
        return Message.AddGroupUserMessage;
    }
}
