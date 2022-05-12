package Messages;

public class ChatSendGroupMessage extends Message{
    @Override
    public int getMessageType() {
        return Message.ChatSendGroupMessage;
    }
}
