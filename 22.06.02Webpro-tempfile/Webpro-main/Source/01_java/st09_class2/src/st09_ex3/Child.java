package st09_ex3;

public class Child {
	private String name;
	static MomPouch mompouch; //��������
	
	public Child(String name) {
		this.name = name;
		mompouch = new MomPouch();
	}
	
	public void takemoney(int take) {
		if(mompouch.money >= take) {
			mompouch.money -= take;
			System.out.println(name+"��(��)"+take+"���� �������� ������"+mompouch.money+"���� ���Ҵ�.");
		}else {
			System.out.println("�뵷�� �����ϴ�");
		}
	}
	
	
	
}
