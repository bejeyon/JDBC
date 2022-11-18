package test;

import application.ChartDAO;
import application.ChartVO;
public class select_test {
	public static void main(String[] args) {
		
		ChartDAO dao = new ChartDAO();
		
		for( ChartVO i : dao.getData()) {
			System.out.println(i.toString());
		}//end for
		
		
		
	}

}//end class
