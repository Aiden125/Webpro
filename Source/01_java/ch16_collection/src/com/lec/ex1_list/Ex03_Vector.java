package com.lec.ex1_list;

import java.util.Vector;
//vector�� ���� toString �������̵� �� ���ֱ�.
public class Ex03_Vector {
	public static void main(String[] args) {
		Vector<Object> vec = new Vector<Object>();
		vec.add(10); //==vec.add(new Integer(10)); 0�� �ε���
		vec.add(new AClass());//1�� �ε���.
		BClass objB = new BClass();//2�� �ε����� ��������� ����
		vec.add(objB);//2�� �ε���(�� AClassó�� �ѹ��� �����ص���)
		System.out.println(vec);
		System.out.println();//����
		for(Object obj : vec) {
			System.out.println(obj);
		}
		System.out.println();//����
		for(int idx=0 ; idx<vec.size() ; idx++) {
			System.out.println(vec.get(idx));
		}
	}
}
