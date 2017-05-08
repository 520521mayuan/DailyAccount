package controller;

import dao.Additemdao1;
import dao.Additemdao2;
import util.Item;

/**
 * Created by Administrator on 2017/5/7.
 */
public class SubitemController implements IsubController {

    @Override
    public Boolean subgoods(String submit, Item item) {
        Boolean flag=null;
        if(submit!=null&&submit.equals("提交餐饮记录")){
            Additemdao1 additemdao1=new Additemdao1();
            flag=additemdao1.login(item);
        }else {
            Additemdao2 additemdao2=new Additemdao2();
            flag=additemdao2.login1(item);
        }
        return flag;
    }
}
