package ch_12_01_03;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class jdbc_test3_4 {
	public static void main(String[] args) {

		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521/xepdb1";
		String username = "hr";
		String password = "hr";
		int department_id ; // 데이터베이스 값 저장할 변수
		String  department_name, manager_id,location_id; //// 데이터베이스 값 저장할 변수

		// sql문 작성
		String query = "select * from HR.DEPARTMENTS";
		// 드라이브 로딩과 db 연결은 try ~ catch 블럭으로 감싼다.
		try ( Connection con 
				= DriverManager.getConnection(url, username, password);
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(query) ) {		
			while (rs.next()) { // 레코드가 있으면 반복, 없으면 중단
				department_id = rs.getInt("department_id"); // 첫번째 필드 가져옴
				department_name = rs.getString("department_name"); // 두번째 필드 가져옴
				manager_id = rs.getString("manager_id"); // 세번째 필드 가져옴
				location_id = rs.getString("location_id"); // 네번째 필드 가져옴
				System.out.println(department_id + " " + department_name +
						" " + manager_id + " " + location_id);
			} // end while				
		} catch (Exception e) {
			System.out.println("DB 연결에 문제가 있습니다.");
			e.printStackTrace();
		} // end try
	}// end main
}// end class
