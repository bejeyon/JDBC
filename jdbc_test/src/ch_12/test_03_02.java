package ch_12;

import java.util.Scanner;//사용자로부터 입력을 받기위한 기능 추가
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class test_03_02 {
	public static void main(String[] args) {		
		Connection con = null; // 1. 오라클 데이터베이스 연결 참조변수 선언		
		PreparedStatement pstmt = null;// 2. 쿼리문 실행 참조변수 선언
		String sql = null;  // sql문을 저장하는 변수
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521/xepdb1";
		String uid = "hr";
		String pwd = "hr";			 
		String JOB_ID =null; //데이터베이스 값 저장할 변수
		String JOB_TITLE = null;
		int MIN_SALARY=0, MAX_SALARY =0;	////데이터베이스 값 저장할 변수	
		Scanner scan = new Scanner(System.in);
		
		// 드라이브 로딩과 db 연결은 try ~ catch 블럭으로 감싼다.
		 try{				 
			 Class.forName(driver); // 1. jdbc 드라이버 로딩			 
			 con = DriverManager.getConnection(url, uid, pwd);// 2. db 연결		 
			 sql =" insert into hr.jobs " +
				" (JOB_ID,JOB_TITLE,MIN_SALARY,MAX_SALARY) "
				+ " values( ?, ?, ?, ?) ";	// 3. 쿼리문 먼저 작성
			 pstmt = con.prepareStatement(sql);
			 System.out.print("직무번호를 입력하세요");
			 JOB_ID =scan.next();
			 pstmt.setString(1, JOB_ID);	
			 
			 System.out.print("직무이름를 입력하세요 ");
			 JOB_TITLE =scan.next();
			 pstmt.setString(2, JOB_TITLE);
			 
			 System.out.print("최소급여를 입력하세요 ");
			 MIN_SALARY = Integer.parseInt(scan.next());
			 pstmt.setInt(3,MIN_SALARY);
			 
			 System.out.print("최대급여를 입력하세요 ");
			 MAX_SALARY = Integer.parseInt(scan.next());		
			 pstmt.setInt(4,MAX_SALARY);
			 pstmt.executeUpdate(); // insert문 수행
			 
			 System.out.println("새로운 레코드가 추가 되었습니다.");			 	 
	         pstmt.close(); con.close(); scan.close();// DB연결 후 작업이 종료되면 연결 객체을 닫아준다.
		 }catch(Exception e){
			 System.out.println("DB insert에 문제가 있습니다.");
			 e.printStackTrace();
		 }//end try
	}//end main
}//end class
