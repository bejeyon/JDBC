package com.kosa;

import java.sql.Connection;
import java.sql.DriverManager;

public class ATP_JDBC_Test {

	public static void main(String[] args) {
		Connection con = null;
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
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("연결에 실패하였습니다.");
		} // end try

	}// end main

}// end class
