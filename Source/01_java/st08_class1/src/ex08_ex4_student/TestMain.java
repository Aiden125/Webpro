package ex08_ex4_student;
//�̸�, ����, ����, ����, ����, ��� ������ ����ϴ� ���α׷� �ۼ�.

/*�̸�	����	����	����	����	���
���켺	90	90	90	270	90.0
���ϴ�	90	90	91	271	90.3
Ȳ����	81	80	80	241	80.3
������	80	80	80	240	80.0
������	70	70	70	210	70.0
����	411	410	411	1232	410	
���	82.2	82.0	82.2	246.4	82.0*/
public class TestMain {
	public static void main(String[] args) {
		System.out.printf("�̸�\t����\t����\t����\t����\t���");
		Student[] st = new Student[5];
		st[0] = new Student("���켺", 90, 90,90);
		st[1] = new Student("��켺", 20, 55,60);
		st[2] = new Student("����ġ", 30, 40,70);
		st[3] = new Student("����ġ", 90, 60,80);
		st[4] = new Student("�ֱ浿", 99, 22,70);
		int[] tot = new int[5]; // tot[0]���� ������, tot[1] ������� ���
		double[] avg = new double[5]; // avg[0] ���� ���, avg[2]������� ���
		for(Student s : st){
			s.print();
			tot[0] += s.getKor();
			tot[1] += s.getEng();
			tot[2] += s.getMath();
			tot[3] += s.getTotal();
			tot[4] += s.getAvg();
		}
		for(int idx=0 ; idx<avg.length ; idx++) {
			avg[idx] = (double)tot[idx]/st.length;
		}
		System.out.print("\n����\t");
		for(int t : tot) {
			System.out.print(t+"\t");
		}
		System.out.print("\n���\t");
		for(double a : avg) {
			System.out.print(a+"\t");
		}
		
		
		
	}
}
