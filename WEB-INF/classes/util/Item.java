
package util;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Item {
    //private Integer uid;     
    private String DateTimes;     
    private String Goods;
    private String Sums;

    @Override
    public String toString() {
        return "Item{" +
                "DateTimes='" + DateTimes + '\'' +
                ", Goods='" + Goods + '\'' +
                ", Sums='" + Sums + '\'' +
                '}';
    }

    public Item(){

    }

    public Item(ResultSet resultSet) {
        try {
            this.DateTimes=resultSet.getString("times");
            this.Goods=resultSet.getString("goods");
            this.Sums=resultSet.getString("money");

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


    public String getDateTimes(){     
        return DateTimes;     
    }     
    public void setDateTimes(String DateTimes){     
        this.DateTimes=DateTimes;     
    }     
    public String getGoods(){     
        return Goods;     
    }     
    public void setGoods(String Goods){     
        this.Goods=Goods;    
    }     
    public String getSums(){     
        return Sums;     
    }     
    public void setSums(String Sums){     
        this.Sums=Sums;    
    }     
}    
