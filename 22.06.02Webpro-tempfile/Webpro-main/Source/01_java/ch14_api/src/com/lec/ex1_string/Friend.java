package com.lec.ex1_string;

public class Friend {
	private String name;
	private String phone;
	private String birthday;
	
	public Friend(String name, String phone, String birthday) {
		this.name = name;
		this.phone = phone;
		this.birthday = birthday;
	}
	
	public String toString() {
		return "�̸� : "+getName()+"\n"+"�ڵ��� : "+getPhone()+"\n"+"���� : "+getBirthday();
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

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	
	
	
	
}
