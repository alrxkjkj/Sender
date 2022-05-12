package Messages;

public class UserRegisterMessage extends Message{
    @Override
    public int getMessageType() {
        return Message.UserRegisterMessage;
    }
}
