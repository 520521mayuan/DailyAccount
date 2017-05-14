package controller;

import util.Item;

import java.util.List;

/**
 * Created by Administrator on 2017/5/8.
 */
public interface IextractController {
    public List<Item> extractfoods(int offset,int noOfRecords);
    public List<Item> extractgoods();
    public List<Item> mohusearch1(String keyword);
    public int getsumpage();
}
