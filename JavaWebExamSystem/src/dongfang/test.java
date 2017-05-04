package dongfang;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class test {
//用于显示没有考试的学生
//1
//1
//1
	public ArrayList    notonline()throws Exception{	
		   ArrayList  students1 =new ArrayList();
		   Connection conn=null;	 
		   try{	 
			 Class.forName("com.microsoft.jdbc.sqlserver.SQLServerDriver");
			 conn=DriverManager.getConnection(
		     "jdbc:microsoft:sqlserver://localhost:1433;DatabaseName=JavaWebExamSystem;user=sa;password=123");			  
			 String sql="select *  from student where loginstate= 'notonline' and identify='学生'";
			 Statement stat=conn.createStatement();
			 ResultSet rs=stat.executeQuery(sql);			 
			 while(rs.next())
			 {
	          student student =new student();
	          student.setSno(rs.getString("sno"));
	          student.setIdentify(rs.getString("identify"));
	          student.setSname(rs.getString("sname"));	        
	          students1.add(student);
      	 }	
			 rs.close();
			 stat.close();
		}
		catch(SQLException e) {e.printStackTrace();}
		finally
		{
		try {
			if (conn!= null)
			{
				conn.close();
				conn=null;				
			}
		}
		catch(Exception ex)
		{}
		}		
	return students1;	
	}	
	
	//用于显示考试的学生
	//2
	//2
	//2
	public ArrayList    online()throws Exception{	
		   ArrayList  students2 =new ArrayList();
		   Connection conn=null;	 
		   try{	 
			 Class.forName("com.microsoft.jdbc.sqlserver.SQLServerDriver");
			 conn=DriverManager.getConnection(
		     "jdbc:microsoft:sqlserver://localhost:1433;DatabaseName=JavaWebExamSystem;user=sa;password=123");			  
			 String sql="select *  from student where loginstate= 'online' and identify='学生'";
			 Statement stat=conn.createStatement();
			 ResultSet rs=stat.executeQuery(sql);			 
			 while(rs.next())
			 {
	          student student =new student();
	          student.setSno(rs.getString("sno"));
	          student.setIdentify(rs.getString("identify"));
	          student.setSname(rs.getString("sname"));	        
	          students2.add(student);
   	 }	
			 rs.close();
			 stat.close();
		}
		catch(SQLException e) {e.printStackTrace();}
		finally
		{
		try {
			if (conn!= null)
			{
				conn.close();
				conn=null;				
			}
		}
		catch(Exception ex)
		{}
		}		
	return students2;	
	  
	}	
	
	//用于显示考试完成的学生
	//3
	//3
	//3
	@SuppressWarnings("finally")
	public ArrayList    finished()throws Exception{	
		   ArrayList  students3 =new ArrayList();
		   Connection conn=null;	 
		   try{	 
			 Class.forName("com.microsoft.jdbc.sqlserver.SQLServerDriver");
			 conn=DriverManager.getConnection(
		     "jdbc:microsoft:sqlserver://localhost:1433;DatabaseName=JavaWebExamSystem;user=sa;password=123");			  
			 String sql="select *  from student where loginstate= 'finished' and identify='学生'";
			 Statement stat=conn.createStatement();
			 ResultSet rs=stat.executeQuery(sql);			 
			 while(rs.next())
			 {
	          student student =new student();
	          student.setSno(rs.getString("sno"));
	          student.setIdentify(rs.getString("identify"));
	          student.setSname(rs.getString("sname"));	        
	          students3.add(student);
   	          }				 
			 rs.close();
			 stat.close();
		}
		catch(SQLException e) {e.printStackTrace();}
		finally
		{
				
		try {
			
			if (conn!= null)
			{
				conn.close();
				conn=null;				
			}			
		}
		catch(Exception ex)
		{}
		 
			return students3;				 
		}			   
	}		
}
