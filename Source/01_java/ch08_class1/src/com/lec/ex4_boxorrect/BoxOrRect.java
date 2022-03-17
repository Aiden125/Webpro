package com.lec.ex4_boxorrect;
/*
������ü�� ����, ����, ����, ���ǳ� ���簢���� ����, ����, ���̸� �Ӽ����� ���� Ŭ������ �����϶�.
 ���ǳ� ���̸� �����ϴ� �޼ҵ� getVolume(), ����ϴ� �޼ҵ� vPrint()�� �����Ѵ�.
������ : ����, ����, ����, volume(����or����)
�޼ҵ� : int getVolume(), void vPrint()
1. ������ ����(private)
2. ����Ʈ ������ public className(){}
3. ���� ���ϴ� ���� ������(2�� ¥�� ���� ������, 3�� ¥�� ���)
4. �޼ҵ�(���� ���ϴ�)
*/
public class BoxOrRect {
	//������ �ι�
	private int width;
	private int height;
	private int depth; // box�� ��� ����, rect�� ���� 0
	private int volume; // box�� ��� ����, rect�� ��� ����
	//������ �ι�
	
	// ����Ʈ ������(���콺 ��Ŭ�� �� �ҽ� ���ʷ���Ʈ form superclass)
	public BoxOrRect() {} 
	
	//���� 2��¥�� ������
	//�����ϰ� ���콺 ��Ŭ�� �� from Using Field ����
	public BoxOrRect(int width, int height) {
		this.width = width;
		this.height = height;
		volume = width*height;
	}
	//���� 3��¥�� ������
	public BoxOrRect(int width, int height, int depth) {
	
		this.width = width;
		this.height = height;
		this.depth = depth;
		volume = width*height*depth;
	}
	//�޼ҵ� : volume �� ��ȯ ��Ű��
	public int getVolume() {
		return volume;
	}
	//�޼ҵ� : ���� Ȥ�� ���� �� ����Ʈ ���ִ�
	public void vPrint() {
		if(depth!=0) {
			System.out.println("���Ǵ�"+volume);
		}else {
			System.out.println("���̴�"+volume);
		}

	}
}
