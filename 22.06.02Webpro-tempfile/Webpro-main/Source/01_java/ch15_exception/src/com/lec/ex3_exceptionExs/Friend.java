package com.lec.ex3_exceptionExs;
// Friend f = new Friend("김삿갓", "010-9999-2222")
// Friend f = new Friend("김삿갓")
// sysout(f) => [이름]김삿갓 [전화]***-****-99999 [입력일]22월4월1일

import java.text.SimpleDateFormat;
import java.util.Date;

public class Friend {
	private String name;
	private String tel;
	private Date enterDate;
	public Friend(String name) {
		this.name = name;
		enterDate = new Date(); //개체 만든 시점이 날짜값이 되게하는 문장
	}
	public Friend(String name, String tel) {
		this.name = name;
		this.tel = tel;
		enterDate = new Date(); //개체 만든 시점이 날짜값이 되게하는 문장
	}
	@Override
	public String toString() { //sysout(f) => [이름]김삿갓 [전화]***-****-99999 [입력일]22년4월1일
		String telPost;
		if(tel!=null) {
			String post = tel.substring(tel.lastIndexOf('-')+1); // 010-1234-1234 //마지막 끝자리만 가져오게.(몇번인덱스부터 끝까지를 반환(마지막-가 있는곳))
			telPost = "***-****-" + post;
		}else { 
			telPost = "번호없음\t";
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yy년M월d일 친구됨");
		return String.format("[이름]%s\t[전화]%s\t[입력일]%s", name, telPost, sdf.format(enterDate));
		
		//try-catch로 쓴 경우
//		try {
//			String post = tel.substring(tel.lastIndexOf('-')+1); // 010-1234-1234 //마지막 끝자리만 가져오게.(몇번인덱스부터 끝까지를 반환(마지막-가 있는곳))
//			SimpleDateFormat sdf = new SimpleDateFormat("yy년M월d일 친구됨");
//			return String.format("[이름]%s\t[전화]***-***-%s\t[입력일]%s", name, post, sdf.format(enterDate));
//		}catch(Exception e) {
//			SimpleDateFormat sdf = new SimpleDateFormat("yy년M월d일 친구됨");
//			return String.format("[이름]%s\t[전화]번호없음\t[입력일]%s", name, sdf.format(enterDate));			
//		}
						//return "[이름]"+name+"\t[전화]***-****-"+post+"\t[입력일]"+sdf.format(enterDate);
	}
	public Date getEnterDate() {
		return enterDate;
	}
	public void setEnterDate(Date enterDate) {
		this.enterDate = enterDate;
	}
	
}
