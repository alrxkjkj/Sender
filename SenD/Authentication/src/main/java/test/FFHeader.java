package test;


//消息的头部
public class FFHeader {

    /*
+---------------------------------------------------------------+
| 魔数 2byte | 协议版本号 1byte | 序列化算法 1byte | 报文类型 1byte  |
+---------------------------------------------------------------+
| 状态 1byte |        请求序号 4byte     |      数据长度 4byte     |
+---------------------------------------------------------------+
|                   数据内容 （长度不定）                          |
+---------------------------------------------------------------+
*/
    // 魔数
    private String cipher;
    // 协议版本
    private int version;
    //算法
    private int algorithm;
    // 服务名称  报文类型
    private String sessionId;
    // 状态
    private int status;
    //保留字段
    private int other;
    // 消息内容长度
    private int contentLength;


    public FFHeader(int version, int contentLength, String sessionId) {
        this.version = version;
        this.sessionId = sessionId;
        this.contentLength = contentLength;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public int getContentLength() {
        return contentLength;
    }

    public void setContentLength(int contentLength) {
        this.contentLength = contentLength;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }
}

