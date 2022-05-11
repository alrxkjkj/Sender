package server;

public abstract class Message {
    //登陆
    public static final int UserLoginMessage = 0;
    //注册
    public static final int UserRegisterMessage = 1;
    public abstract int getMessageType();
}
