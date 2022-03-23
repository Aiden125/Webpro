package com.lec.ex06_volume;

public class TestMain {
	public static void main(String[] args) {
		IVolume[] volumes = {new TV(3), new Speaker(5), new TV(10), new Speaker(20)};
		for(IVolume temp : volumes) {
			temp.volumeUp();
			temp.volumeDown(20);
			temp.volumeUp(10);
			temp.volumeUp(45);
		}
	}
}
