package com.myapp;

import java.util.Scanner;//public int nextInt() 메소드를 사용하기 위해 java.util 패키지의 Scanner 클래스 삽입

public class BankApplication {//은행 응용프로그램 구현 클래스
	private static Scanner scanner = new Scanner(System.in);/*public int nextInt() 메소드를 사용하기 위해 Scanner 객체 scanner 생성.
	사용자가 콘솔(키보드)로 값을 입력하면 읽어드리는 표준입력 스트림을 사용하기 위해 생성자는 Scanner(InputStream source)를 사용.
	Scanner 생성자의 매개변수 System클래스의 필드 in은 public static final InputStream in의 형태로 표준입력스트림임.
	The "standard" input stream. This stream is already open and ready to supply input data.
	Typically this stream corresponds to keyboard input or another input source specified by the host environment or user.
	*/
	private static AccountDAO accountDAO = new AccountDAO();//미리 클래스로 data access object로 구현해놓은 AccountDAO 객체인 accountDAO를 생성함.

	public static void main(String[] args) {
		boolean run = true;//사용자 입력값이 5번 종료인 경우 while문을 종료하기 위한 boolean 형태의 run 변수 생성.
		while (run) {
			System.out.println("----------------------------------------------------------");
			System.out.println("1.계좌생성 | 2.계좌목록 | 3.예금 | 4.출금 | 5.종료");
			System.out.println("----------------------------------------------------------");
			System.out.print("선택> ");

			int selectNo = scanner.nextInt();//Scanner 클래스 객체로 nextInt() 메소드를 사용하여 사용자가 콘솔(키보드)로 입력한 값을 받아 int selectNo 변수에 대입하여 저장.

			if (selectNo == 1) {//사용자 입력값이 1.계좌쟁성일 경우
				createAccount();//createAccount() 멤버 메소드 실행.
			} else if (selectNo == 2) {//사용자 입력값이 2.계좌목록일 경우
				accountList();//accountList() 멤버 메소드 실행.
			} else if (selectNo == 3) {//사용자 입력값이 3.예금일 경우
				deposit();//deposit() 멤버 메소드 실행.
			} else if (selectNo == 4) {//사용자 입력값이 4.출금일 경우
				withdraw();//withdraw() 멤버 메소드 실행.
			} else if (selectNo == 5) {//사용자 입력값이 5.종료일 경우
				run = false;//while문 종료를 위해 run변수값 false로 바뀌므로 while문 빠져나감.
			}//end if
		}//end while
		System.out.println("프로그램 종료");//selectNo == 5일 경우 이 코드에 도달 후 main 메소드 빠져나감.
	}//end main

	private static void createAccount() {//계좌생성 메소드
		System.out.println("--------------");
		System.out.println("계좌생성");
		System.out.println("--------------");

		System.out.print("계좌번호: ");
		String ano = scanner.next();//계좌번호값 입력받아 String ano 변수에 저장

		System.out.print("계좌주: ");
		String owner = scanner.next();//계좌주값 입력받아 String owner 변수에 저장

		System.out.print("초기입금액: ");
		int balance = scanner.nextInt();//초기입금액값 입력받아 int balance 변수에 저장

		AccountVO newAccount = new AccountVO(ano, owner, balance);//계좌번호, 계좌주, 계좌잔고를 인캡슐레이트한 클래스인 AccountVO의 객체를 생성하여 입력받은 값을 transfer함.
		accountDAO.accountInsert(newAccount);//바로 위에서 생성되어 값이 갱신된 AccountVO 객체 newAccount를 AccountDAO 클래스 객체의 accountInsert 메소드에 매개변수로 주어 실행.
	}//end createAccount

	private static void accountList() {//계좌목록 출력 메소드
		System.out.println("--------------");
		System.out.println("계좌목록");
		System.out.println("--------------");
		accountDAO.accountList();//AccountDAO 클래스 객체의 accountList() 메소드 실행.
	}//end accountList

	private static void deposit() {//입금 메소드
		System.out.println("--------------");
		System.out.println("예금");
		System.out.println("--------------");
		
		System.out.print("계좌번호: "); 
		String ano = scanner.next();//계좌번호값 입력 받음.
		
		System.out.print("예금액: ");
		int money = scanner.nextInt();//예금액 입력 받음.
		
		boolean isExist = findAccount(ano);//입력받은 계좌번호와 일치하는 계좌번호가 존재하는지 확인.

		if(isExist == false) {
			System.out.println("결과: 계좌가 없습니다.");//일치하는 계좌번호가 존재하지 않을 경우 출력할 메세지.
			return;
		}//end if
		
		AccountVO account = new AccountVO(ano, money);/*일치하는 계좌번호가 있을 경우
		계좌번호, 계좌주, 계좌잔고를 인캡슐레이트한 클래스인 AccountVO의 객체를 매개변수가 계좌번호, 입금액 2개인 생성자로 생성하여 입력받은 값을 transfer함.*/
		accountDAO.accountPlusUpdate(account);//바로 위에서 생성되어 값이 갱신된 AccountVO 객체 Account를 AccountDAO 클래스 객체의 accountPlusUpdate 메소드에 매개변수로 주어 실행.
	}//end deposit

	private static void withdraw() {//출금 메소드
		System.out.println("--------------");
		System.out.println("출금");
		System.out.println("--------------");
		
		System.out.print("계좌번호: "); 
		String ano = scanner.next();//계좌번호값 입력 받음.
		
		System.out.print("출금액: ");
		int money = scanner.nextInt();//출금액 입력 받음.
		
		boolean isExist = findAccount(ano);//입력받은 계좌번호와 일치하는 계좌번호가 존재하는지 확인.

		if(isExist == false) {
			System.out.println("결과: 계좌가 없습니다.");//일치하는 계좌번호가 존재하지 않을 경우 출력할 메세지.
			return;
		}//end if
		
		AccountVO account = new AccountVO(ano, money);/*일치하는 계좌번호가 있을 경우
		계좌번호, 계좌주, 계좌잔고를 인캡슐레이트한 클래스인 AccountVO의 객체를 매개변수가 계좌번호, 출금액 2개인 생성자로 생성하여 입력받은 값을 transfer함.*/
		accountDAO.accountMinusUpdate(account);//바로 위에서 생성되어 값이 갱신된 AccountVO 객체 Account를 AccountDAO 클래스 객체의 accountMinusUpdate 메소드에 매개변수로 주어 실행.
	}//end withdraw

	private static boolean findAccount(String ano) {//입력받은 계좌번호와 일치하는 계좌번호가 존재하는지 확인하는 메소드.
		return accountDAO.accountFindOne(ano);//AccountDAO 클래스의 객체 accountDAO의 메소드 accountFindOne에 계좌번호값 String ano를 매개변수로 주어 실행.
	}//end findAccount
	
		
}//end class
