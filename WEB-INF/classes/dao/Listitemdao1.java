package dao;

import util.ConnectionFactory;
import util.Item;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/5/8.
 */
public class Listitemdao1 {
    private Connection connection= ConnectionFactory.getCurrentConnection();
    private PreparedStatement statement;
	private ResultSet resultSet;
	// 未获取到条目数
	// private PreparedStatement statement1;
	// private ResultSet resultSet1;
	// 未获取到条目数
	private int noOfRecords;

    public List<Item> litallitem1(int offset, 
                int noOfRecords){
        List Itemlist=new ArrayList();
        String sql="select SQL_CALC_FOUND_ROWS * from detail limit " + offset + ", " + noOfRecords;
        try {
            statement=connection.prepareStatement(sql);
            resultSet=statement.executeQuery();
            while (resultSet.next()){
                Item item=new Item(resultSet);
                Itemlist.add(item);
            }
	    // 未获取到条目数
	    // statement1=connection.prepareStatement("SELECT FOUND_ROWS()");
            // resultSet1=statement.executeQuery();
            // if(resultSet1.next())
	    // 	    this.noOfRecords = resultSet1.getInt(1);
	    // 未获取到条目数
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return Itemlist;
	
    }
	public int getNoOfRecords() {
		return noOfRecords;
	}

    public List<Item> mohuosearch1(String keyword){
        List<Item> list=new ArrayList<>();
        String sql="select * from detail where goods like ?";
        try {
            statement=connection.prepareStatement(sql);
            statement.setString(1,"%"+keyword+"%");
            resultSet=statement.executeQuery();
            while (resultSet.next()){
                Item item=new Item(resultSet);
                list.add(item);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

}
