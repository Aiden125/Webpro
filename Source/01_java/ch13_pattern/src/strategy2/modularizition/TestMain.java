package strategy2.modularizition;

import strategy2.interfaces.FuelHybrid;
import strategy2.interfaces.Km20;

public class TestMain {
	public static void main(String[] args) {
		Car genesis = new Genesis();
		Car sonata = new Sonata();
		Car accent = new Accent();
		Car[] cars = {genesis, sonata, accent};
		for(Car car : cars) {
			car.shape();
			car.drive();
			car.engine();
			car.fuel();
			car.km();
		}
		System.out.println("");
		System.out.println("�ҳ�Ÿ�� ���̺긮��� ��ü�ϰ� ���� 20Km/l�� ��ü���ּ���");
		sonata.setFuel(new FuelHybrid());
		sonata.setKm(new Km20());
		for(int idx=0 ; idx<cars.length ; idx++) {
			cars[idx].shape();
			cars[idx].drive();
			cars[idx].engine();
			cars[idx].km();
			cars[idx].fuel();
		}
	}
}