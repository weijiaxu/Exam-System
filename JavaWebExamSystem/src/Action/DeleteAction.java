package Action;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import Dao.userdao;

public class DeleteAction {
public String execute() throws ClassNotFoundException, SQLException
   { 
	HttpServletRequest request=ServletActionContext.getRequest();
    HttpSession session=request.getSession();
    String id=(String)session.getAttribute("id");
    userdao deletedao=new userdao();
    if(deletedao.delete(id))
	{  return "success";}
    else 
    	return "fail";
	}
}
