package DATA_MODEL;

public interface KioskDAOInterface {
	//	void accountInsert(AccountVO newAccount);//계좌추가 추상메서드
	//	void accountList();//계좌내역 출력 추상메서드
	//	void accountPlusUpdate(AccountVO account);//계좌잔고 입금 추상메서드
	//	void accountMinusUpdate(AccountVO account);//계좌잔고 출금 추상메서드
	//	boolean accountFindOne(String ano);//기존 계좌 유무 check 추상메서드
	
	void orderInsert(KioskDTO newKioskOrderDTO);
	void getMenu(String menu_id, String menu_name, int unit_cost, int unit_price);
	void setStock(int consumption_stock, int ingredient_id);
	void setSettlement(KioskDTO setSettlementDTO);
	void memberInsert(String guest_name, String guest_phone);
	void setMember(KioskDTO setMemberDTO);
	boolean memberFindOne(String guest_name, String guest_phone);
	
	//String menu_id, String menu_name, int unit_price, int num_of_sales
	//int ingredient_id, String ingredient_name, int unit_cost, int available_stock
	//String menu_id, String menu_name, int num_of_sales, int unit_cost, int unit_price, int profit_margin
	//String guest_name, String guest_phone
}
