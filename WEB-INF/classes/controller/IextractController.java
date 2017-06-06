package controller;

import util.Item;
import util.PageBean;

import java.util.List;

/**
 * Created by Administrator on 2017/5/8.
 */
public interface IextractController {
    public List<Item> extractfoods(int offset, int noOfRecords);
    public List<Item> extractgoods();
    public PageBean mohusearch1(String keyword,Integer pagenumber);
    public int getsumpage();
    public PageBean pageBean(String pagenumber);
}
