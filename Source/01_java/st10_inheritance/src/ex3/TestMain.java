package ex3;

public class TestMain {
	public static void main(String[] args) {
		ParentClass pObj1 = new ParentClass();
		//�Ű� ���� parent������
		ParentClass pObj2 = new ParentClass(1);
		//�Ű����� �ִ� parent������
		if(pObj1.equals(pObj2)) {
			System.out.println("�� ��ü�� ����.");
		}else {
			System.out.println("�� ��ü�� �ٸ���.");
		}
		//�� ��ü�� �ٸ���
		ChildClass cObj = new ChildClass(2);
		//�Ű����� ���� parent ������
		//�Ű����� �ִ� ���ϵ�Ŭ���� ������
		if(cObj.equals(pObj2)) {
			System.out.println("������ true��");
		}
		//����oo
		pObj1.method1();
		//parent method1
		pObj1.method2();
		//parent method2
		System.out.println("�ѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤ�");
		cObj.method1(); // ChildClass�� method1
		cObj.method2(); // ParentClass�� method2
		cObj.method3(); // ChildClass�� method3
		ParentClass cObj1 = new ChildClass(2);
		//�Ű����� ���� parent ������
		//�Ű����� �ִ� Child ������
		cObj1.method1(); // ChildClass�� method1
		cObj1.method2(); // ParentClass�� method2
		//ParentClass�� cObj1������ ChildClass������ ��ȯ ����? )
		if(cObj1 instanceof ChildClass) {
			((ChildClass)cObj1).method3();	
		}else {
			System.out.println("�� ��ȯ �ȵ�");
		}
	}//main
}//class
