package com.lec.ex4.quiz;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

public class TestMain2 {
	public static void main(String[] args) {
		//해시맵의 경우 키, 밸류값만 지정해서 씀
		HashMap<String, Member> map = new HashMap<String, Member>();
		Scanner sc = new Scanner(System.in);
		
		while(true) { 
			System.out.println("이름을 입력해주세요 (중지는 N/n)");
			String name = sc.next();
			if(name.equalsIgnoreCase("n")) {//중복된 값이 있는 경우
				break; //while문을 빠져나가게 해줌
			}
			System.out.println("번호를 입력해주세요");
			String number = sc.next();
			//넘버의 경우 받는 값이기 때문에. 이미 받는값을 맵에서 조회했을 때 이미 들어있는 값이면 중복됐다는 뜻
			if(map.get(number) != null) {
				System.out.println("전화번호가 중복되었습니다.");
				continue; //이 문장을 뛰어넘고 다시 while을 시작하게 해줌
			}
			System.out.println("주소를 입력해주세요");
			sc.nextLine(); //버퍼 지우기
			String address = sc.nextLine();
			//맵에 키, 밸류 형태로 넣는데 키 값은 번호기 때문에 번호, 밸류값 넣기
			map.put(number, new Member(name, number, address));
		}
		if(map.isEmpty()) {
			System.out.println("가입된 회원이 없습니다.");
		}
		//맵에서 이터레이터는 키 값을 넣어주는 것이고 다른컬렉션에서는 데이터 타입을 넣는 형태
		Iterator<String> iterator = map.keySet().iterator();
		while(iterator.hasNext()) {
			//키 = 복사한 것 다음 키를
			String key = iterator.next();
			System.out.println(map.get(key));
		}
		sc.close();
	}
}
