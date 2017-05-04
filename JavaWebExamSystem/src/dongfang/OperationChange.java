package dongfang;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class OperationChange {
	public void change(String operatinid,String otitle,String score) throws Exception
	{	    //System.out.println(otitle);
	        //System.out.println(operatinid );
	        // System.out.println( score);
		    Connection conn=null;	 
		    try{
			//����ݿ������
			 Class.forName("com.microsoft.jdbc.sqlserver.SQLServerDriver");
			 conn=DriverManager.getConnection(
		     "jdbc:microsoft:sqlserver://localhost:1433;DatabaseName=JavaWebExamSystem;user=sa;password=123");
			 //���б�дsql,ȡ�����
			 String sql=" update operation set otitle="+"'"+otitle+"',sinopescore='"+score+"'where operationid ='"+operatinid+"'";
			 Statement stat=conn.createStatement();
			 stat.executeUpdate(sql);
			 //ȡ�����,����һ��	 
			 conn.commit();
			 stat.close();
			 operatinid=null;
		}
		catch(SQLException e) {}
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
		{			
		}
		}		
	}		
}
