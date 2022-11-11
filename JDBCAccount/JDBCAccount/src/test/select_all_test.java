package test;

import com.myapp.AccountDAO;
import com.myapp.AccountVO;

public class select_all_test {
	public static void main(String[] args) {
		
		AccountDAO dao = new AccountDAO();
		dao.accountList();
	}

}//end class
