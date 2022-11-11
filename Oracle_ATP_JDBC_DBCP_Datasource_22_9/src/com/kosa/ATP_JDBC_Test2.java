package com.kosa;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ATP_JDBC_Test2 {

	// 인내심 30초이상 소요
	public static void main(String[] args) {
		Connection con = null;
		Statement stmt = null;
		ResultSet rset = null;
		try {
			String url = 
			"jdbc:oracle:thin:@edudb_high?TNS_ADMIN=C:\\dev\\Oracle_Wallet\\Wallet_edudb";
			String uid = "user01";
			String pwd = "xxxxxxAt21cc";
			String driver = "oracle.jdbc.driver.OracleDriver";
			Class.forName(driver);
			con = DriverManager.getConnection(url, uid, pwd);
			System.out.println(con);
			System.out.println("ATP 제대로 연결되었습니다.");
			stmt = con.createStatement();
			String sql ="SELECT employee_id, first_name FROM employees";
			rset = stmt.executeQuery(sql);
			while (rset.next()) {
				System.out.print(rset.getInt(1) + " ");
				System.out.println(rset.getString(2));
			}//end while
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("연결에 실패하였습니다.");
		} // end try

	}// end main

}// end class
