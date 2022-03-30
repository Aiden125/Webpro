package ex3_employee;

public class TestMain {
	public static void main(String[] args) {
		Employee[] people = {
				new SalaryEmployee("아이유", 2400000),
				new SalaryEmployee("정은지", 2100000),
				new SalaryEmployee("허각각", 2300000),
				new HourlyEmployee("홍길동", 100, 7000),
				new HourlyEmployee("박보검", 1000, 6500)};
		for(Employee temp : people) {
			System.out.println("-----월급명세서-----");
			System.out.println("성함 : "+temp.getName());
			System.out.println("월급 : "+temp.computePay());
			int tempIncen = temp.computeIncentive();
			if(tempIncen!=0) {
				System.out.println("상여 : "+tempIncen);
			}
		}
	}
}

