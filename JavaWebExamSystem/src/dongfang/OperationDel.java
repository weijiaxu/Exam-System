package dongfang;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class OperationDel {
public void del(String a) throws Exception
{
	Connection conn=null;	 
	   try{
		//����ݿ������
		 Class.forName("com.microsoft.jdbc.sqlserver.SQLServerDriver");
		 conn=DriverManager.getConnection(
	     "jdbc:microsoft:sqlserver://localhost:1433;DatabaseName=JavaWebExamSystem;user=sa;password=123");
		 //���б�дsql,ȡ�����
		 String sql="delete  from operation where Operationid='"+a+"'";
		 Statement stat=conn.createStatement();
		stat.executeUpdate(sql);
		 //ȡ�����,����һ��	 
		 conn.commit();
		 stat.close();
	}
	catch(SQLException e) {conn.rollback();}
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
