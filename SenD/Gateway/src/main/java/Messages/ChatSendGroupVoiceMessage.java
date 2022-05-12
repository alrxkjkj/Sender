package Messages;

public class ChatSendGroupVoiceMessage extends Message{
    @Override
    public int getMessageType() {
        return Message.ChatSendGroupVoiceMessage;
    }
}
