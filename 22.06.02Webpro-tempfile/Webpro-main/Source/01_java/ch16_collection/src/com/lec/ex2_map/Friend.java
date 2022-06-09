package com.lec.ex2_map;

import java.text.SimpleDateFormat;
import java.util.Date;
//Friend f = new Friend("ȫ", "010-2222-2222");
//syso(f) => ȫ�� ����ó 010-2222-2222 ���� 04�� 14��
public class Friend {
	private String name;
	private String tel;
	private Date birth;
	
	
	public Friend(String name, String tel) {
		this.name = name;
		this.tel = tel;
	}
	
	public Friend(String name, String tel, Date birth) {
		this.name = name;
		this.tel = tel;
		this.birth = birth;
	}
	//syso(f) = > ȫ�� ����ó 010-2222-2222, ����:04��
	
	@Override
	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat("���� : MM�� dd��");
		if(birth != null) {
			return name +"�� ����ó : "+tel+ "," + sdf.format(birth);
		}
		return name+"�� ����ó : "+tel;
	}
	
	
}
