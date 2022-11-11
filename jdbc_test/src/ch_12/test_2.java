package ch_12;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class test_2 {

	public static void main(String[] args) throws SQLException {
		/**
		 * 자바에서 오라클 연동 테스트
		 * - 주요 오라클 관련 정보
		 *   SID : xepdb1, PORT : 1521
		 *   HOST : 127.0.0.1
		 *   USER : hr/hr
		 *   URL : jdbc:oracle:thin:@localhost:1521/xepdb1
		 *   DRIVER : oracle.jdbc.driver.OracleDriver
		 */

		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521/xepdb1";
		String id = "hr";
		String pw = "hr";
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM hr.departments";
		
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, id, pw);
			stmt = conn.createStatement();
			System.out.println(conn);
			
			rs = stmt.executeQuery(sql);
			rs.next();
			int dept_no = rs.getInt("department_id");
			System.out.println(dept_no);
			rs.next();
			String dept_name = rs.getString(2);
			System.out.println(dept_name);
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//end try

	}//end main

}//end class
