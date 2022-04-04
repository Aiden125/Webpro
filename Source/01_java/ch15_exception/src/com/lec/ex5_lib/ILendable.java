package com.lec.ex5_lib;

public interface ILendable {
	//data
	public byte STATE_BORROWED=1; //대출중인 상태 static final 생략 
	public byte STATE_NORMAL=0; //대출 가능한 상태 static final 생략
	
	//method
	public void checkOut(String borrower) throws Exception; //대출. 예외처리를 원하면 가장 기초가 되는 곳에 써줄것
	public void checkIn() throws Exception; //반납. 마찬가지로 예외처리를 원해서 여기다가 선언
}
