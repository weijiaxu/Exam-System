package Action;

import java.io.UnsupportedEncodingException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import Dao.userdao;

import org.apache.struts2.ServletActionContext;
public class UpdateAction  {
	public String execute() throws ClassNotFoundException, SQLException, UnsupportedEncodingException{
	HttpServletRequest request=ServletActionContext.getRequest();
	request.setCharacterEncoding("UTF-8");
	HttpSession session=request.getSession();
	userdao updatedao=new userdao();
	String action=request.getParameter("action");
	if(action!=null&&action.equals("updateall"))
	{String score=request.getParameter("score");
	if(score!=""){
	 	if(updatedao.updateall(score))
	 		{
	 		return "success";
	 		}
	 	else return "failall";
	 	}
	}
	String id=(String)session.getAttribute("id");
	String title=request.getParameter("title");
	
	String A=request.getParameter("A");
	String B=request.getParameter("B");
	String C=request.getParameter("C");
	String D=request.getParameter("D");
	String answer=request.getParameter("answer");
	String score=request.getParameter("score");
	if(answer==null)
	{
		 answer=(String)session.getAttribute("answer");
	}
	try {if(id!=""&&title!=""&&A!=""&&B!=""&&C!=""&&D!=""&&answer!=""&&score!="")
		{
		if(updatedao.update(id, title, A, B, C, D, answer,score))
		{ return "success";}}
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

