package web;
import controller.IsubController;
import controller.SubitemController;
import dao.Additemdao1;
import dao.Additemdao2;
import util.Item;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
public class Itemservlet extends HttpServlet {
    public void doGet(HttpServletRequest request,HttpServletResponse response)
            throws ServletException,IOException{
    }
    public void doPost(HttpServletRequest request,HttpServletResponse response)
            throws ServletException,IOException{
        request.setCharacterEncoding("UTF-8");
        String submit=request.getParameter("submit");
        String submit1=request.getParameter("submit1");

        if(submit!=null&&submit.equals("提交餐饮记录")){
            String DateTimes=request.getParameter("DateTimes");
            String Goods=request.getParameter("Goods");
            String Sums=request.getParameter("Sums");
            Item item=new Item();
            item.setDateTimes(DateTimes);
            item.setGoods(Goods);
            item.setSums(Sums);
            IsubController isubController=new SubitemController();
            isubController.subfoods(item);
            request.getRequestDispatcher("zengjia.jsp").forward(request,response);
        }
        else if(submit1!=null&&submit1.equals("提交日常用品记录")){
            String DateTimes=request.getParameter("DateTimes");
            String Goods=request.getParameter("Goods");
            String Sums=request.getParameter("Sums");
            Item item=new Item();
            item.setDateTimes(DateTimes);
            item.setGoods(Goods);
            item.setSums(Sums);
            IsubController isubController=new SubitemController();
            isubController.subgoods(item);
            request.getRequestDispatcher("zengjia.jsp").forward(request,response);
        }
    }
}