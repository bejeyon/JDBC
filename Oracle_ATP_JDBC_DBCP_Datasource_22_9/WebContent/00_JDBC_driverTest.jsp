<%@ page contentType="text/html; charset=utf-8"%>
<%@ page import="java.sql.*"%>
<%
	//인내심 30초이상 소유

Connection con = null;
Statement stmt = null;
ResultSet rset = null;
try {
	String url = "jdbc:oracle:thin:@edudb_high?TNS_ADMIN=C:\\dev\\Oracle_Wallet\\Wallet_edudb";
	String uid = "user01";
	String pwd = "xxxxxxAt21cc";
	String driver = "oracle.jdbc.driver.OracleDriver";
	Class.forName(driver);
	con = DriverManager.getConnection(url, uid, pwd);
	out.println("제대로 연결되었습니다.");
	stmt = con.createStatement();
	String sql = "SELECT employee_id, first_name FROM employees";
	rset = stmt.executeQuery(sql);
	while (rset.next()) {
		out.println(rset.getInt(1) + "<br>");
		out.println(rset.getString(2)+ "<br>");
	} //end while
} catch (Exception e) {
	e.printStackTrace();
	out.println("연결에 실패하였습니다.");
} // end try
%>
