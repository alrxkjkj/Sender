package Messages;

public class CreateGroupMessage extends Message{
    @Override
    public int getMessageType() {
        return Message.CreateGroupMessage;
    }
}
