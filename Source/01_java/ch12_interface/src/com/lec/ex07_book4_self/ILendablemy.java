package com.lec.ex07_book4_self;

public interface ILendablemy {
	public byte STATE_BORROWED=1;
	public byte STATE_NORMAL=0;
	
	public void checkOut(String borrower, String checkoutDate);
}
