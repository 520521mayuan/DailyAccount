package web;

import controller.ExtractController;
import controller.IextractController;
import util.Item;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by Administrator on 2017/5/10.
 */
@WebServlet(name = "mohu",urlPatterns = "/mohu")
public class Mohuservlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            req.setCharacterEncoding("UTF-8");
            String keyword=req.getParameter("search");
            System.out.println(keyword);
            IextractController iextractController=new ExtractController();
            List<Item> list=iextractController.mohusearch1(keyword);
            req.setAttribute("listall",list);
            req.getRequestDispatcher("listall.jsp").forward(req,resp);
    }

}
