<%@page import="java.sql.Connection"%>
<%@page import="javax.sql.DataSource"%>
<%@page import="javax.naming.InitialContext"%>
<%@page import="javax.naming.Context"%>
<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!--인내심 30초 이상 소요  -->
	<h4>디비 연동</h4>
	<%
		Statement stmt = null;
	ResultSet rset = null;
	try {
		//web.xml, context.xml
		Context initContext = new InitialContext();
		Context envContext = (Context) initContext.lookup("java:/comp/env");
		DataSource ds = (DataSource) envContext.lookup("jdbc/myoracle");
		Connection conn = ds.getConnection();
		out.println("DBCP 연동 성공");
		stmt = conn.createStatement();
		String sql = "SELECT employee_id, first_name FROM employees";
		rset = stmt.executeQuery(sql);
		while (rset.next()) {
			out.println(rset.getInt(1) + " ");
			out.println(rset.getString(2));
		} //end while
	} catch (Exception e) {
		e.printStackTrace();
		System.out.println("연결에 실패하였습니다.");
	} // end try
	%>
</body>
</html>