package com.lec.ex4_object;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
//���� �μ��� ���� ����� ���θ��� �ٸ��� �Ѵٸ�? ����, �����, ��ǻ�� ��� ���� �ٸ��� �� �� �ֱ⿡ �̸� �����ؾ��Ѵ�. -��ӵ� String�� �����غ���
//Sawon s1 = new Sawon("a01", "ȫ�浿", "Dept.COMPUTER") - ���� �Ի��� (static�� �� ��� Ŭ������.��ǻ�� �̷������� ����� ���ô� �տ� �ִ� Dept.COMPUTER)
//Sawon s2 = new Sawon("a02", "������", "Dept.HUMANRECOURCES", 2022.3.24) - 3�� 24�� �Ի���
//System.out.prtinln(s1) => [���]a01 [�̸�]ȫ�浿 [�μ�]COMPUTER [�Ի���]2022��3��24��(��)
public class Sawon {
	private String num; // ���
	private String name; // �̸�
	private String dept; // �μ�
	private Date hiredate; //�Ի���
	
	public Sawon(String num, String name, String dept) {
		this.num = num;
		this.name = name;
		this.dept = dept;
		hiredate = new Date(); //�Ի����� �������� �����ϴ� ��ü
	}
	public Sawon(String num, String name, String dept, int y, int m, int d) {
		this.num = num;
		this.name = name;
		this.dept = dept;
		//hiredate = new Date(y-1900, m-1, d); //�Ի����� y�� m�� d�Ϸ�.
		hiredate = new Date(new GregorianCalendar(y, m-1, d).getTimeInMillis());
	}
	@Override
	//System.out.prtinln(s1) => [���]a01 [�̸�]ȫ�浿 [�μ�]COMPUTER [�Ի���]2022��3��24��(��)
	//0. Tostring �������̵� 1. SimpleDateFormat api, 2.String �Լ�(length())�̿�
	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy��M��d��(E)");
		if(dept.length()>10) {
			return "[���]" + num +"\t[�̸�]" + name + "\t[�μ�]" + dept + "\t[�Ի���]" + sdf.format(hiredate);			
		}else
			return "[���]" + num +"\t[�̸�]" + name + "\t[�μ�]" + dept + "\t\t[�Ի���]" + sdf.format(hiredate);			
	}
	
	
}
