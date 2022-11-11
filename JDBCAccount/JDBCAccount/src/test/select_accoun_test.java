package test;

import com.myapp.AccountDAO;


public class select_accoun_test {
	public static void main(String[] args) {
		
		AccountDAO dao = new AccountDAO();
		System.out.println(dao.accountFindOne("222-222"));		
		dao.accountList();		
	}//end main

}//end class
