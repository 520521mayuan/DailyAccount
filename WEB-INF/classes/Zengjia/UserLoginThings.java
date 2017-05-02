
package Zengjia;     
import java.sql.*;     
public class UserLoginThings {     
     public boolean login1(User user){     
    
        Connection conn=null;     
        PreparedStatement ps=null;     
             
        try{     
            Class.forName("com.mysql.jdbc.Driver");     
            conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/monthconsume?autoReconnect=true&useUnicode=true&characterEncoding=utf8","root","sqllife");
            String sql="insert into things(times,goods,money)values(?,?,?)";     
            ps=conn.prepareStatement(sql);     
            ps.setString(1,user.getxuehao());     
            ps.setString(2,user.getxingming());     
            ps.setString(3,user.getzhuanye());     
            int mun=ps.executeUpdate();     
        }catch(Exception e){     
        e.printStackTrace();     
        }finally{     
            try{     
                ps.close();     
                conn.close();     
            }catch(SQLException e){     
                e.printStackTrace();     
            }     
        }     
    
     return true;     
}     
}    
