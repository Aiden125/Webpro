package com.lec.ex3_math;

import java.util.Random;

// 로또번호 6개 뽑기
public class Ex04 {
	public static void main(String[] args) {
		int[] lotto = new int[6];
		Random random = new Random();
		
		//로또번호 6개 추출
		for (int idx = 0; idx < lotto.length; idx++) { // 확장for문을 쓸 경우 데이터 수정이 안돼서 확장 for문을 쓰면 안됨.
			// lotto[idx] = (random.nextInt(45) + 1); 배열에 중복된 값이 들어갈 수 있는 경우기에 제외
			int temp = random.nextInt(45) + 1; //뽑은 난수를 임시 변수에 저장하고
			boolean ok = true; // 뽑은 난수가 중복이 아닐경우 true / 중복일 경우 false
			for(int i=0 ; i<idx ; i++) {
				if(temp == lotto[i]) { //뽑은 난수가 중복되었는지.
					idx--;
					ok = false;
					break; //현재있는 for문을 빠져나가게 해주는 변수
				}
			} // for : 발생된 난수가 이전 앞방에 저장되었는지 확인(중복된 난수인지)
			if(ok) { //ok가 true면 lotto값이 설정됨
				lotto[idx] = temp;
			}
		}
		
		//오름차순 정렬
		for (int i = 0; i < lotto.length; i++) {
			for (int j = i + 1; j < lotto.length; j++) {
				if (lotto[i] > lotto[j]) {
					int temp = lotto[i];
					lotto[i] = lotto[j];
					lotto[j] = temp;
				}
			}
		}
		
		//프린트
		for (int l : lotto) {
			System.out.print(l + " ");

		}
	}
}
