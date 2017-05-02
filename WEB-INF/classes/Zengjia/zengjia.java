package Zengjia;     
import java.io.IOException;     
import javax.servlet.ServletException;     
import javax.servlet.http.HttpServlet;     
import javax.servlet.http.HttpServletRequest;     
import javax.servlet.http.HttpServletResponse;     
import javax.servlet.http.HttpSession;
public class zengjia extends HttpServlet {     
    private UserLand Land=new UserLand();     
    private UserLogin login=new UserLogin();     
    private UserLoginThings login1=new UserLoginThings();     
    public void doGet(HttpServletRequest request,HttpServletResponse response)     
	throws ServletException,IOException{     
    }     
    public void doPost(HttpServletRequest request,HttpServletResponse response)     
	throws ServletException,IOException{     
	request.setCharacterEncoding("UTF-8");     
	String submit=request.getParameter("submit");     
	String submit1=request.getParameter("submit1");     

	if(submit!=null&&submit.equals("提交餐饮记录")){     
	    String xuehao=request.getParameter("xuehao");     
	    String xingming=request.getParameter("xingming");     
	    String zhuanye=request.getParameter("zhuanye");     
	    User user=new User();     
	    user.setxuehao(xuehao);     
	    user.setxingming(xingming);     
	    user.setzhuanye(zhuanye);     
	    if(Land.login(user)){     
		HttpSession session=request.getSession(true);     
		session.setAttribute("user",user);     
		request.getRequestDispatcher("zengjia.jsp").forward(request,response);
		session.invalidate();	
	    }else if(login.login(user)){     
		HttpSession session=request.getSession(true);     
		session.setAttribute("user",user);     
		request.getRequestDispatcher("zengjia.jsp").forward(request,response);
		session.invalidate();	
	    }     
	}     
	else if(submit1!=null&&submit1.equals("提交日常用品记录")){     
	    String xuehao=request.getParameter("xuehao");     
	    String xingming=request.getParameter("xingming");     
	    String zhuanye=request.getParameter("zhuanye");     
	    User user=new User();     
	    user.setxuehao(xuehao);     
	    user.setxingming(xingming);     
	    user.setzhuanye(zhuanye);     
	    if(Land.login(user)){     
		HttpSession session=request.getSession(true);     
		session.setAttribute("user",user);     
		request.getRequestDispatcher("zengjia.jsp").forward(request,response);     
		session.invalidate();	
	    }else if(login1.login1(user)){     
		HttpSession session=request.getSession(true);     
		session.setAttribute("user",user);     
		request.getRequestDispatcher("zengjia.jsp").forward(request,response);
		session.invalidate();	
	    }     
	}  
	else{
	    request.getRequestDispatcher("zengjia.jsp").forward(request,response);     
	}
    }     

}    
