package com.lec.ex4_object;
//Ŭ�ι�, ���̾�, �����̵�, ��Ʈ ��翡 1~13 ����
public class Card {
	private char kind; // �����ߢ� Ŭ�ι�, ���̾�, �����̵�, ��Ʈ
	private int num;

	public Card(char kind, int num) {
		this.kind = kind;
		this.num = num;
	}
	@Override
	public String toString() {
		return "ī��� " + kind + " , " + num;
	}
	// c1.equals(c2) => c1���� kind�� c2�� kind, c1�� num�� c2�� num�� ��
	@Override
	public boolean equals(Object obj) {
		// c1.equals(c2) => c1�� �� ��ü, c2�� obj.
		if (obj!=null && obj instanceof Card) {// �� ��ü�� kind�� obj.kind���ϴ� ���
			boolean kindChk = (kind == ((Card) obj).kind); //���� �� Card�� ����� ����ȯ
			boolean numChk = (num == ((Card)obj).num); //��ȣ �� Card�� ����� ����ȯ
			return kindChk && numChk;  //�� �� Ʈ��� Ʈ�縦 �����ϰ�
		} 
		return false;

	}
}
