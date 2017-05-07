package controller;

import dao.Additemdao1;
import dao.Additemdao2;
import util.Item;

/**
 * Created by Administrator on 2017/5/7.
 */
public class SubitemController implements IsubController {
    @Override
    public Boolean subfoods(Item item) {
        Boolean flag=false;
        Additemdao1 additemdao1=new Additemdao1();
        flag=additemdao1.login(item);
        System.out.println("321");
        return  flag;
    }

    @Override
    public Boolean subgoods(Item item) {
        Boolean flag=false;
        Additemdao2 additemdao2=new Additemdao2();
        flag=additemdao2.login1(item);
        return flag;
    }
}
