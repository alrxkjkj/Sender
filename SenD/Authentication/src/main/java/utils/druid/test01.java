package utils.druid;

import utils.xml.XmlReaders;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

public class test01 {
    public static void main(String[] args) {

        //String sql;
        Connection connection = null;
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;

        try {
            HashMap<String, String> map = XmlReaders.getSql("sql.xml", "sqls/sql");

            connection = DruidRead.getConnection();   //获取数据库连接
            String sql = map.get("LOGIN_INQUIRE");

            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,"sl1");
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                //Integer id = resultSet.getInt("id");
                //String name = resultSet.getString("name");
                String password = resultSet.getString("password");
                if(!password.equals(password)){
                    System.out.println(false);
                }else {
                    System.out.println(true);
                }
            }
            System.out.println("dewdewde");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DruidRead.close(connection,resultSet,preparedStatement);   //释放资源
        }

    }
}
