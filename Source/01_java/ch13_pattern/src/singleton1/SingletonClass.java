package singleton1;

public class SingletonClass {//�̱����̴��ϸ� ������, ���ͼ���, ������(�����̺�) ����°� �ٷ� �����ϱ�, Ŭ������ Ÿ���� ����ƽ instance�����, if �� ���ϰ�
	private int i;
	
	//��ü���� ������ �� ��ü �ּҸ� return�ϰ�
	//��ü���� �� ������ ��ü �����ϰ� �� �ּҸ� return.
	private static SingletonClass INSTANCE; //�⺻������ null���� �ʱ�ȭ
	public static SingletonClass getInstance() {
		if(INSTANCE==null) {
			INSTANCE = new SingletonClass();
		}
		return INSTANCE;	
		}
	private SingletonClass() {}//singleton������ private�� �Ű����� ���� ������ ����

	public int getI() {
		return i;
	}

	public void setI(int i) {
		this.i = i;
	}
	
}
