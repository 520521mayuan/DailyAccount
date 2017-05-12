import dao.Listitemdao1;
import dao.Listitemdao2;
import org.junit.Test;
import util.Item;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/5/8.
 */
public class TestItemList {

    @Test
    public void testitemlist() {
        List<Item> list = new ArrayList<Item>();
        Listitemdao1 listitemdao1 = new Listitemdao1();
        list = listitemdao1.litallitem1();
        for (Item item:list){
            System.out.println(item);
        }
    }

    @Test
    public void testitemlist2() {
        List<Item> list = new ArrayList<Item>();
        Listitemdao2 listitemdao2 = new Listitemdao2();
        list = listitemdao2.litallitem2();
        for (Item item:list){
            System.out.println(item);
        }
    }

    @Test
    public void  testmohusearch(){
        Listitemdao1 listitemdao1=new Listitemdao1();
        List <Item> list=listitemdao1.mohuosearch1("浆");
        for (Item item:list){
            System.out.println(item);
        }
    }
}
