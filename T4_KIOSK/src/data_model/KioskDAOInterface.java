package data_model;

public interface KioskDAOInterface {
	void orderInsert(KioskDTO newKioskOrderDTO);
	void getMenu(String menu_id, String menu_name, int unit_cost, int unit_price);
	void setStock(KioskDTO setStockDTO);
	void setSettlement(KioskDTO setSettlementDTO);
	void setMember(KioskDTO setMemberDTO);
	void savePoint(KioskDTO savePointDTO);
	String viewPoint(KioskDTO savePointDTO);
	boolean memberFindOne(String guest_phone);
	
	//String menu_id, String menu_name, int unit_price, int num_of_sales
	//int ingredient_id, String ingredient_name, int unit_cost, int available_stock
	//String menu_id, String menu_name, int num_of_sales, int unit_cost, int unit_price, int profit_margin
	//String guest_name, String guest_phone
}
