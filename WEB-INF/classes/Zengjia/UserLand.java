
     
package Zengjia;     
import java.sql.*;     
    
public class UserLand {     
    public boolean login(User user){     
        Connection conn=null;     
        PreparedStatement ps=null;     
        ResultSet rs=null;     
        try{     
            Class.forName("com.mysql.jdbc.Driver");     
            conn=DriverManager.getConnection(     
                    "jdbc:mysql://localhost:3306/monthconsume","root","sqllife");     
            String sql="Select Id from detail";     
            ps=conn.prepareStatement(sql);     
                       rs=ps.executeQuery();     
            while(rs.next()){     
                if(user.getxuehao().equals(rs.getString("xuehao"))){     
                return true;     
                }     
            }     
            //return false;     
        }catch(Exception e){     
            e.printStackTrace();     
        }finally{     
            try{     
    //            rs.close();     
                ps.close();     
                conn.close();     
            }catch(SQLException e){     
                e.printStackTrace();     
            }     
        }     
        return false;     
    }     
    
}   
