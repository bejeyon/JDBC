package data_model;

public class KioskDTO {
	//	1	메뉴ID	MENU_ID
	//	2	메뉴명	MENU_NAME
	//	3	원가	UNIT_COST
	//	4	판매가	UNTI_PRICE
	//	5	재료ID(PK)	INGREDIENT_ID
	//	6	원재료명	INGREDIENT_NAME
	//	7	수량	AVAILABLE_STOCK
	//	8	주문번호(PK)	ORDER_ID
	//	9	판매건수	NUM_OF_SALES
	//	10	주문자(FK)	GUEST_NAME -> column1
	//	11	주문자 핸드폰(PK)	GUEST_PHONE -> column2
	//	12	회원Point 	GUEST_POINT -> column3
	//	13	마진	PROFIT_MARGIN
	
	private String menu_id;
	private String menu_name;
	private int unit_cost;
	private int unit_price;
	private int ingredient_id;
	private String ingredient_name;
	private int available_stock;
	private String order_id;
	private int num_of_sales;
	private String column1;
	private String column2;
	private int column3;
	private int profit_margin;
	
	
	public String getMenu_id() {
		return menu_id;
	}
	public void setMenu_id(String menu_id) {
		this.menu_id = menu_id;
	}
	public String getMenu_name() {
		return menu_name;
	}
	public void setMenu_name(String menu_name) {
		this.menu_name = menu_name;
	}
	public int getUnit_cost() {
		return unit_cost;
	}
	public void setUnit_cost(int unit_cost) {
		this.unit_cost = unit_cost;
	}
	public int getUnit_price() {
		return unit_price;
	}
	public void setUnit_price(int unti_price) {
		this.unit_price = unti_price;
	}
	public int getIngredient_id() {
		return ingredient_id;
	}
	public void setIngredient_id(int ingredient_id) {
		this.ingredient_id = ingredient_id;
	}
	public String getIngredient_name() {
		return ingredient_name;
	}
	public void setIngredient_name(String ingredient_name) {
		this.ingredient_name = ingredient_name;
	}
	public int getAvailable_stock() {
		return available_stock;
	}
	public void setAvailable_stock(int available_stock) {
		this.available_stock = available_stock;
	}
	public String getOrder_id() {
		return order_id;
	}
	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}
	public int getNum_of_sales() {
		return num_of_sales;
	}
	public void setNum_of_sales(int num_of_sales) {
		this.num_of_sales = num_of_sales;
	}
	public String getColumn1() {
		return column1;
	}
	public void setColumn1(String column1) {
		this.column1 = column1;
	}
	public String getColumn2() {
		return column2;
	}
	public void setColumn2(String column2) {
		this.column2 = column2;
	}
	public int getColumn3() {
		return column3;
	}
	public void setColumn3(int column3) {
		this.column3 = column3;
	}
	public int getProfit_margin() {
		return profit_margin;
	}
	public void setProfit_margin(int profit_margin) {
		this.profit_margin = profit_margin;
	}
	public KioskDTO() {
		// TODO Auto-generated constructor stub
	}
	public KioskDTO(String menu_id) {
		super();
		this.menu_id = menu_id;
	}
	public KioskDTO(String order_id, String menu_id, String menu_name, int unit_price, int num_of_sales) {
		super();
		this.menu_id = menu_id;
		this.menu_name = menu_name;
		this.unit_price = unit_price;
		this.order_id = order_id;
		this.num_of_sales = num_of_sales;
	}
	public KioskDTO(String menu_id, String menu_name, int unit_price, int num_of_sales) {
		super();
		this.menu_id = menu_id;
		this.menu_name = menu_name;
		this.unit_price = unit_price;
		this.num_of_sales = num_of_sales;
	}
	public KioskDTO(int ingredient_id, String ingredient_name, int unit_cost, int available_stock) {
		super();
		this.unit_cost = unit_cost;
		this.ingredient_id = ingredient_id;
		this.ingredient_name = ingredient_name;
		this.available_stock = available_stock;
	}
	public KioskDTO(String menu_id, String menu_name, int unit_cost, int unit_price, int num_of_sales,
			int profit_margin) {
		super();
		this.menu_id = menu_id;
		this.menu_name = menu_name;
		this.unit_cost = unit_cost;
		this.unit_price = unit_price;
		this.num_of_sales = num_of_sales;
		this.profit_margin = profit_margin;
	}
	public KioskDTO(String column1, String column2) {
		super();
		this.column1 = column1;
		this.column2 = column2;
	}
	public KioskDTO(int available_stock, int ingredient_id) {
		super();
		this.ingredient_id = ingredient_id;
		this.available_stock = available_stock;
	}
	public KioskDTO(String column2, int column3) {
		super();
		this.column2 = column2;
		this.column3 = column3;
	}
	
}
