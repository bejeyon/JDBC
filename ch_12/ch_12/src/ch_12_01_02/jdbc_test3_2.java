package ch_12_01_02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class jdbc_test3_2 {
	public static void main(String[] args) {
		Connection con = null; // 1. 오라클 데이터베이스 연결 참조변수 선언
		Statement stmt = null;// 2. 쿼리문 실행 참조변수 선언
		ResultSet rs = null;// 3. 쿼리문 실행 결과를 저장하는 참조변수 선언
		String sql = null; // sql문을 저장하는 변수
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521/xepdb1";
		String uid = "hr";
		String pwd = "hr";
		int deptno; // 데이터베이스 값 저장할 변수
		String dname, m_id,l_id; //// 데이터베이스 값 저장할 변수

		// 드라이브 로딩과 db 연결은 try ~ catch 블럭으로 감싼다.
		try {
			// 1. jdbc 드라이버 로딩
			Class.forName(driver);
			// 2. db 연결
			con = DriverManager.getConnection(url, uid, pwd);
			// 3. 쿼리문 실행 객체 생성
			stmt = con.createStatement();
			// 4. sql문 작성
			sql = "select * from HR.DEPARTMENTS"; 
			// 5. 쿼리문 실행(select문 executeQuery()사용)
			rs = stmt.executeQuery(sql);
			while (rs.next()) { // 레코드가 있으면 반복, 없으면 중단
				deptno = rs.getInt("department_id"); // 첫번째 필드 가져옴
				dname = rs.getString("department_name"); // 두번째 필드 가져옴
				m_id = rs.getString("manager_id"); // 세번째 필드 가져옴
				l_id = rs.getString("location_id"); // 네번째 필드 가져옴
				System.out.println(deptno + " " 
				+ dname + " " + m_id + " " + l_id);
			}//end while 
			// DB연결 후 작업이 종료되면 연결 객체을 닫아준다.
			rs.close();
			stmt.close();
			con.close();
		} catch (Exception e) {
			System.out.println("DB 연결에 문제가 있습니다.");
			e.printStackTrace();
		} // end try
	}// end mami
}// end class
