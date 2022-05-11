package token;


import java.util.Date;


public class nettyMain {
    public static void main(String[] args) {
        new Thread(new Runnable() {

            @Override
            public void run() {
                // TODO Auto-generated method stub
                Server server = new Server(8081);
                server.start();

            }
        }).start();
        new Thread(new Runnable() {

            @Override
            public void run() {
                // TODO Auto-generated method stub
                Client client1 = new Client("127.0.0.1", 8081);
                client1.connection();
                String content = "哈哈哈哈！";
                byte[] bts = content.getBytes();
                MessageHead head = new MessageHead();
                // 令牌生成时间
                head.setCreateDate(new Date());

                head.setLength(bts.length);
                Message message = new Message(head, bts);
                message.getHead().setToken(message.buidToken());

                message.getHead().setToken(message.buidToken());
                client1.sendMsg(message);
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

                //token错误 则认为是非法客户端会关闭连接
                message.getHead().setToken("fff");

                client1.sendMsg(message);
                //再次发送 服务端则收不到
                message.getHead().setToken(message.buidToken());
                client1.sendMsg(message);

            }
        }).start();
    }

}
