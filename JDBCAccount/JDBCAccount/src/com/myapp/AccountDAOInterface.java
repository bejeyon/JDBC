package com.myapp;

public interface AccountDAOInterface {
	void accountInsert(AccountVO newAccount);//계좌추가 추상메서드
	void accountList();//계좌내역 출력 추상메서드
	void accountPlusUpdate(AccountVO account);//계좌잔고 입금 추상메서드
	void accountMinusUpdate(AccountVO account);//계좌잔고 출금 추상메서드
	boolean accountFindOne(String ano);//기존 계좌 유무 check 추상메서드
}//end interface