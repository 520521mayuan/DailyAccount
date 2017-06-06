package web;

import controller.ExtractController;
import controller.IextractController;
import util.Item;
import util.PageBean;

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
		String pagenumberstr=req.getParameter("pagenumber")==null?"1":req.getParameter("pagenumber");
		IextractController iextractController=new ExtractController();
		PageBean pageBean=iextractController.pageBean(pagenumberstr);
		req.setAttribute("page",pageBean);
		req.getRequestDispatcher("listall.jsp").forward(req,resp);
	}
}
