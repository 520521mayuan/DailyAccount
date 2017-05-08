package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    //ThreadLocal代表当前主线程，在程序运行过程中，只会存在一个ThreadLocal
    private static ThreadLocal<Connection> threadLocal = new ThreadLocal<>();

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static Connection getCurrentConnection(){

        Connection connection = threadLocal.get();//尝试从当前线程中获取Connection
        if (null == connection)//如果当前线程中，没有获取到Connection
            //手动创建
            try {
                connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/monthconsume","root","sqllife");
                threadLocal.set(connection);//将Connection对象放在当前线程
            } catch (SQLException e) {
                e.printStackTrace();
            }

        return connection;
    }

    public static void closeConnection(){
        Connection connection = threadLocal.get();//尝试从当前线程获取connection
        if (null != connection)//如果当前线程中，存在该对象
            //关闭connection
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
    }

}
