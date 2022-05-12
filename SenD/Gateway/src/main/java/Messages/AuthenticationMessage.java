package Messages;

public class AuthenticationMessage extends Message{
    @Override
    public int getMessageType() {
        return Message.AuthenticationMessage;
    }
}
