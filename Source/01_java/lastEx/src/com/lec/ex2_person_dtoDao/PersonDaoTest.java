package com.lec.ex2_person_dtoDao;

import java.util.ArrayList;
import java.util.Vector;

public class PersonDaoTest {
	public static void main(String[] args) {
		System.out.println("--------------------1번 테스트--------------------");
		PersonDao dao = PersonDao.getInstance();
		PersonDto dto = new PersonDto("김길순", "배우", 50, 60, 100);
		int result = dao.insertPerson(dto); // 입력 test
		System.out.println(result==PersonDao.SUCCESS? "입력성공":"입력실패");
		
		System.out.println("--------------------2번 테스트--------------------");
		ArrayList<PersonDto> dtos = dao.selectJname("가수"); //직업별 조회 test
		if(!dtos.isEmpty()) {
			for(PersonDto d : dtos) {
				System.out.println(d);
			}
		}else {
			System.out.println("해당 직업인 사람 정보가 없습니다.");
		}
		
		System.out.println("--------------------3번 테스트--------------------");
		dtos = dao.selectAll(); // 3.전체조회 test
		if(dtos.size()!=0) {
			for(PersonDto d : dtos) {
				System.out.println(d);
			}
		}else {
			System.out.println("등록된 사람이 없습니다");
		}
		Vector<String> jnames = dao.jnamelist(); // 4. 직업명리스트 test
		System.out.println(jnames);
	}
}
