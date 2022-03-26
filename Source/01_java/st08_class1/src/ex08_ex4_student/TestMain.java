package ex08_ex4_student;
//이름, 국어, 영어, 수학, 총합, 평균 점수를 출력하는 프로그램 작성.

/*이름	국어	영어	수학	총점	평균
정우성	90	90	90	270	90.0
김하늘	90	90	91	271	90.3
황정민	81	80	80	241	80.3
강동원	80	80	80	240	80.0
유아인	70	70	70	210	70.0
총점	411	410	411	1232	410	
평균	82.2	82.0	82.2	246.4	82.0*/
public class TestMain {
	public static void main(String[] args) {
		System.out.printf("이름\t국어\t영어\t수학\t총점\t평균");
		Student[] st = new Student[5];
		st[0] = new Student("정우성", 90, 90,90);
		st[1] = new Student("김우성", 20, 55,60);
		st[2] = new Student("박코치", 30, 40,70);
		st[3] = new Student("남코치", 90, 60,80);
		st[4] = new Student("최길동", 99, 22,70);
		int[] tot = new int[5]; // tot[0]국어 누적합, tot[1] 영어누적합 등등
		double[] avg = new double[5]; // avg[0] 국어 평균, avg[2]영어평균 등등
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
		System.out.print("\n총점\t");
		for(int t : tot) {
			System.out.print(t+"\t");
		}
		System.out.print("\n평균\t");
		for(double a : avg) {
			System.out.print(a+"\t");
		}
		
		
		
	}
}
