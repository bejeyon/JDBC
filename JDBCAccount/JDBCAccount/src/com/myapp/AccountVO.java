package com.myapp;

public class AccountVO {//계좌 DTO Data Transfer Object
	private String ano;//계좌번호 필드
	private String owner;//계좌주 필드
	private double balance;//계좌잔고 필드
	
	public AccountVO(String ano, String owner, double balance) {//계좌번호,계좌주,계좌잔고 매개변수 3개를 받아서 값을 집어넣는 setter 역할 생성자
		super();
		this.ano = ano;//계좌번호 필드값 입력
		this.owner = owner;//계좌주 필드값 입력
		this.balance = balance;//계좌잔고 필드값 입력
	}

	protected String getAno() {//계좌번호 필드값 getter
		return ano;
	}

	protected void setAno(String ano) {//계좌번호 필드값 setter
		this.ano = ano;
	}

	protected String getOwner() {//계좌주 필드값 getter
		return owner;
	}

	protected void setOwner(String owner) {//계좌주 필드값 setter
		this.owner = owner;
	}

	protected double getBalance() {//계좌잔고 필드값 getter
		return balance;
	}

	protected void setBalance(double balance) {//계좌잔고 필드값 setter
		this.balance = balance;
	}

	public AccountVO(String ano, double balance) {//계좌번호,계좌잔고 매개변수 2개를 받아서 값을 집어넣는 setter 역할 생성자
		super();
		this.ano = ano;
		this.balance = balance;
	}//end AccountVO
}//end class



