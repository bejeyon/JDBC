package MAIN;

import java.util.ArrayList;
import java.util.Scanner;//public int nextInt() 메소드를 사용하기 위해 java.util 패키지의 Scanner 클래스 삽입
import DATA_MODEL.*;

public class KioskMain_Test {
	private static Scanner scanner = new Scanner(System.in);/*public int nextInt() 메소드를 사용하기 위해 Scanner 객체 scanner 생성.
	사용자가 콘솔(키보드)로 값을 입력하면 읽어드리는 표준입력 스트림을 사용하기 위해 생성자는 Scanner(InputStream source)를 사용.
	Scanner 생성자의 매개변수 System클래스의 필드 in은 public static final InputStream in의 형태로 표준입력스트림임.
	The "standard" input stream. This stream is already open and ready to supply input data.
	Typically this stream corresponds to keyboard input or another input source specified by the host environment or user.
	*/
	private static KioskDAO kioskDAO = new KioskDAO();//미리 클래스로 data access object로 구현해놓은 AccountDAO 객체인 accountDAO를 생성함.
	
	private static ArrayList<KioskDTO> kioskArrayList = new ArrayList<KioskDTO>();
	private static ArrayList<KioskDTO> stockArrayList = new ArrayList<KioskDTO>();

	public static void main(String[] args) {
		boolean run = true;//사용자 입력값이 5번 종료인 경우 while문을 종료하기 위한 boolean 형태의 run 변수 생성.
		
		while (run) {
			System.out.println("--------------------------------------------------------------------------------------------------------------------------------------");
			System.out.println("101. 아메리카노 \\t  102. 카페라떼 \\t 103. 에스프레소 \\t 104. 우유 \\t 105. 모닝빵 \\n106. 조각케잌 \\t 107. 쿠키 \\t 108. 마카롱 \\t 109. 아이스티 \\t 110. 초코라떼 \\n111.주문하기 \\\\t 112. 종료");
			System.out.println("--------------------------------------------------------------------------------------------------------------------------------------");
			System.out.print("선택> ");

			String selectNo = scanner.next();//Scanner 클래스 객체로 nextInt() 메소드를 사용하여 사용자가 콘솔(키보드)로 입력한 값을 받아 int selectNo 변수에 대입하여 저장.
//insert into T4.order_list(order_id, menu_id, menu_name, unit_price, num_of_sales) values(TO_CHAR(SYSDATE, 'YYYYDDMM')||order_id_seq.NEXTVAL||?, ?, ?, ?, ?) ";
			System.out.println(selectNo);
			if (selectNo.equals("101")) {
				printCount();
				int inputNum = scanner.nextInt();
				//String selectNoStr = Integer.toString(selectNo);
				createOrder(selectNo, selectNo, "아메리카노", 4000, inputNum);
				createStockConsumption(2*inputNum, 201);
			} else if (selectNo.equals("102")) {
				printCount();
				int inputNum = scanner.nextInt();
				//String selectNoStr = Integer.toString(selectNo);
				createOrder(selectNo, selectNo, "카페라떼", 5000, inputNum);
				createStockConsumption(1*inputNum, 201);
				createStockConsumption(1*inputNum, 202);
			} else if (selectNo.equals("103")) {
				printCount();
				int inputNum = scanner.nextInt();
				//String selectNoStr = Integer.toString(selectNo);
				createOrder(selectNo, selectNo, "에스프레소", 6000, inputNum);
				createStockConsumption(1*inputNum, 201);
			} else if (selectNo.equals("104")) {
				printCount();
				int inputNum = scanner.nextInt();
				//String selectNoStr = Integer.toString(selectNo);
				createOrder(selectNo, selectNo, "우유", 3000, inputNum);
				createStockConsumption(1*inputNum, 202);
			} else if (selectNo.equals("105")) {
				printCount();
				int inputNum = scanner.nextInt();
				//String selectNoStr = Integer.toString(selectNo);
				createOrder(selectNo, selectNo, "모닝빵", 2000, inputNum);
				createStockConsumption(1*inputNum, 203);
			} else if (selectNo.equals("106")) {
				printCount();
				int inputNum = scanner.nextInt();
				//String selectNoStr = Integer.toString(selectNo);
				createOrder(selectNo, selectNo, "조각케잌", 6000, inputNum);
				createStockConsumption(1*inputNum, 204);
			} else if (selectNo.equals("107")) {
				printCount();
				int inputNum = scanner.nextInt();
				//String selectNoStr = Integer.toString(selectNo);
				createOrder(selectNo, selectNo, "쿠키", 4000, inputNum);
				createStockConsumption(1*inputNum, 205);
			} else if (selectNo.equals("108")) {
				printCount();
				int inputNum = scanner.nextInt();
				//String selectNoStr = Integer.toString(selectNo);
				createOrder(selectNo, selectNo, "마카롱", 2500, inputNum);
				createStockConsumption(1*inputNum, 206);
			} else if (selectNo.equals("109")) {
				printCount();
				int inputNum = scanner.nextInt();
				//String selectNoStr = Integer.toString(selectNo);
				createOrder(selectNo, selectNo, "아이스티", 6000, inputNum);
				createStockConsumption(1*inputNum, 208);
			} else if (selectNo.equals("110")) {
				printCount();
				int inputNum = scanner.nextInt();
				//String selectNoStr = Integer.toString(selectNo);
				createOrder(selectNo, selectNo, "초코라떼", 6000, inputNum);
				createStockConsumption(1, 207);
				createStockConsumption(1, 202);
			} else if (selectNo.equals("111")) {
				for(int i = 0; i < kioskArrayList.size(); i++) {
					kioskDAO.orderInsert(kioskArrayList.get(i));
					insertSettlement(kioskArrayList.get(i));
				}
				for(int i = 0; i < stockArrayList.size(); i++) {
					kioskDAO.setStock(stockArrayList.get(i));
				}
				while(true) {
					System.out.print("멤버십을 적립하시겠습니까?(예: Y, 아니오: N)");
					String inputMembershipYX = scanner.next();
					if(inputMembershipYX.equalsIgnoreCase("Y")) {
						System.out.print("전화번호: ");
						String guest_phone = scanner.next();
						boolean resultExist = memberFindNumber(guest_phone);
						if(resultExist == true) {
							System.out.println("적립하였습니다.");
							break;
						}
						else {
							System.out.print("이름: ");
							String guest_name = scanner.next();
							memberInsert(guest_name, guest_phone);
							System.out.println("적립하였습니다.");
							break;
						}
					}
					else if(inputMembershipYX.equalsIgnoreCase("N")) {
						run = false;
						break;
					}
					else {
						System.out.println("키값을 잘못 입력하였습니다.");
					}
				}
			} else if (selectNo.equals("112")) {
				run = false;
			} else {
				System.out.println("잘못된 값을 입력하였습니다.");
			}//end if
		}//end while
		System.out.println("프로그램 종료");//selectNo == 5일 경우 이 코드에 도달 후 main 메소드 빠져나감.
	}//end main

	private static void printCount() {
		System.out.println("----------------------------");
		System.out.println("주문하실 메뉴의 개수를 입력해주세요.");				
		System.out.println("----------------------------");
	}
	//insert into T4.order_list(order_id, menu_id, menu_name, unit_price, num_of_sales) values(TO_CHAR(SYSDATE, 'YYYYDDMM')||order_id_seq.NEXTVAL||?, ?, ?, ?, ?) ";

	private static void createOrder(String order_id, String menu_id, String menu_name, int unit_price, int num_of_sales) {
		KioskDTO newOrderDTO = new KioskDTO(order_id, menu_id, menu_name, unit_price, num_of_sales);
		kioskArrayList.add(newOrderDTO);
	}//end createAccount
	
	private static void createStockConsumption(int consumption_stock, int ingredient_id) {
		KioskDTO newStockDTO = new KioskDTO(consumption_stock, ingredient_id);
		stockArrayList.add(newStockDTO);
	}

	private static boolean memberFindNumber(String phoneNumber) {
		return kioskDAO.memberFindOne(phoneNumber);
	}
	
	private static void memberInsert(String guest_name, String guest_phone) {
		KioskDTO newMemberDTO = new KioskDTO(guest_name, guest_phone);
		kioskDAO.setMember(newMemberDTO);
	}
	
	private static void insertSettlement(KioskDTO setSettlementDTO) {
		kioskDAO.setSettlement(setSettlementDTO);
	}
		
}//end class
