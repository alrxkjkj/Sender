package Messages;

public class ChatSendPersonalMessage extends Message{
    @Override
    public int getMessageType() {
        return Message.ChatSendPersonalMessage;
    }
}
