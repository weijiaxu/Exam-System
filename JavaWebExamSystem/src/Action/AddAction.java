package Action;

import java.io.UnsupportedEncodingException;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import Dao.userdao;
import org.apache.struts2.interceptor.ServletRequestAware;
public class AddAction {
	public String execute() throws Exception{
		HttpServletRequest request=ServletActionContext.getRequest();
		request.setCharacterEncoding("UTF-8");
		userdao adddao=new userdao();
		String title=request.getParameter("title");
		
		
		String A=request.getParameter("A");
		String B=request.getParameter("B");
		String C=request.getParameter("C");
		String D=request.getParameter("D");
		String answer=request.getParameter("answer");
		try {if(title!=""&&A!=""&&B!=""&&C!=""&&D!=""&&answer!="")
		{
			if(adddao.add(title, A, B, C, D, answer))
			{
				return "success";}}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "fail";
	}
	}



