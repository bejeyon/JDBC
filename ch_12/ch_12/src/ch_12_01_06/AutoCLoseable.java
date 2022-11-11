package ch_12_01_06;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public interface AutoCLoseable {

	public void close(Connection conn, Statement stmt, ResultSet rs);
	public void close(Connection conn, Statement stmt);
}//end intr..
