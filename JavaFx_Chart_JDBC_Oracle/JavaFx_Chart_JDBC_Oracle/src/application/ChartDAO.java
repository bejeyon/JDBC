package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;




public class ChartDAO {

	public ChartDAO() {
		super();
	}

	private Connection conn = DBConnection.getConnection();
	
	public List<ChartVO> getData()	{
		List<ChartVO> list = new ArrayList();
		String sql = 
		"select job_id , sum(salary) sum from hr.employees group by job_id ";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs =  pstmt.executeQuery();
			while (rs.next()) {
				ChartVO vo =new ChartVO();
				vo.setJob_id(rs.getString(1));
				vo.setSum(rs.getInt(2));
				list.add(vo);
			}//end while
			System.out.println();
		} catch (SQLException e) {
			System.out.println("에러 발생!");
			System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
		}//end try	
		
		
		return list;		
	}//end getData
}//end 
