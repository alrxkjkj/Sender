package Messages;

public class ChatSendPersonalVoiceMessage extends Message{
    @Override
    public int getMessageType() {
        return Message.ChatSendPersonalVoiceMessage;
    }
}
