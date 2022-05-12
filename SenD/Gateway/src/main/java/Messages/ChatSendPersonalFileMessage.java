package Messages;

public class ChatSendPersonalFileMessage extends Message{
    @Override
    public int getMessageType() {
        return Message.ChatSendPersonalFileMessage;
    }
}
