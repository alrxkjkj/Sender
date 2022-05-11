package user;

import utils.druid.DruidRead;
import utils.druid.DruidWrite;
import utils.xml.XmlReaders;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

public class usertest extends User{
    @Override
    public boolean userLogin(String username, String passwoed1) {
        if(username == null || passwoed == null){
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
            preparedStatement.setString(1, username);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                String password = resultSet.getString("password");
                return password.equals(passwoed1)?true:false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DruidRead.close(connection,resultSet,preparedStatement);   //释放资源
        }
        return false;
    }

    public static void main(String[] args) {
        /*User user = new usertest();
        user.setUesername("张三");
        user.setPasswoed("7b980a619bd7064591c1eafeb704e50a");
        System.out.println(user.getUesername()+"  "+user.getPasswoed());
        boolean b = user.userLogin(user.getUesername(), user.getPasswoed());
        System.out.println(b);*/
        Connection connection = null;
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;

        try {
            HashMap<String, String> map = XmlReaders.getSql("sql.xml", "sqls/sql");

            connection = DruidWrite.getConnection();   //获取数据库连接
            String sql = map.get("zc");
            //
            Date date = new Date();
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            //从前端或者自己模拟一个日期格式，转为String即可
            String dateStr = format.format(date);
            System.out.println(dateStr);
            //
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, "zhangsan");
            preparedStatement.setString(2,"123456");
            preparedStatement.setString(3,dateStr);
            int i = preparedStatement.executeUpdate();
            System.out.println(i);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DruidRead.close(connection,resultSet,preparedStatement);   //释放资源
        }
    }
}
