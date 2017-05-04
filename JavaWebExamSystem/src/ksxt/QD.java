package ksxt;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

//驱动类
public class QD {
	public Statement Stat() {
		Connection conn = null;
		Statement stat = null;
		try {
			Class.forName("com.microsoft.jdbc.sqlserver.SQLServerDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String connectionStr = "jdbc:microsoft:sqlserver://localhost:1433;DatabaseName=JavaWebExamSystem";
		try {
			conn = DriverManager.getConnection(connectionStr, "sa", "123");
			stat = conn.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return stat;
	}
}
