package com.lec.ex3_set;
// Student ���ϰ� �Բ������ϴ� ����.
import java.util.HashSet;
// HashSet�� ���µ�, new�� �����ϴ��� ��ü���� ���ٸ�
// �Ȱ��� ����ϵ��� �ϴ¹��. equals + hashCode + toString �������̵� �������
public class Ex03_StudentHashSet {
	public static void main(String[] args) {
		HashSet<Student> students = new HashSet<Student>();
		//�Ʒ��� ���ٰ�
		Student s = new Student(6, "�̼���");
		students.add(s);
		students.add(s); //�̷��� ������ ���� ��������� �ʱ⿡ ������
		//�ٷ� �Ʒ� ������ ���� ���������� �ణ �ٸ�.(�ؿ����� ������ ���� �߰��� ���ְ� ������ó�� �ϸ� ������ �Ȱ����� ���� ��ü�� �ν��ع���)
		students.add(new Student(3, "ȫ�浿"));
		//���� �����ε� �� �ְ� �ʹٸ� �̷��� �� �־����
		//������ ���� ���� �ɷ� �νĽ�Ű�� �ʹٸ� ������ �� �ؽ��ڵ� �������̵� �ؾ��� -> Student ��ü ������ ��
		students.add(new Student(3, "ȫ�浿"));
		students.add(new Student(6, "�̼���"));
		System.out.println(students);
	}
}
