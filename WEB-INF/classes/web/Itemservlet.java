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
        String DateTimes=request.getParameter("DateTimes");
        String Goods=request.getParameter("Goods");
        String Sums=request.getParameter("Sums");
        Item item=new Item();
        item.setDateTimes(DateTimes);
        item.setGoods(Goods);
        item.setSums(Sums);

        IsubController isubController=new SubitemController();
        isubController.subgoods(submit,item);
        request.getRequestDispatcher("zengjia.jsp").forward(request,response);


    }
}