package com.lec.ex4_object;

public class Person {
	private long juminNo; //9512051012121

	public Person(long juminNo) {
		this.juminNo = juminNo;
	}

	@Override
	public String toString() {
		return "Person [juminNo=" + juminNo + "]";
	}
	@Override
	public boolean equals(Object obj) {
		//p1.equals(p2)호출 할 경우 p1대신 this, p2대신 obj => 내 객체의 juminNo와 obj.juminNo가 같은지 여부를 return
		//p1.equals(p3)호출 할 경우 p3대신 obj => false를 return
		if(obj != null && obj instanceof Person) {//instanceof -> 앞 개체와 뒤 개체의 형식이 같니? 물어봐서 true or false return
			return juminNo == ((Person)obj).juminNo;
		}else {
			return false;
		}
	}
}
