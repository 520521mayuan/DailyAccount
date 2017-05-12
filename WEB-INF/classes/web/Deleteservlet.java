package web;

import controller.DeleteController;
import controller.IdeleteController;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Administrator on 2017/5/8.
 */
@WebServlet(name = "delete",urlPatterns = "/delete")
public class Deleteservlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String itemid=req.getParameter("itemID");
        IdeleteController ideleteController=new DeleteController();
        ideleteController.deleteItem(itemid);
        resp.sendRedirect("/listall");

    }
}
