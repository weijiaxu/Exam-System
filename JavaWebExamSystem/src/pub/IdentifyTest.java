package pub;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class IdentifyTest {
	
	public boolean identifyTest(String account,String password,String identity){
		boolean result=false;
		Connection conn=null;
		try{
		    Drive drive=new Drive();
		    conn=drive.getConn();
		    Statement stat=drive.getStat();
	   	    String sql="select sno,password,identify from Student where sno='"+account+"'";
		    ResultSet rs=stat.executeQuery(sql);
		    if(rs.next())
		      {  
		    	 String iden=rs.getString("identify");
		    	 if(iden.equals(identity)){
		    		 String pass=rs.getString("password");
			    	 if(pass.equals(password))
		             {
		        	    result=true;
		        	  }
		    	 }
		    	
		       }
		       
		    rs.close();
			stat.close();
		  }
		  catch(SQLException e ){
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
	
	public String getSname(String account){
		Connection conn=null;
		String sname=null;
		try{
		    Drive drive=new Drive();
		    conn=drive.getConn();
		    Statement stat=drive.getStat();
			String sql="select sname from student where sno='"+account+"'";
		    ResultSet rs=stat.executeQuery(sql);
		    while(rs.next()){
		    	sname=rs.getString("sname");
		    }
		    rs.close();
			stat.close();
		  }
		  catch(SQLException e ){
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
		return sname;
	}

}
		
	
	