package com.lec.ex06_volume;

public interface IVolume {
	public void volumeUp();
	public void volumeUp(int level);
	public void volumeDown();
	public void volumeDown(int level);
	public default void setMute(boolean mute) { //default를 넣으면 인터페이스에서도 일반메소드 사용가능
		if(mute) {
			System.out.println("무음 처리합니다.");
		}else {
			System.out.println("무음 해제합니다.");
		}
	}
}
