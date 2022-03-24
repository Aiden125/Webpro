package com.lec.ex06_volume;
// Speaker s = new Speaker();
// s.
public class Speaker implements IVolume {
	private final int SPEAKER_MAX_VOLUME = 70; //private static final byte �ᵵ ��. static�� �������� ���ؼ�. byte�� �޸� ���̷���.
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
			System.out.println("Speaker ������ 1 �÷� ���� ���� : "+volumeLevel);
		}else {
			System.out.println("Speaker ������ �̹� �ִ�ġ�Դϴ�.");
		}
	}

	@Override
	public void volumeUp(int level) {
		if(volumeLevel + level < SPEAKER_MAX_VOLUME) {
			volumeLevel += level;
			System.out.println("Speaker ������"+level+"��ŭ �÷Ƚ��ϴ�. ���� ���� : "+volumeLevel);
		}else {
			int tempLevel = SPEAKER_MAX_VOLUME - volumeLevel;
			volumeLevel = SPEAKER_MAX_VOLUME;
			System.out.println("Speaker ������"+level+"��ŭ �� �ø���"+tempLevel+"��ŭ �÷� �ִ�ġ��"+SPEAKER_MAX_VOLUME+"���� �÷Ƚ��ϴ�. �� �̻� �ø� �� �����ϴ�.");
		}

	}

	@Override
	public void volumeDown() {
		if(volumeLevel > SPEAKER_MIN_VOLUME) {
			volumeLevel --;
			System.out.println("Speaker ������ 1 ���� ���� ���� : "+volumeLevel);
		}else {
			System.out.println("Speaker ������ �̹� 0�Դϴ�.");
		}
	}

	@Override
	public void volumeDown(int level) {
		if(volumeLevel - level >= SPEAKER_MIN_VOLUME) {
			volumeLevel -= level;
			System.out.println("Speaker ������"+level+"��ŭ ���Ƚ��ϴ�. ���� ���� : "+volumeLevel);
		}else {
			int tempLevel = volumeLevel - SPEAKER_MIN_VOLUME;
			volumeLevel = SPEAKER_MIN_VOLUME;
			System.out.println("Speaker ������"+level+"��ŭ �� ������"+tempLevel+"��ŭ ���� �ּ�ġ��"+SPEAKER_MIN_VOLUME+"���� ���Ƚ��ϴ�. �� �̻� ���� �� �����ϴ�.");
		}
	}
}
