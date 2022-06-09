package com.lec.ex1_list;

import java.util.ArrayList;

public class Ex01_ArrayList {
	public static void main(String[] args) {
		String[] arr = new String[5];
		arr[0] = "str0";
		arr[1] = "str1";
		arr[4] = "str400";
		for(int i=0 ; i<arr.length ; i++) {
			System.out.println(arr[i]);
		}
		System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
		for(String a : arr) {
			System.out.println(a);
		}
		System.out.println("ㅡㅡㅡㅡㅡArrayListㅡㅡㅡㅡㅡ");
		ArrayList<String> arrList = new ArrayList<String>();
		//반드시 객체형으로(래퍼클러스 주소값형태로) 넣을 것. int, double 등 직접적인 값을 갖는 것은 안됨(기초데이터타입은 x)
		//ArrayList<Integer> list = new ArrayList<Integer>();
		arrList.add("str0"); //0번 인덱스
		arrList.add("str1"); //1번 인덱스
		arrList.add("str2"); //2번 인덱스
		arrList.add(1, "str111111"); //1번 인덱스를 다시 넣게되면 1번인덱스 자리를 얘가 차지하고 쭉쭉 밀어냄. 기존의 1번을 2번으로, 기존2번을 3번으로
		System.out.println(arrList);
		arrList.set(1, "111"); //1번 인덱스를 수정
		System.out.println(arrList);
		for(String alist : arrList) {
			System.out.print(alist + "\t");
		}
		System.out.println("\n - remove한 후에 -");
		arrList.remove(1); //1번째 인덱스의 데이터 삭제 (2번->1번, 3번->2번으로 변경)
		// arrList.remove("11111"); //이렇게 특정 인덱스 뿐만이 아닌, 특정 데이터 삭제도 가능 중복된 데이터의 경우 앞에꺼가 지워짐
		arrList.remove(arrList.size()-1); //맨 마지막 인덱스 데이터 삭제
		System.out.println(arrList);
		for(int idx=0 ; idx<arrList.size(); idx++) {
			System.out.printf("%d번째 인덱스 값은 %s\t", idx, arrList.get(idx));
		}
		System.out.println(); //개행
		arrList.clear(); //안에 있는 데이터를 지워서 사이즈를 0으로 만들어줌 (데이터만 비우는것!!)
		if(arrList.size() == 0) {//arrList의 데이터가 0이냐? 즉, 없냐?
			System.out.println("arrList의 데이터는 없습니다");
		}
		if(arrList.isEmpty()) {//데이터가 비었냐? 라고 묻는것. 위에것과 같은 방법
			System.out.println("arrList의 데이터는 없습니다.");
		}
		System.out.println(arrList);
		arrList = null; //arrList 객체 자체를 지움(데이터만이 아닌)
		System.out.println(arrList.size());
	}
}
