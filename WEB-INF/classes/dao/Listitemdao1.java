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

    public List<Item> litallitem1(){
        List Itemlist=new ArrayList();
        String sql="select * from detail";
        try {
            statement=connection.prepareStatement(sql);
            resultSet=statement.executeQuery();
            while (resultSet.next()){
                Item item=new Item(resultSet);
                Itemlist.add(item);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return Itemlist;
    }

}
