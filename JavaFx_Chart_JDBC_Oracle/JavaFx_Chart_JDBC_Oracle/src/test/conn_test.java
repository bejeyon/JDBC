package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import application.DBConnection;

public class conn_test {


	public static void main(String[] args) throws SQLException {
		//db연결 싱글턴 패턴
		Connection con = DBConnection.getConnection();		
		System.out.println(con);
		//오토커밋 여뷰
		System.out.println(con.getAutoCommit());
		
		
	}// end main
}// end class
