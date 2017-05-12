package dao;

import util.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Administrator on 2017/5/8.
 */
public class Deleteitemdao1 {
    private Connection connection= ConnectionFactory.getCurrentConnection();
    private PreparedStatement statement;
    private ResultSet resultSet;
    public Boolean deleteItem(String itemid){
        Boolean flag=false;
        int index=Integer.parseInt(itemid);
        String sql="Delete from detail where Id=?";
        try {
            statement=connection.prepareStatement(sql);
            statement.setInt(1,index);
           int i= statement.executeUpdate();
            flag=i==1?true:false;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flag;
    }
}
