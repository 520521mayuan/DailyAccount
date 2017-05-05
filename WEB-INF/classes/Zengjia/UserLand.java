
     
package Zengjia;     
import until.ConnectionFactory;

import java.sql.*;
    
public class UserLand {
    private Connection connection=ConnectionFactory.getCurrentConnection();
    private PreparedStatement statement;
    private ResultSet resultSet;


    public boolean login(User user) {
        String sql = "Select Id from detail";
        boolean flag=false;
        try {
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                if (user.getDateTimes().equals(resultSet.getString("DateTimes"))) {
                    flag=true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flag;
    }
    
}   
