package pub;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

//加载驱动
public class Drive {
	private Connection conn=null;
	private Statement stat=null;
	public Connection getConn()
	{
		 String connectionStr="jdbc:microsoft:sqlserver://localhost:1433;DatabaseName=JavaWebExamSystem";
		 try {
			    Class.forName("com.microsoft.jdbc.sqlserver.SQLServerDriver");
			    this.conn = DriverManager.getConnection(connectionStr,"sa","123");
		 } 
		 catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		 }				
		 catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		 }
		 return conn;
	}
	public Statement getStat()
	{
	     try {
			    this.stat=conn.createStatement();
		 } 
		 catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		 }
		 return stat;
	}
	
	
}
