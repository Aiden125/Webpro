package com.lec.ex8_student;

public class StudenTestMain {
	public static void main(String[] args) {
		Student[] student = {
				new Student("정우성", 100, 90, 90),
				new Student("김하늘", 90, 90, 91),
				new Student("황정민", 81, 80, 80),
				new Student("강동원", 80, 80, 80),
				new Student("유아인", 70, 70, 70)
				};
		int[] tot = new int[5]; //tot[0] 국어누적합, tot[1] 영어누적..tot[4] 평균누적
		double[] avg = new double[5]; //avg[0] 국어평균, avg[1]]영어평균.. avg[4]평균의 평균
		System.out.println("번호\t"+"이름"+"\t"+"국어"+"\t"+"영어"+"\t"+"수학"+"\t"+"총점"+"\t"+"평균");
		for(Student s : student) {
			s.print(); // 출력 후 누적
			tot[0] += s.getKor();
			tot[1] += s.getEng();
			tot[2] += s.getMath();
			tot[3] += s.getTotal();
			tot[4] += s.getAvg(); //tot[4] = (int)(tot[4] + s.getAve());
		}
		//avg[0] = tot[0]/5
		//avg[1] = tot[1]/5 반복
		for(int idx=0 ; idx<avg.length ; idx++) {
			avg[idx] = (double)Math.round(tot[idx]/student.length);
		}
		System.out.print("총점\t\t");
		for(int t : tot) {
			//System.out.print(t + "\t");
			System.out.printf("%4d\t", t);//%4d를 입력하면 숫자 4자리만큼 띄고 자리를 오른쪽부터 순차 배정함
		}
		System.out.print("\n평균\t\t");
		for(double a : avg) {
			System.out.print(a + "\t");
		}
	}
}
