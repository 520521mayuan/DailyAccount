package web;
import dao.MonthSumDao;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.StringWriter;

@WebServlet(name="sum",urlPatterns="/sum")
public class GetMonthSumServelet extends HttpServlet{
	public void doGet(HttpServletRequest req, HttpServletResponse res){
		MonthSumDao monthsumdao=new MonthSumDao();
		List list=monthsumdao.getmonthsum();
		StringWriter sw =new StringWriter();
		ObjectMapper mapper = new ObjectMapper();
		try{
			mapper.writeValue(sw, list);
		}
		catch(Exception e){
			
		}
		req.setAttribute("json",sw);
		try{
			req.getRequestDispatcher("test.jsp").forward(req,res);
		}
		catch(Exception e){

		}
			
	}
	public void doPost(HttpServletRequest req, HttpServletResponse res){
		doGet(req,res);
	}
}
