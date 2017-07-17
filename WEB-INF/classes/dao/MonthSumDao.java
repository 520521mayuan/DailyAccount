package dao;
import java.util.*;
import java.sql.*;
import util.ConnectionFactory;
import util.Monthsum;
public class MonthSumDao{
	private Connection connection=ConnectionFactory.getCurrentConnection();
	private PreparedStatement statement;
	private ResultSet result;
	public List getmonthsum(){
		List list=new ArrayList();
		String sql="select m1,s1+s2 as s from (select year(times) as y1 ,month(times) as m1, sum(money) as s1 from detail where year(times)=year(curdate()) group by year(times),month(times)) as a join (select year(times) as y2,month(times) as m2, sum(money) as s2 from things where year(times)=year(curdate()) group by year(times),month(times)) as b on (a.y1=b.y2 and a.m1=b.m2);";
		try {
			statement=connection.prepareStatement(sql);
			result=statement.executeQuery();
			while (result.next()){
				list.add(new Monthsum(result));
			}
		}
		catch(Exception e) {

		}
		return list;
	}
}
