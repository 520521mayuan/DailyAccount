
package Zengjia;     
import java.sql.*;     
public class UserLogin {     
     public boolean login(User user){     
    
        Connection conn=null;     
        PreparedStatement ps=null;     
             
        try{     
            Class.forName("com.mysql.jdbc.Driver");     
            conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/monthconsume?autoReconnect=true&useUnicode=true&characterEncoding=utf8","root","sqllife");
            String sql="insert into detail(times,goods,money)values(?,?,?)";     
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
