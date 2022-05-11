package Messages;

public abstract class Message {
    public static final int UserMobileLoginMessage = 0;//手机号登陆
    public static final int UserIdLoginMessage = 1;//账号登陆
    public static final int UserRegisterMessage = 2;//注册
    public static final int ChatSendPersonalMessage = 3;//发送个人消息
    public static final int ReceivePersonalMessage = 4;//接收个人消息
    public static final int ChatSendGroupMessage = 5;//发送群消息
    public static final int ReceiveGroupMessage = 6;//接收群消息
    public static final int CreateGroupMessage = 7;//创建群聊
    public static final int DeleteGroupMessage = 8;//删除群聊
    public static final int AddGroupUserMessage = 9;//添加群成员
    public static final int DeleteGroupUserMessage = 10;//删除群成员
    public static final int SendMoneyMessage = 11;//发红包
    public static final int ReceiveMoneyMessage = 12;//收红包
    public static final int AuthenticationMessage = 13;//实名认证
    public static final int ChatSendPersonalFileMessage = 14;//传输文件
    public static final int ReceivePersonalFileMessage = 15;//接收文件
    public static final int ChatSendPersonalVoiceMessage = 16;//发送个人语音
    public static final int ReceivePersonalVoiceMessage = 17;//接收个人语音
    public static final int ChatSendGroupVoiceMessage = 18;//发送群语音
    public static final int ReceiveGroupVoiceMessage = 19;//接收群语音
    public abstract int getMessageType();
}
