package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.servlet.http.HttpSession;
import Action.ShowAction;


public class userdao {
	
	 Connection conn =null;
	 Statement st=null;
	  public void connection() throws ClassNotFoundException, SQLException
	  {
	    String str="com.microsoft.jdbc.sqlserver.SQLServerDriver";
	    Class.forName(str);
	    conn = DriverManager.getConnection("jdbc:microsoft:sqlserver://localhost:1433;DatabaseName=JavaWebExamSystem;user=sa;password=123");
        st = conn.createStatement();
	  }
	 
	  public ArrayList show() throws ClassNotFoundException, SQLException
		{  connection(); 
			String sql="select *  from sinsel ";
			ArrayList selections=new ArrayList();
			 ResultSet rs=st.executeQuery(sql);
			 while(rs.next())
	         {ShowAction selection=new ShowAction();
	         selection.setSelectid(rs.getString("selectid"));
	         selection.setStitle(rs.getString("stitle"));
	         selection.setOptionA(rs.getString("optionA"));
	         selection.setOptionB(rs.getString("optionB"));
	         selection.setOptionC(rs.getString("optionC"));
	         selection.setOptionD(rs.getString("optionD"));
	         selection.setSanswer(rs.getString("sanswer"));
	         selection.setSinselscore(rs.getString("sinselscore"));
	         selections.add(selection);
	         }
	         rs.close();
	        st.close();
	        return selections; 
		}			
			
		
		public  boolean add(String title,String A,String B,String C,String D,String answer) throws ClassNotFoundException, SQLException
		{   boolean result=false;
		 connection();
			String sql1="select top 1 * from sinsel order by selectid  desc";
		    ResultSet rs=st.executeQuery(sql1);
		    int j=0;
		    while(rs.next())
		    {
		     j=rs.getInt("selectid");
		    j++;
		    }
			connection();
			String ssql="select distinct sinselscore  from sinsel";
			ResultSet rrs=st.executeQuery(ssql);
			
			while(rrs.next())
			{
			String score=rrs.getString("sinselscore");
			if(score!=""){
			connection();
		
			String sql="insert into sinsel values('"+j+"','"+title+"','"+A+"','"+B+"','"+C+"','"+D+"','"+answer+"','"+score+"')";
			int i = st.executeUpdate(sql);
			if(i>=1)
			{result=true;}
			}}
			return result;  
			
			
		}
		public boolean update(String id,String title,String A,String B,String C,String D,String answer,String score) throws ClassNotFoundException, SQLException
		{   boolean result=false;
			connection();
			String sql="update sinsel set stitle='"+title+"',optionA='"+A+"',optionB='"+B+"',optionC='"+C+"', optionD='"+D+"', sanswer='"+answer+"',sinselscore='"+score+"' where selectid='"+id+"'";
			int i=st.executeUpdate(sql);
			System.out.print(i);
			if(i>=1)
			{result=true;}
			return result;    
		}
		public boolean updateall(String score) throws ClassNotFoundException, SQLException
		{   boolean result=false;
			connection();
			String sql="update sinsel set sinselscore='"+score+"'";
			int i=st.executeUpdate(sql);
			if(i>=1)
			{result=true;}
			return result;    
		}
		public boolean delete(String id) throws ClassNotFoundException, SQLException
		{boolean result=false;
		int j= Integer.parseInt(id);
		connection();
		String sql="delete from sinsel where selectid='"+id+"'";
		int i=st.executeUpdate(sql);
		if(i>=1)
		{
			String ssql="update sinsel set selectid=selectid-1 where selectid>'"+j+"'";
			int m=st.executeUpdate(ssql);
			result=true;
		}
		return result;  	
		}
			

		
			
		
}
