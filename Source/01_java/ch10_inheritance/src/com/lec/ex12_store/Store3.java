package com.lec.ex12_store;
//Áõ±Ç°¡¿¡ ¸ÅÀå3È£Á¡: ±èÄ¡Âî°³-6,000  ºÎ´ëÂî°³-7,000  ºñºö¹ä-7,000 ¼ø´ë±¹-6,000
public class Store3 extends HeadQuarterStore {

	public Store3(String str) {
		super(str);
		// TODO Auto-generated constructor stub
	}
	@Override
	public void kimchi() {
		System.out.println("±èÄ¡Âî°³ - 6,000¿ø");
	}
	@Override
	public void bude() {
		System.out.println("ºÎ´ëÂî°³ - 7,000¿ø");
	}
	@Override
	public void bibib() {
		System.out.println("ºñºö¹ä - 7,000¿ø");
	}
	@Override
	public void sunde() {
		System.out.println("¼ø´ë±¹ - 6,000¿ø");
	}

}
