package dongfang;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
public class OperationAdd {
	Connection conn=null;	
	public void add(String Operation,String otitle ,String sinopescore )
	throws Exception{
	   try{
		//����ݿ������
		 Class.forName("com.microsoft.jdbc.sqlserver.SQLServerDriver");
		 conn=DriverManager.getConnection(
	     "jdbc:microsoft:sqlserver://localhost:1433;DatabaseName=JavaWebExamSystem;user=sa;password=123");
		 //���б�дsql,ȡ�����
		 String sql="insert into operation(operationid,otitle,sinopescore) values('"+Operation+"','"+otitle+"','"+sinopescore+"')";
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
