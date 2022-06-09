package com.lec.ex04_actor;

public class TestMain {
	public static void main(String[] args) {
		
		//Actor��� ū �ٷ��̿��� actor Ÿ������ ����Ǳ⿡ �� ����
		Actor park = new Actor("��� �ں���");
		park.canCatchCriminal();
		park.outFire();
		park.makeSpaghetti();
		park.canSearch();
		
		//Actor��� ū �ٷ��̿��� ���� Ÿ������ ����Ǳ⿡ �丮�� ����
		IChef IU = new Actor("�丮�� ������");
		IU.makePizza();
		IU.makeSpaghetti();
		
		//Actor��� ū �ٷ��̿��� �ҹ�� Ÿ������ �����
		IFireFighter kim = new Actor("�ҹ�� �����");
		kim.outFire();
		kim.saveMan();
		
		IPoliceMan policepark = new Actor("���� �ں��˹���");
		policepark.canCatchCriminal();
		policepark.canSearch();
	}
}
