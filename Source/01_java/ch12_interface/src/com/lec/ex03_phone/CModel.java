package com.lec.ex03_phone;
// c제품 : DMB송수신 불가, LTE, TV리모콘 미탑재
public class CModel implements IAcorporation {
	private String modelName;
	public CModel() {
		modelName = "C모델";
	}
	@Override
	public void dmbReceive() {
		System.out.println(modelName + "은 DMB 송신 불가");
	}
	@Override
	public void lte() {
		System.out.println(modelName + "은 LTE");
	}
	@Override
	public void tvRemoteControl() {
		System.out.println(modelName + "은 TV리모콘 미탑재");
	}

}
