package com.lec.ex3_exceptionExs;
// Friend f = new Friend("���", "010-9999-2222")
// Friend f = new Friend("���")
// sysout(f) => [�̸�]��� [��ȭ]***-****-99999 [�Է���]22��4��1��

import java.text.SimpleDateFormat;
import java.util.Date;

public class Friend {
	private String name;
	private String tel;
	private Date enterDate;
	public Friend(String name) {
		this.name = name;
		enterDate = new Date(); //��ü ���� ������ ��¥���� �ǰ��ϴ� ����
	}
	public Friend(String name, String tel) {
		this.name = name;
		this.tel = tel;
		enterDate = new Date(); //��ü ���� ������ ��¥���� �ǰ��ϴ� ����
	}
	@Override
	public String toString() { //sysout(f) => [�̸�]��� [��ȭ]***-****-99999 [�Է���]22��4��1��
		String telPost;
		if(tel!=null) {
			String post = tel.substring(tel.lastIndexOf('-')+1); // 010-1234-1234 //������ ���ڸ��� ��������.(����ε������� �������� ��ȯ(������-�� �ִ°�))
			telPost = "***-****-" + post;
		}else { 
			telPost = "��ȣ����\t";
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yy��M��d�� ģ����");
		return String.format("[�̸�]%s\t[��ȭ]%s\t[�Է���]%s", name, telPost, sdf.format(enterDate));
		
		//try-catch�� �� ���
//		try {
//			String post = tel.substring(tel.lastIndexOf('-')+1); // 010-1234-1234 //������ ���ڸ��� ��������.(����ε������� �������� ��ȯ(������-�� �ִ°�))
//			SimpleDateFormat sdf = new SimpleDateFormat("yy��M��d�� ģ����");
//			return String.format("[�̸�]%s\t[��ȭ]***-***-%s\t[�Է���]%s", name, post, sdf.format(enterDate));
//		}catch(Exception e) {
//			SimpleDateFormat sdf = new SimpleDateFormat("yy��M��d�� ģ����");
//			return String.format("[�̸�]%s\t[��ȭ]��ȣ����\t[�Է���]%s", name, sdf.format(enterDate));			
//		}
						//return "[�̸�]"+name+"\t[��ȭ]***-****-"+post+"\t[�Է���]"+sdf.format(enterDate);
	}
	public Date getEnterDate() {
		return enterDate;
	}
	public void setEnterDate(Date enterDate) {
		this.enterDate = enterDate;
	}
	
}
