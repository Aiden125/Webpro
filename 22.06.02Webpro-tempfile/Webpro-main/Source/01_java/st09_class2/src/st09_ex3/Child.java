package st09_ex3;

public class Child {
	private String name;
	static MomPouch mompouch; //공유변수
	
	public Child(String name) {
		this.name = name;
		mompouch = new MomPouch();
	}
	
	public void takemoney(int take) {
		if(mompouch.money >= take) {
			mompouch.money -= take;
			System.out.println(name+"이(가)"+take+"원을 가져가서 지갑에"+mompouch.money+"원이 남았다.");
		}else {
			System.out.println("용돈이 부족하다");
		}
	}
	
	
	
}
