package com.lec.ex1_student;

public class StudentTestMain {
	public static void main(String[] args) {
		Student[] student = {
				new Student("���켺", 90, 90, 90),
				new Student("���ϴ�", 90, 90, 91),
				new Student("Ȳ����", 81, 80, 80),
				new Student("������", 80, 80, 80),
				new Student("������", 70, 70, 70)
				};
		int[] tot = new int[5]; //tot[0] �������, tot[1] �����..tot[4] ��մ���
		double[] avg = new double[5]; //avg[0] �������, avg[1]]�������.. avg[4]����� ���
		System.out.println("�̸�"+"\t"+"����"+"\t"+"����"+"\t"+"����"+"\t"+"����"+"\t"+"���");
		for(Student s : student) {
			s.print(); // ��� �� ����
			tot[0] += s.getKor();
			tot[1] += s.getEng();
			tot[2] += s.getMath();
			tot[3] += s.getTotal();
			tot[4] += s.getAvg(); //tot[4] = (int)(tot[4] + s.getAve());
		}
		//avg[0] = tot[0]/5
		//avg[1] = tot[1]/5 �ݺ�
		for(int idx=0 ; idx<avg.length ; idx++) {
			avg[idx] = (double)tot[idx]/student.length;
		}
		System.out.print("����\t");
		for(int t : tot) {
			System.out.print(t + "\t");
		}
		System.out.print("\n���\t");
		for(double a : avg) {
			System.out.print(a + "\t");
		}
	}
}
