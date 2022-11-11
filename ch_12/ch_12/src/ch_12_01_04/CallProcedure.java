package ch_12_01_04;
import java.sql.*;

public class CallProcedure {
	public static void main(String[] args) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521/xepdb1", "hr", "hr");
			// 프로시저 호출
			CallableStatement cs = con.prepareCall("{call find_ename(?,?)}");
			// 입력 파라메터
			cs.setInt(1, 107);
			// 출력 파라메터
			cs.registerOutParameter(2, java.sql.Types.VARCHAR);
			// 실행
			cs.execute();
			System.out.println(cs.getString(2));
			cs.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}//end try
	}//end main
}//end clas