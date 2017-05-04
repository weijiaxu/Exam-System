package dongfang;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
public class OperationShow {
	public ArrayList    con()throws Exception{	
		   ArrayList   operations=new ArrayList();
		   Connection conn=null;	 
		   try{
			//����ݿ������
			 Class.forName("com.microsoft.jdbc.sqlserver.SQLServerDriver");
			 conn=DriverManager.getConnection(
		     "jdbc:microsoft:sqlserver://localhost:1433;DatabaseName=JavaWebExamSystem;user=sa;password=123");
			 //���б�дsql,ȡ�����
			 String sql="select *  from operation";
			 Statement stat=conn.createStatement();
			 ResultSet rs=stat.executeQuery(sql);
			 //ȡ�����,����һ��
			 while(rs.next())
			 {
	          Operation operation =new Operation();
	          operation.setOpearationid(rs.getString("operationid"));
	          operation.setOtitle(rs.getString("otitle"));
	          operation.setOanswer(rs.getString("oanswer"));
	          operation.setSinopescore(rs.getString("sinopescore"));
	          operations.add(operation);
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
	return operations;	
	}
}
