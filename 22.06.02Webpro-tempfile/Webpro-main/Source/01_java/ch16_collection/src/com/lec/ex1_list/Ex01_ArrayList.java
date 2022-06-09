package com.lec.ex1_list;

import java.util.ArrayList;

public class Ex01_ArrayList {
	public static void main(String[] args) {
		String[] arr = new String[5];
		arr[0] = "str0";
		arr[1] = "str1";
		arr[4] = "str400";
		for(int i=0 ; i<arr.length ; i++) {
			System.out.println(arr[i]);
		}
		System.out.println("�ѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤ�");
		for(String a : arr) {
			System.out.println(a);
		}
		System.out.println("�ѤѤѤѤ�ArrayList�ѤѤѤѤ�");
		ArrayList<String> arrList = new ArrayList<String>();
		//�ݵ�� ��ü������(����Ŭ���� �ּҰ����·�) ���� ��. int, double �� �������� ���� ���� ���� �ȵ�(���ʵ�����Ÿ���� x)
		//ArrayList<Integer> list = new ArrayList<Integer>();
		arrList.add("str0"); //0�� �ε���
		arrList.add("str1"); //1�� �ε���
		arrList.add("str2"); //2�� �ε���
		arrList.add(1, "str111111"); //1�� �ε����� �ٽ� �ְԵǸ� 1���ε��� �ڸ��� �갡 �����ϰ� ���� �о. ������ 1���� 2������, ����2���� 3������
		System.out.println(arrList);
		arrList.set(1, "111"); //1�� �ε����� ����
		System.out.println(arrList);
		for(String alist : arrList) {
			System.out.print(alist + "\t");
		}
		System.out.println("\n - remove�� �Ŀ� -");
		arrList.remove(1); //1��° �ε����� ������ ���� (2��->1��, 3��->2������ ����)
		// arrList.remove("11111"); //�̷��� Ư�� �ε��� �Ӹ��� �ƴ�, Ư�� ������ ������ ���� �ߺ��� �������� ��� �տ����� ������
		arrList.remove(arrList.size()-1); //�� ������ �ε��� ������ ����
		System.out.println(arrList);
		for(int idx=0 ; idx<arrList.size(); idx++) {
			System.out.printf("%d��° �ε��� ���� %s\t", idx, arrList.get(idx));
		}
		System.out.println(); //����
		arrList.clear(); //�ȿ� �ִ� �����͸� ������ ����� 0���� ������� (�����͸� ���°�!!)
		if(arrList.size() == 0) {//arrList�� �����Ͱ� 0�̳�? ��, ����?
			System.out.println("arrList�� �����ʹ� �����ϴ�");
		}
		if(arrList.isEmpty()) {//�����Ͱ� �����? ��� ���°�. �����Ͱ� ���� ���
			System.out.println("arrList�� �����ʹ� �����ϴ�.");
		}
		System.out.println(arrList);
		arrList = null; //arrList ��ü ��ü�� ����(�����͸��� �ƴ�)
		System.out.println(arrList.size());
	}
}
