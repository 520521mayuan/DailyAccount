<html>
<%@ page contentType="text/html; charset=utf8" %>
<%@ page language="java" %>
<%@ page import="com.mysql.jdbc.Driver" %>
<%@ page import="java.sql.*" %>
<%
//驱动程序名
String driverName="com.mysql.jdbc.Driver";
//数据库用户名
String userName="root";
//密码
String userPasswd="root";
//数据库名
String dbName="monthconsume";
//表名

//联结字符串
String url="jdbc:mysql://localhost/"+dbName+"?user="+userName+"&password="+userPasswd;
Class.forName("com.mysql.jdbc.Driver").newInstance();
Connection connection=DriverManager.getConnection(url);
Statement statement = connection.createStatement();
//statement.executeQuery("SET NAMES UTF8");
//String sql="select ((select sum(money) from things where (times between '2015-10-16' and '2015-11-15')) + (select sum(money) from detail where (times between '2015-10-16' and '2015-11-15'))) as date10_11";
//String sql="select ((select sum(money) from things where (times between date_sub(DATE_FORMAT(now(), '%Y-%m-14'),interval 1 month) and DATE_FORMAT(now(), '%Y-%m-15'))) + (select sum(money) from detail where (times between date_sub(DATE_FORMAT(now(), '%Y-%m-14'),interval 1 month) and DATE_FORMAT(now(), '%Y-%m-15')))) as date10_11";
String sql="select ((select sum(money) from things where (times between DATE_FORMAT(now(),'%Y-%m-1') and DATE_FORMAT(now(), '%Y-%m-%d'))) + (select sum(money) from detail where (times between DATE_FORMAT(now(),'%Y-%m-1') and DATE_FORMAT(now(), '%Y-%m-%d')))) as money2now";
ResultSet rs = statement.executeQuery(sql); 
//获得数据结果集合
ResultSetMetaData rmeta = rs.getMetaData();
//确定数据集的列数，亦字段数
//int numColumns=rmeta.getColumnCount();
// 输出每一个数据值
while(rs.next()) {
	String id =rs.getString("money2now");
	//	out.print("<br>");
} 
//out.print("<br>");
//out.print("数据库操作成功，恭喜你"); 
rs.close(); 
statement.close(); 
connection.close(); 
%>
</html>
