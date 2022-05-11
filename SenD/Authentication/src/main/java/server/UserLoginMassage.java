package server;

import utils.druid.DruidRead;
import utils.xml.XmlReaders;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

public class UserLoginMassage extends Message{
    //用户
    //密码
    @Override
    public int getMessageType() {
        return UserLoginMessage;
    }
    public boolean userLogin(String username,String password){
        if (username == null || password == null) {
            return false;
        }
        Connection connection = null;
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;

        try {
            HashMap<String, String> map = XmlReaders.getSql("sql.xml", "sqls/sql");

            connection = DruidRead.getConnection();   //获取数据库连接
            String sql = map.get("LOGIN_INQUIRE");

            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,username);
            resultSet = preparedStatement.executeQuery();
            /*while (resultSet.next()){
                String password1 = resultSet.getString("password");
                return password.equals(password1)
            }*/
            if (resultSet.next()){
                String password1 = resultSet.getString("password");
                return password.equals(password1)?true:false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DruidRead.close(connection,resultSet,preparedStatement);   //释放资源
        }
        return false;
    }

    public static void main(String[] args) {
        UserLoginMassage userLoginMassage = new UserLoginMassage();
        boolean zhangsan = userLoginMassage.userLogin("zhangs", "12345");
        System.out.println(zhangsan);
    }
}
