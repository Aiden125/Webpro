package com.lec.ex1_list;

import java.util.Vector;
//vector를 쓰면 toString 오버라이드 꼭 해주기.
public class Ex03_Vector {
	public static void main(String[] args) {
		Vector<Object> vec = new Vector<Object>();
		vec.add(10); //==vec.add(new Integer(10)); 0번 인덱스
		vec.add(new AClass());//1번 인덱스.
		BClass objB = new BClass();//2번 인덱스를 만들기위한 정의
		vec.add(objB);//2번 인덱스(위 AClass처럼 한번에 정의해도됨)
		System.out.println(vec);
		System.out.println();//개행
		for(Object obj : vec) {
			System.out.println(obj);
		}
		System.out.println();//개행
		for(int idx=0 ; idx<vec.size() ; idx++) {
			System.out.println(vec.get(idx));
		}
	}
}
