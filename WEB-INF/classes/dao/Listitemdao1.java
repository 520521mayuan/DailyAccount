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
	private int noOfRecordss;

    public List<Item> litallitem1(int offset, int noOfRecords){
        List Itemlist=new ArrayList();
        String sql="select SQL_CALC_FOUND_ROWS * from detail limit " + offset + ", " + noOfRecords;
        try {
            statement=connection.prepareStatement(sql);
            resultSet=statement.executeQuery();
            while (resultSet.next()){
                Item item=new Item(resultSet);
                Itemlist.add(item);
            }
	    resultSet.close();
	    statement=connection.prepareStatement("SELECT FOUND_ROWS()");
	    resultSet=statement.executeQuery();
	    if(resultSet.next())
		    noOfRecordss = resultSet.getInt(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return Itemlist;
	
    }
	public int getNoOfRecords() {
		return noOfRecordss;
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
