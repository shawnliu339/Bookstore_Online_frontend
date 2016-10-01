package mybookapp1.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ConnectionFactory {
	private static final String URL = "jdbc:sqlserver://127.0.0.1:1433; DatebaseName = bookstore";
	private static final String USER = "sa";
	private static final String PASSWORD = "liusiyuan";
	private static final String DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";

	public static Connection getConnection() {
		try {
			Class.forName(DRIVER);
			return DriverManager.getConnection(URL, USER, PASSWORD);
		} catch (Exception e) {
			System.out.println("getConn error");
			e.printStackTrace();
			return null;
		}
	}

	public static void close(Connection conn, Statement stm, ResultSet rs) {
		try {
			if (conn != null)
				conn.close();
			if (stm != null)
				stm.close();
			if (rs != null)
				rs.close();
		} catch (Exception e) {
			System.out.println("close error");
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		Connection conn = null;
		try {
			conn = ConnectionFactory.getConnection();
			System.out.println(conn);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionFactory.close(conn, null, null);
		}

	}

}
