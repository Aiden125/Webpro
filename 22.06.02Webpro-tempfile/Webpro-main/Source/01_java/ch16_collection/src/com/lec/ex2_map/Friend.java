package com.lec.ex2_map;

import java.text.SimpleDateFormat;
import java.util.Date;
//Friend f = new Friend("全", "010-2222-2222");
//syso(f) => 全狼 楷遏贸 010-2222-2222 积老 04岿 14老
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
	//syso(f) = > 全狼 楷遏贸 010-2222-2222, 积老:04老
	
	@Override
	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat("积老 : MM岿 dd老");
		if(birth != null) {
			return name +"狼 楷遏贸 : "+tel+ "," + sdf.format(birth);
		}
		return name+"狼 楷遏贸 : "+tel;
	}
	
	
}
