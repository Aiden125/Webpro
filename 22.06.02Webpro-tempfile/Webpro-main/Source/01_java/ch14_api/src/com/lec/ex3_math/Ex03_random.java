package com.lec.ex3_math;

import java.util.Random;

public class Ex03_random {
	public static void main(String[] args) {
		System.out.println("0~45미만의 double 난수"+Math.random()*45);
		System.out.println("0~45미만의 정수 난수"+(int)(Math.random()*45));
		System.out.println("로또 번호 뽑기(1부터 46까지 정수 난수) : "+((int)(Math.random()*45)+1)); //괄호주의. 잘못하면 계산값에 1이 붙어나와서 몇백나옴
		Random random = new Random();
		System.out.println("int 난수 : " + random.nextInt());
		System.out.println("doulbe 난수 : "+ random.nextDouble()); //math.random과 똑같으나 import가 필요.
		System.out.println("T/F 중 하나 난수 : " + random.nextBoolean());
		System.out.println("0~2사이의 정수 난수 : " + random.nextInt(3)); // 랜덤에 경계값입력 0~3 미만의 정수 난수
		System.out.println("0~45사이의 정수 난수 : " + random.nextInt(46)); // 랜덤에 경계값입력 0~46 미만의 정수 난수
		System.out.println("로또 번호 뽑기 : " + (random.nextInt(45)+1));
	}
}
