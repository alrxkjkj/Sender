package utils.druid;

import utils.xml.XmlReaders;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

public class test {
    public static void main(String[] args) {

        //String sql;
            Connection connection = null;
            ResultSet resultSet = null;
            PreparedStatement preparedStatement = null;

            try {
                connection = DruidRead.getConnection();   //获取数据库连接
                String sql = "select * from user";
                preparedStatement = connection.prepareStatement(sql);
                resultSet = preparedStatement.executeQuery();
                while (resultSet.next()){
                    Integer id = resultSet.getInt("id");
                    String name = resultSet.getString("name");
                    String password = resultSet.getString("password");
                    System.out.println(id+name+password);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                DruidRead.close(connection,resultSet,preparedStatement);   //释放资源
            }

    }
    public String getsql(String id){
        HashMap<String, String> map = XmlReaders.getSql("sql.xml", "sqls/sql");
        for (String key : map.keySet())
        {
            return map.get(key);
        }
        return null;
    }
}
