package test;

import com.myapp.AccountDAO;
import com.myapp.AccountVO;

public class update_test_1 {
	public static void main(String[] args) {
		
		AccountDAO dao = new AccountDAO();
		dao.accountList();
		AccountVO vo =new AccountVO("444-444", "test", 100);
		dao.accountPlusUpdate(vo);
		dao.accountList();
	}//end main

}//end class
