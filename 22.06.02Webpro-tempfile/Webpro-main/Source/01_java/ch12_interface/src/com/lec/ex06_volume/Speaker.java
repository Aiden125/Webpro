package com.lec.ex06_volume;
// Speaker s = new Speaker();
// s.
public class Speaker implements IVolume {
	private final int SPEAKER_MAX_VOLUME = 70; //private static final byte 써도 됨. static은 가독성을 위해서. byte는 메모리 줄이려고.
	private final int SPEAKER_MIN_VOLUME = 10;
	private int volumeLevel;
	
	public Speaker() {}
	public Speaker(int volumeLevel) {
		this.volumeLevel = volumeLevel;
	}

	@Override
	public void volumeUp() {
		if(volumeLevel < SPEAKER_MAX_VOLUME) {
			volumeLevel ++;
			System.out.println("Speaker 볼륨을 1 올려 현재 볼륨 : "+volumeLevel);
		}else {
			System.out.println("Speaker 볼륨이 이미 최대치입니다.");
		}
	}

	@Override
	public void volumeUp(int level) {
		if(volumeLevel + level < SPEAKER_MAX_VOLUME) {
			volumeLevel += level;
			System.out.println("Speaker 볼륨을"+level+"만큼 올렸습니다. 현재 볼륨 : "+volumeLevel);
		}else {
			int tempLevel = SPEAKER_MAX_VOLUME - volumeLevel;
			volumeLevel = SPEAKER_MAX_VOLUME;
			System.out.println("Speaker 볼륨을"+level+"만큼 못 올리고"+tempLevel+"만큼 올려 최대치인"+SPEAKER_MAX_VOLUME+"까지 올렸습니다. 더 이상 올릴 수 없습니다.");
		}

	}

	@Override
	public void volumeDown() {
		if(volumeLevel > SPEAKER_MIN_VOLUME) {
			volumeLevel --;
			System.out.println("Speaker 볼륨을 1 내려 현재 볼륨 : "+volumeLevel);
		}else {
			System.out.println("Speaker 볼륨이 이미 0입니다.");
		}
	}

	@Override
	public void volumeDown(int level) {
		if(volumeLevel - level >= SPEAKER_MIN_VOLUME) {
			volumeLevel -= level;
			System.out.println("Speaker 볼륨을"+level+"만큼 내렸습니다. 현재 볼륨 : "+volumeLevel);
		}else {
			int tempLevel = volumeLevel - SPEAKER_MIN_VOLUME;
			volumeLevel = SPEAKER_MIN_VOLUME;
			System.out.println("Speaker 볼륨을"+level+"만큼 못 내리고"+tempLevel+"만큼 내려 최소치인"+SPEAKER_MIN_VOLUME+"까지 내렸습니다. 더 이상 내릴 수 없습니다.");
		}
	}
}
