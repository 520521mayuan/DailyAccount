
package dao;

import util.ConnectionFactory;
import util.Item;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Additemdao1 {
    Connection connection= ConnectionFactory.getCurrentConnection();
    PreparedStatement statement;
     public boolean login(Item item) {
         boolean flag=true;
         String sql="insert into detail(times,goods,money)values(?,?,?)";
         try {
             statement=connection.prepareStatement(sql);
             statement.setString(1,item.getDateTimes());
             statement.setString(2,item.getGoods());
             statement.setString(3,item.getSums());
             int i = statement.executeUpdate();
             flag = i == 1 ? true : false;
         } catch (SQLException e) {
             e.printStackTrace();
         }
         return flag;
     }
}    
