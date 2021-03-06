package st09_ex5;

public class Student {
	private String name;
	private int kor;
	private int eng;
	private int math;
	private int total;
	private double avg;
	private int stNo;
	
	public static int count = 1;
	public Student() {}

	public Student(String name, int kor, int eng, int math) {
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
		stNo = count++;
		total = kor+eng+math;
		avg = total/3.0;
	}
	public void print() {
		System.out.printf("%d\t%s\t%d\t%d\t%d\t%d\t%.1f\n", stNo, name, kor, eng, math, total, avg);
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

	public int getStNo() {
		return stNo;
	}

	public void setStNo(int stNo) {
		this.stNo = stNo;
	}

	public static int getCount() {
		return count;
	}

	public static void setCount(int count) {
		Student.count = count;
	}
	
}
