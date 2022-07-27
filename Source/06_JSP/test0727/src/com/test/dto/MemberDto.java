package com.test.dto;

import java.sql.Date;

public class MemberDto {
	private int custno;
	private String custname;
	private String phone;
	private String address;
	private Date joindate;
	private String grade;
	private String city;
	
	private String level_name;
	private int sum_price;
	
	public MemberDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	



	public MemberDto(int custno, String custname, String level_name, int sum_price) {
		super();
		this.custno = custno;
		this.custname = custname;
		this.level_name = level_name;
		this.sum_price = sum_price;
	}






	public MemberDto(int custno, String custname, String phone, String address, Date joindate, String grade,
			String city) {
		super();
		this.custno = custno;
		this.custname = custname;
		this.phone = phone;
		this.address = address;
		this.joindate = joindate;
		this.grade = grade;
		this.city = city;
	}
	
	public int getCustno() {
		return custno;
	}
	public void setCustno(int custno) {
		this.custno = custno;
	}
	public String getCustname() {
		return custname;
	}
	public void setCustname(String custname) {
		this.custname = custname;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Date getJoindate() {
		return joindate;
	}
	public void setJoindate(Date joindate) {
		this.joindate = joindate;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}

	public String getLevel_name() {
		return level_name;
	}


	public void setLevel_name(String level_name) {
		this.level_name = level_name;
	}

	public int getSum_price() {
		return sum_price;
	}

	public void setSum_price(int sum_price) {
		this.sum_price = sum_price;
	}
	
	
	
}
