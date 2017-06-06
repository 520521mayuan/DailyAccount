package util;

import java.util.List;

/**
 * Created by Administrator on 2017/5/15.
 */
public class PageBean {
    private Integer pagenumber;
    private Integer pagesize=5;
    private Integer totalRow;
    private Integer pageCount;
    private Integer nextNumber;
    private Integer previousNumber;
    private List<Item> pageData;

    public Integer getPagenumber() {
        return pagenumber;
    }

    public void setPagenumber(Integer pagenumber) {
        this.pagenumber = pagenumber;
    }

    public Integer getPagesize() {
        return pagesize;
    }

    public Integer getTotalRow() {
        return totalRow;
    }

    public void setTotalRow(Integer totalRow) {
        this.totalRow = totalRow;
    }

    @Override
    public String toString() {
        return "PageBean{" +
                "pagenumber=" + pagenumber +
                ", pagesize=" + pagesize +
                ", totalRow=" + totalRow +
                ", pageCount=" + pageCount +
                ", nextNumber=" + nextNumber +
                ", previousNumber=" + previousNumber +
                ", pageData=" + pageData +
                '}';
    }

    public Integer getPageCount() {
        return pageCount;
    }

    public Integer getNextNumber() {
        Integer flag=getPageCount();
        if(pagenumber==flag){
            return pagenumber;
        }

        return pagenumber+1;
    }

    public Integer getPreviousNumber() {
        if (pagenumber == 1) {
        return pagenumber;
        }
        return pagenumber-1;
    }

    public List<Item> getPageData() {
        return pageData;
    }

    public void setPageData(List<Item> pageData) {
        this.pageData = pageData;
    }

    public void  setPageCount(Integer totalRow){
        pageCount=totalRow%this.getPagesize()==0?totalRow/this.getPagesize():totalRow/this.getPagesize()+1;
    }
}
