package st08_ex4_student;
//이름, 국어, 영어, 수학, 총합, 평균 점수를 출력하는 프로그램 작성.

/*이름	국어	영어	수학	총점	평균
정우성	90	90	90	270	90.0
김하늘	90	90	91	271	90.3
황정민	81	80	80	241	80.3
강동원	80	80	80	240	80.0
유아인	70	70	70	210	70.0
총점	411	410	411	1232	410	
평균	82.2	82.0	82.2	246.4	82.0*/
public class Student {
	private String name;
	private int kor;
	private int eng;
	private int math;
	private int total;
	private double avg;
	
	public Student(String name, int kor, int eng, int math) {
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
		total = kor+eng+math;
		avg = (double)(total/3);
	}
	public void print() {
		System.out.printf("\n%s\t%d\t%d\t%d\t%d\t%.1f", name, kor, eng, math, total, avg);

	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getKor() {
		return kor;
	}
	public void setKor(int kor) {
		this.kor = kor;
	}
	public int getEng() {
		return eng;
	}
	public void setEng(int eng) {
		this.eng = eng;
	}
	public int getMath() {
		return math;
	}
	public void setMath(int math) {
		this.math = math;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public double getAvg() {
		return avg;
	}
	public void setAvg(double avg) {
		this.avg = avg;
	}
	
	
}
