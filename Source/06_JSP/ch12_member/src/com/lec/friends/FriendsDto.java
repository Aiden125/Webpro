package com.lec.friends;

public class FriendsDto {
	private int no;
	private String name;
	private String phone;
	
	public FriendsDto() {
	}
	
	public FriendsDto(int no, String name, String phone) {
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

	@Override
	public String toString() {
		return "[no=" + no + ", name=" + name + ", phone=" + phone + "]";
	}
	
	
}
