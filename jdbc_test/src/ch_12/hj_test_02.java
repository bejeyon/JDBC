package ch_12;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class hj_test_02 {

	public static void main(String[] args) throws SQLException {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521/xepdb1";
		String id = "hr";
		String pw = "hr";
		Connection conn = null;  //오라클 데이터베이스 연결 참조변수 선언
		Statement stmt = null; //쿼리문 실행 참조변수 선언
		ResultSet rs = null; //쿼리문 실행 결과 저장 참수변수 선언
		String sql = "select * from hr.departments";
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, id, pw);
			stmt = conn.createStatement();
			System.out.println(conn);
			rs = stmt.executeQuery(sql);
			rs.next();
			int deptno = rs.getInt(1);
			System.out.println(deptno);
			rs.next();
			String dept_name = rs.getString(2);
			System.out.println(dept_name); 
//			int deptno = rs.getInt();
//			System.out.println(conn.getAutoCommit());
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}