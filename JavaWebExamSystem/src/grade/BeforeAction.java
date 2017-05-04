package grade;
import java.sql.*;




import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpSession;

import com.opensymphony.xwork2.ActionContext;

import grade.Grade;

import com.opensymphony.xwork2.ActionSupport;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.interceptor.ServletRequestAware;


public class BeforeAction extends ActionSupport implements
ServletRequestAware  {

	
	Connection ct = null;  
    Statement  sm = null;  
    ResultSet rs = null; 
    private javax.servlet.http.HttpServletRequest request;

	public ArrayList query()throws Exception{
		 
	   
	    ArrayList grades=new ArrayList();  
	    try{
	            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");  
	            ct = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;DatabaseName=JavaWebExamSystem","sa","123");  
	            sm = ct.createStatement();  
	            rs = sm.executeQuery("select  * from grade"); 
	            while(rs.next()) {  
	            	Grade grade=new Grade();
	            	grade.setSno(rs.getString("sno"));
	            	grade.setOpeid(rs.getString("opeid"));
	            	grade.setOpescore(rs.getString("opescore"));
	            	grade.setSumscore(rs.getString("sumscore"));
	            	grades.add(grade);
	            }
	            rs.close();
	            sm.close();
	   
			 }catch(Exception ex){
			 }
			return grades;
		
	}
	public String execute()throws Exception{
		String m="";
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");  
        ct = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;DatabaseName=JavaWebExamSystem","sa","123");  
        sm = ct.createStatement(); 
        Map session=ActionContext.getContext().getSession();
        ArrayList grades=(ArrayList) session.get("grades");  
        if(grades==null)
        {return "fail";}
        else{
        	 for(int i=0;i<grades.size();i++){
     	        m="opescore"+i;
     	        String opescore=request.getParameter(m);
     	        if(opescore.equals("null")){
     	    	   return "empty";
     	        }
        	 }
	         for(int i=0;i<grades.size();i++){
	    	    Grade grage=new Grade();
	            grage=(Grade) grades.get(i);
	            m="opescore"+i;
	            String opescore=request.getParameter(m);
	            //System.out.print(m);
	            float a=Float.parseFloat(opescore);
	            int b=sm.executeUpdate("update grade set opescore="+a+" where sno='"+grage.getSno()+"'");
	          }
	    return "success";
	              
    }    
	           
	            	
	               
	}
	public void setServletRequest(HttpServletRequest request) {
		 this.request = request;
		 }
	     
}
