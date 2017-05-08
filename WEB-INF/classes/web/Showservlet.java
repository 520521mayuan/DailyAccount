package web;

import controller.ExtractController;
import controller.IextractController;
import util.Item;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/5/8.
 */
public class Showservlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Item> list=new ArrayList<>();
        IextractController iextractController=new ExtractController();
        list=iextractController.extractfoods();
        req.setAttribute("listall",list);
        req.getRequestDispatcher("listall.jsp").forward(req,resp);
    }
}
