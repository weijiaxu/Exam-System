package singleselect;

//import java.sql.*;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import pub.Drive;


public class SinSelOperation {
	
	//声明单选题题号数组
	private int[] sinselnums=null;
	//声明单选题的个数
	private int sinnum;
	//声明学生的学号
	private String sno;
	
	
	//第四层
	//判断登录次数，若是第一次登录初始化，若不是第一次登陆，从数据库取值
	public ArrayList main(int sinnum,String sno){
		ArrayList sinsels=null;
		String sql=null;
		this.sno=sno;
	    boolean result=isFirstLogin();
	    //System.out.println(result);
	    boolean result2=false;
		if(result){
			result2=updateLoginState();
			if(result2){
				int sinmax=getSinSel();
				sinsels=singleSelect(sinmax,sinnum,sno);
			}
		}
		else{
			this.sinnum=sinnum;
			this.sinselnums=new int[sinnum];
			sql="select selid from grade where sno='"+sno+"'";
			SelOpeid(sql);
			sinsels=sinSelVO();
		}
		return sinsels;
	}
	
	
	//第三层5个函数，调用第二层的7个函数
	
	//1.判断是否是第一次得登陆，若是，返回true；若不是，返回false
		public boolean isFirstLogin(){
			  boolean result=false;
			  Connection conn=null;
		   	  try{
		   		   Drive drive=new Drive();
			       conn=drive.getConn();
			       Statement stat=drive.getStat();
			       String sql="select loginstate from student where sno='"+sno+"'";
		   	       ResultSet rs=stat.executeQuery(sql);
		   	       if(rs.next()){
		   	    	  String state=rs.getString("loginstate");
		   	    	  if(state.equals("notonline")){
		   	    	      result=true; 
		   	    	  }
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
		
		//2.修改登录状态
		public boolean updateLoginState(){
			  boolean result=false;
			  String sql="update student set loginstate='online' where sno='"+sno+"'";
			  result=updateTable(sql);   
		   	  return result;
		}	
		
	//用于第一次登录	
	//2.将学号，单选题的题号，选择题的正确答案，插入到grade表中
    //实现从用户登录后将单选题封装成值对象操作
	public ArrayList singleSelect(int sinmax,int sinnum,String sno){
		ArrayList sinsels=null;
		boolean result=false;
		randomSelect(sinmax,sinnum,sno);
		String selid=selid();
	    String corselanswer=corselanswer();
	    result=ins_grade(sno,selid,corselanswer);
	    if(result){
	    	sinsels=sinSelVO();
	    }
		return sinsels;
	}
	
	
	//3.将学生选择题的答案，学生的分数更新到grade表,返回更新结果。
	public boolean submitSinSel(String stuselanswer,String account){
		this.sno=account;
		boolean result=false;
		String corselanswer=selanswer();
	    int m=compare(stuselanswer,corselanswer);
	    float sinselscore=querySinSelScore();
	    float selscore=sinselscore*m;
	    String sql="update grade set opescore=0,stuselanswer='"+stuselanswer+"',selscore="+selscore+" where sno='"+sno+"'";
	    result=updateTable(sql);
		return result;
	}
	
	//从数据库中取出单选题的答案组装成的字符串
	public String selanswer(){
		Connection conn=null;
		String result=null;
		String sql="select corselanswer from grade where sno='"+sno+"'";
		try{
	   		   
	   		   Drive drive=new Drive();
		       conn=drive.getConn();
		       Statement stat=drive.getStat();
	   	       ResultSet rs=stat.executeQuery(sql);
	   	       while(rs.next()){
	   	    	   result=rs.getString("corselanswer");
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
	
	
	
	    //4.用于不是第一次登陆
		//选择题数组初始化
		public void SelOpeid(String sql){
			  Connection conn=null;
			  String selid=null;
			 
			  int i=0;
			  String a="";
			  String b="";
			  int j=0;
		   	  try{
		   		   Drive drive=new Drive();
			       conn=drive.getConn();
			       Statement stat=drive.getStat();
		   	       ResultSet rs=stat.executeQuery(sql);
		   	       while(rs.next()){
		   	    	   selid=rs.getString("selid");
		   	    	   
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
		   	   
		   	   for(i=0;i<selid.length();i++){
		   		   a=selid.charAt(i)+"";
		   		   if(!a.equals(",")){
		   			   b=b+a;
		   			   
		   			   if(j==sinnum-1){
		   			   this.sinselnums[j]=Integer.parseInt(b);
		   			   }
		   		   }
		   		   else{
		   			   this.sinselnums[j]=Integer.parseInt(b);
		   			   b="";
		   			   j=j+1;
		   			}
		   		   
		   	   }
		   	   
		   	   
		   		   
		   }
	
		//5.得到选择题的总数
				public int getSinSel(){
					  int result=0;
					  Connection conn=null;
				   	  try{
				   		   Drive drive=new Drive();
					       conn=drive.getConn();
					       Statement stat=drive.getStat();
					       String sql="select count(*) as num from sinsel";
				   	       ResultSet rs=stat.executeQuery(sql);
				   	       if(rs.next()){
				   	    	   result=rs.getInt("num");
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
		
	
	
	//第二层7个函数，调用第一层的2个函数
	
		
		
		
	//1.单选题题号数组，单选题的个数，学生的学号初始化
	private void randomSelect(int sinmax,int sinnum,String sno){
		MyRandom r=new MyRandom();
		this.sinselnums=r.randomFunction(sinmax,sinnum);
		this.sinnum=sinnum;
		this.sno=sno;
	}
	
	
	//2.得到单选题题号组装成字符串
	//（数字与数字之间用英文逗号连接）
	private String selid(){
		String temp="";
		for(int i=0;i<sinnum-1;i++){
			temp=temp+sinselnums[i]+",";
		}
		temp=temp+sinselnums[sinnum-1];
		return temp ;
	}
	
	//3.根据题号在sinsel表找到所有选择题的正确答案，将其组装成一个字符串
	private String corselanswer(){
		String sql=null;
		String temp="";
		String str="";
		for(int i=0;i<sinnum;i++){
			sql="select sanswer from sinsel where selectid="+sinselnums[i];
			temp=queryTable(sql);
			str=str+temp;
		}
	    return str;
	}
	
	
	//4.根据题号从sinsel表中找到题的具体内容
    //(stitle,optionA,optionB,optionC,optionD)，
	//将其封装成singleselect 对象数组。
	private ArrayList sinSelVO(){
	   ArrayList singleselects=new ArrayList();
	   Connection conn=null;
	   String sql=null;
   	   try{
   		   
   		   Drive drive=new Drive();
	       conn=drive.getConn();
	       Statement stat=drive.getStat();
   	       ResultSet rs=null;
   	       for(int i=0;i<sinnum;i++){
			   sql="select stitle,optionA,optionB,optionC,optionD from sinsel where selectid="+sinselnums[i];
			   rs=stat.executeQuery(sql);
			   while(rs.next()){
	   	    	   //实例化VO
	   	    	   SingleSelect sinsel=new SingleSelect();
	   	    	   sinsel.setStitle(rs.getString("stitle"));
	   	    	   sinsel.setOptionA(rs.getString("optionA"));
	   	           sinsel.setOptionB(rs.getString("optionB"));
	   	    	   sinsel.setOptionC(rs.getString("optionC"));
	   	       	   sinsel.setOptionD(rs.getString("optionD"));
	   	    	   singleselects.add(sinsel);
	   	      }
			   
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
   	   return singleselects;
   }
	
	
    //5.传进来两个同样长度的字符串，依次作比较，传出相同字符的个数
	public int compare(String stuselanswer,String corselanswer){
    	//设置计数器
    	int n=0;
    	char c1,c2;
    	for(int i=0;i<stuselanswer.length();i++){
    		c1=stuselanswer.charAt(i);
    		c2=corselanswer.charAt(i);
    		if(c1==c2){
    			n=n+1;
    		}
    	}
    	return n;
    }
    
    
    //6.将单道选择题的分数从数据库中取出
    //假定所有的选择题分值一样
	private float querySinSelScore(){
  		  Connection conn=null;
  		  float sinselscore = 0 ;
  	   	  try{
  	   		   
  	   		   Drive drive=new Drive();
		       conn=drive.getConn();
		       Statement stat=drive.getStat();
  	   	       String sql="select top(1) sinselscore from sinsel";
  	   	       ResultSet rs=stat.executeQuery(sql);
  	   	       while(rs.next()){
  	   	    	   sinselscore=rs.getFloat("sinselscore");
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
  	   	   return sinselscore;
  	}
  	
  	 //7.将学号，单选题的题号，选择题的正确答案，插入到grade表	
	private boolean ins_grade(String sno,String selid,String corselanswer){
    	boolean result=false;
    	String sql="insert into grade(sno,selid,corselanswer) values('"+sno+"','"+selid+"','"+corselanswer+"')";
    	result=updateTable(sql);
    	return result;
    }
    
    
    //第一层2个函数
    
	//1.用于更新表
	//传进去的是SQL语句，传出的执行结果
	public boolean updateTable(String sql){
		boolean result=false;
	    Connection conn=null;
    	try{
    		   //Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	   	       //conn=DriverManager.getConnection("jdbc:odbc:JavaWebExamSystem","sa","123");
    		   //Class.forName("com.microsoft.jdbc.sqlserver.SQLServerDriver");
    	       //conn=DriverManager.getConnection("jdbc:microsoft:sqlserver://localhost:1433;DatabaseName=JavaWebExam;user=sa;password=123");
    		   //Statement stat=conn.createStatement();
    		   Drive drive=new Drive();
		       conn=drive.getConn();
		       Statement stat=drive.getStat();
    	       int i=stat.executeUpdate(sql);
    	       if(i>=0){
    	    	   result=true;
    	       }
    	       stat.close();
    	}
    	catch(SQLException e){
    		 e.printStackTrace();
    	} 
    	finally{
    		     try{ //关闭连接
    			      if(conn!=null){
    				     conn.close();
    				     conn=null;
    			       }
    			  }
    		      catch(Exception e){}
    	}
    	return result;
    }
	
	
	//2.用于查询表
	//传进去的是SQL语句，传出的执行结果
	//目的是找到每一道选择题的正确答案
	public String queryTable(String sql){
		  Connection conn=null;
		  String correctanswer=null;
	   	  try{
	   		   
	   		   Drive drive=new Drive();
		       conn=drive.getConn();
		       Statement stat=drive.getStat();
	   	       ResultSet rs=stat.executeQuery(sql);
	   	       while(rs.next()){
	   	    	   correctanswer=rs.getString("sanswer");
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
	   	   return correctanswer;
	}
	
	
	
	
	
	
	
	   	   
}
	
	    
		
		
	
	
		

	


