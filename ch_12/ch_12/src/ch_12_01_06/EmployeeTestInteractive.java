package ch_12_01_06;

import java.util.List;

public class EmployeeTestInteractive {
	
	public static void main(String[] args) {
		EmployeeDAO dao = EmployeeDAOJDBCImpl.getInstance();
		
		List list =dao.getAllEmployee();
		list.forEach( i -> {
			System.out.println(i);
		});
		
	}//end class

}//end 
