package com.lec.friends;

public class FriendsDto {
	private int no;
	private String name;
	private String phone;
	
	public FriendsDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public FriendsDto(int no, String name, String phone) {
		super();
		this.no = no;
		this.name = name;
		this.phone = phone;
	}
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	
}