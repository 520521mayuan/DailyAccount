package controller;

import dao.Listitemdao1;
import dao.Listitemdao2;
import util.Item;
import util.PageBean;
import java.util.List;

/**
 * Created by 高芳健 on 2017/5/8.
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
    public PageBean mohusearch1(String keyword,Integer pagenumber){
        Listitemdao1 listitemdao1=new Listitemdao1();
        List<Item> list=listitemdao1.mohuosearch1(keyword,pagenumber,5);
        PageBean pageBean=new PageBean();
        pageBean.setPagenumber(pagenumber);
        pageBean.setPageData(list);
        pageBean.setTotalRow(listitemdao1.getNoOfRecords());
        System.out.println(listitemdao1.getNoOfRecords());
        pageBean.setPageCount(pageBean.getTotalRow());

        return pageBean;
    }

    public PageBean pageBean(String pagenumber){
        Listitemdao1 listitemdao1=new Listitemdao1();
        List<Item> items=listitemdao1.litallitem1(Integer.valueOf(pagenumber),5);
        PageBean pageBean=new PageBean();
        pageBean.setPagenumber(Integer.valueOf(pagenumber));
        pageBean.setPageData(items);
        pageBean.setTotalRow(listitemdao1.getNoOfRecords());
        pageBean.setPageCount(pageBean.getTotalRow());
        return pageBean;

    }
}
