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
		int page = 1;
		int recordsPerPage = 10;
		if(req.getParameter("page") != null)
			page = Integer.parseInt(req.getParameter("page"));
		IextractController iextractController=new ExtractController();
		List<Item> list=iextractController.extractfoods((page-1)*recordsPerPage,recordsPerPage);
		int noOfRecords = iextractController.getsumpage();
		int noOfPages = (int) Math.ceil(noOfRecords * 1.0 / recordsPerPage);
		req.setAttribute("listall",list);
		req.setAttribute("noOfPages", noOfPages);
		req.setAttribute("currentPage", page);
		req.getRequestDispatcher("listall.jsp").forward(req,resp);
	}
}
