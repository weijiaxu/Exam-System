package myfilter;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pub.Drive;

public class MyFilter01 implements Filter {

	public void destroy() {
		// TODO Auto-generated method stub

	}

	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		//HttpServletRequest requesttemp = (HttpServletRequest) request;
	    //ServletContext application=session.getServletContext();
		HttpServletRequest request = (HttpServletRequest) req;
        HttpSession session=request.getSession();
        HttpServletResponse response = (HttpServletResponse) res;
        String account=(String) session.getAttribute("account");
        boolean result=queryTeacher(account);
		if(result){
			chain.doFilter(request, response);
		}
		else{
			response.sendRedirect("../Login.jsp");
		}
	}

	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub

	}
	
	public boolean queryTeacher(String account){
		  Connection conn=null;
		  boolean result=false;
	   	  try{
	   		   
	   		   Drive drive=new Drive();
		       conn=drive.getConn();
		       Statement stat=drive.getStat();
		       String sql="select * from student where identify='老师' and sno='"+account+"'";
	   	       ResultSet rs=stat.executeQuery(sql);
	   	       if(rs.next()){
	   	    	   result=true;
	   	       }
	   	       rs.close();
	   	       stat.close();
	   	   }
	   	   catch(SQLException e){
	   		     e.printStackTrace();
	   	   }
	   	   finally{
	   		      try{
	   			      //关闭连接
	   			      if(conn!=null){
	   				     conn.close();
	   				     conn=null;
	   			      }
	   		      }
	   			  catch(Exception e){}
	   	   }
	   	   return result;
	}

}
