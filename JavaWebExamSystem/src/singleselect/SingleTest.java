package singleselect;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;

public class SingleTest {

	public String execute(){
		
		String result="SubmitFail";
		boolean res=false;
		
		Map session=ActionContext.getContext().getSession();
		int sinnum=(Integer)session.get("sinnum");
		String account=(String)session.get("account");
		SinSelOperation sso=new SinSelOperation();
		
		
		HttpServletRequest request=ServletActionContext.getRequest();
		
		String m="";
		String temp="";
		String sumstr="";
		for(int i=0;i<sinnum;i++){
			m="s"+i;
			temp=(String)request.getParameter(m);
			//问号表示此选择题学生未填
			if(temp==null){
				temp="?";
			}
			sumstr=sumstr+temp;
		}
		res=sso.submitSinSel(sumstr,account);
		if(res){
			result="SubmitSuccess";
		}
		return result;
	}

}
