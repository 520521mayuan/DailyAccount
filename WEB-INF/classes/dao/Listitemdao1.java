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
    //获取连接
    private Connection connection= ConnectionFactory.getCurrentConnection();
    //声明statement
    private PreparedStatement statement;
    //声明结果集
	private ResultSet resultSet;

    private int noOfRecordss;
    public List<Item> litallitem1(int pagenumber, int pagesize){
        List Itemlist=new ArrayList();
        String sql="select SQL_CALC_FOUND_ROWS * from detail limit ?,? ";
        try {
            statement=connection.prepareStatement(sql);
            statement.setInt(1, (pagenumber - 1) * pagesize);
            statement.setInt(2, pagesize);
            resultSet=statement.executeQuery();
            while (resultSet.next()){
                Item item=new Item(resultSet);
                Itemlist.add(item);
            }
            resultSet.close();
            statement= connection.prepareStatement("SELECT FOUND_ROWS()");
            resultSet=statement.executeQuery();
            while (resultSet.next()){
                noOfRecordss=resultSet.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return Itemlist;
	
    }
	public int getNoOfRecords() {
        return noOfRecordss;
	}

    public List<Item> mohuosearch1(String keyword, Integer pagenumber,Integer pagesize){
        List<Item> list=new ArrayList<>();
        String sql="select SQL_CALC_FOUND_ROWS * from detail where goods like ? limit ?,? ";
        try {
            statement=connection.prepareStatement(sql);
            statement.setString(1,"%"+keyword+"%");
            statement.setInt(2,(pagenumber-1)*pagesize);
            statement.setInt(3,pagesize);
            resultSet=statement.executeQuery();
            while (resultSet.next()){
                Item item=new Item(resultSet);
                list.add(item);
            }
            resultSet.close();
            statement= connection.prepareStatement("SELECT FOUND_ROWS()");
            resultSet=statement.executeQuery();
            while (resultSet.next()){
                noOfRecordss=resultSet.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

}
