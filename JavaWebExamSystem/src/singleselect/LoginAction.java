package singleselect;

import java.util.Map;




import pub.IdentifyTest;

import com.opensymphony.xwork2.ActionContext;



public class LoginAction {
	private String account;
	private String password;
	private String identify;
	
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getIdentify() {
		return identify;
	}
	public void setIdentify(String identify) {
		this.identify = identify;
	}
	
    public String execute() throws Exception{
        boolean result=false;
        String sname=null;
    	if(getIdentify().equals("学生")){
    		IdentifyTest it=new IdentifyTest();
    		result=it.identifyTest(getAccount(), getPassword(),getIdentify());
    		if(result){
    			Map session=ActionContext.getContext().getSession();
        		session.put("account", getAccount());
        	    sname=it.getSname(getAccount());
        	    session.put("sname", sname);
        		return "LoginSuccess";
    		}
    		else{
    			return "LoginFail";
    		}
        }
    	else{
    		IdentifyTest it=new IdentifyTest();
    		result=it.identifyTest(getAccount(), getPassword(),getIdentify());
    		if(result){
    			Map session=ActionContext.getContext().getSession();
        		session.put("account", getAccount());
        		sname=it.getSname(getAccount());
        	    session.put("sname", sname);
        		return "Teacher";
    		}
    		else{
    			return "LoginFail";
    		}
    	}
    	
 
    }

}
