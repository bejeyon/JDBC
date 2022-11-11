package test;

import com.myapp.AccountDAO;
import com.myapp.AccountVO;

public class insert_test {
	public static void main(String[] args) {
		
		AccountDAO dao = new AccountDAO();
		//db에 데이터 있는지 확인 후 진행
		AccountVO test =new  AccountVO("444-444", "test", 3000);
		dao.accountInsert(test);
		dao.accountList();
	}

}//end class
