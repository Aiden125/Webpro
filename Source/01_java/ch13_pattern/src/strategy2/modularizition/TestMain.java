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
		System.out.println("소나타를 하이브리드로 교체하고 연비를 20Km/l로 교체해주세요");
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
