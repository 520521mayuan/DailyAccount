
package Zengjia;     
import until.ConnectionFactory;

import java.sql.*;
public class UserLogin {
    Connection connection= ConnectionFactory.getCurrentConnection();
    PreparedStatement statement;
    ResultSet resultSet;
     public boolean login(User user) {
         boolean flag=true;
         String sql="insert into detail(times,goods,money)values(?,?,?)";
         try {
             statement=connection.prepareStatement(sql);
             statement.setString(1,user.getxuehao());
             statement.setString(2,user.getxingming());
             statement.setString(3,user.getzhuanye());
             int i = statement.executeUpdate();
             flag = i == 1 ? true : false;
         } catch (SQLException e) {
             e.printStackTrace();
         }
         return flag;
     }
}    
