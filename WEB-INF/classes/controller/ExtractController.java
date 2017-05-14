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
	private Listitemdao1 listitemdao1=new Listitemdao1();
    @Override
    public List<Item> extractfoods(int offset,int noOfRecords) {
	List<Item> list=listitemdao1.litallitem1(offset,noOfRecords);
        return list;
    }

    @Override
    public List<Item> extractgoods() {
        Listitemdao2 listitemdao2=new Listitemdao2();
        List<Item> list=listitemdao2.litallitem2();
        return list;
    }

    @Override
    public int getsumpage() {
        int sumpage=listitemdao1.getNoOfRecords();
        return sumpage;
    }
    public List<Item> mohusearch1(String keyword){
        List<Item> list=listitemdao1.mohuosearch1(keyword);
        return list;
    }
}
