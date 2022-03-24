package com.lec.ex11_final;

public class TestMain {
	public static void main(String[] args) {
		Animal[] animals = {
				new Dog(),
				new Rabbit()};
		for(Animal animal : animals) {//타입이 Animal 이기에 Animal을 쓰고 임의 변수 하나 지정 및 배열 함수 지정
			animal.running();
			animal.running();
			animal.stop();
		}
//		animals[0].running();
//		animals[0].running();
//		animals[0].stop();
//		animals[1].running();
//		animals[1].running();
//		animals[1].stop();
	}
}
