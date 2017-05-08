package controller;

import dao.Listitemdao1;
import dao.Listitemdao2;
import util.Item;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/5/8.
 */
public class ExtractController implements IextractController {
    @Override
    public List<Item> extractfoods() {
        List<Item> list=new ArrayList<>();
        Listitemdao1 listitemdao1=new Listitemdao1();
        list=listitemdao1.litallitem1();
        return list;
    }

    @Override
    public List<Item> extractgoods() {
        List<Item> list=new ArrayList<>();
        Listitemdao2 listitemdao2=new Listitemdao2();
        list=listitemdao2.litallitem2();
        return list;
    }
}
