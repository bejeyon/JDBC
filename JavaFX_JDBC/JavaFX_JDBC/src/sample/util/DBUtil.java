package sample.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.sun.rowset.CachedRowSetImpl;

public class DBUtil {

	private static final String JDBC_DRIVER = "oracle.jdbc.driver.OracleDriver";
	private static final String connStr = "jdbc:oracle:thin:yb/yb@localhost:1521/xepdb1";
	                                       
	private static Connection conn = null;

	public static void dbConnect() throws SQLException, ClassNotFoundException {//전형적인 C 방식 반복되는 거 함수로 만들어버림
		try {
			Class.forName(JDBC_DRIVER);
		} catch (ClassNotFoundException e) {
			System.out.println("Where is your Oracle JDBC Driver?");
			e.printStackTrace();
			throw e;
		}
		
		System.out.println("Oracle JDBC Driver Registered!");		
		
		try {
			conn = DriverManager.getConnection(connStr);
		} catch (SQLException e) {
			System.out.println("Connection Failed! Check output console" + e);
			e.printStackTrace();
			throw e;
		}
	}

	public static void dbDisconnect() throws SQLException {
		try {
			if (conn != null && !conn.isClosed()) {
				conn.close();
			}
		} catch (Exception e) {
			throw e;
		}
	}

	public static ResultSet dbExecuteQuery(String queryStmt) throws SQLException, ClassNotFoundException {
		Statement stmt = null;
		ResultSet resultSet = null;
		CachedRowSetImpl crs = null;
		try {
			dbConnect();
			System.out.println("Select statement: " + queryStmt + "\n");
			stmt = conn.createStatement();
			resultSet = stmt.executeQuery(queryStmt);
			crs = new CachedRowSetImpl();
			crs.populate(resultSet);
		} catch (SQLException e) {
			System.out.println("Problem occurred at executeQuery operation : " + e);
			throw e;
		} finally {
			if (resultSet != null) {
				resultSet.close();
			}
			if (stmt != null) {
				stmt.close();
			}
			dbDisconnect();
		}
		return crs;
	}

	
	public static void dbExecuteUpdate(String sqlStmt) throws SQLException, ClassNotFoundException {
		Statement stmt = null;
		try {
			dbConnect();
			stmt = conn.createStatement();
			stmt.executeUpdate(sqlStmt);
		} catch (SQLException e) {
			System.out.println("Problem occurred at executeUpdate operation : " + e);
			throw e;
		} finally {
			if (stmt != null) {
				stmt.close();
			}
			dbDisconnect();
		}
	}
}







