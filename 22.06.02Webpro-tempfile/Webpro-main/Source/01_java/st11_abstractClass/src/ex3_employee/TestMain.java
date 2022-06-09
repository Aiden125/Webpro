package ex3_employee;

public class TestMain {
	public static void main(String[] args) {
		Employee[] people = {
				new SalaryEmployee("������", 2400000),
				new SalaryEmployee("������", 2100000),
				new SalaryEmployee("�㰢��", 2300000),
				new HourlyEmployee("ȫ�浿", 100, 7000),
				new HourlyEmployee("�ں���", 1000, 6500)};
		for(Employee temp : people) {
			System.out.println("-----���޸���-----");
			System.out.println("���� : "+temp.getName());
			System.out.println("���� : "+temp.computePay());
			int tempIncen = temp.computeIncentive();
			if(tempIncen!=0) {
				System.out.println("�� : "+tempIncen);
			}
		}
	}
}

