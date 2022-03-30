package ex3_employee;

public class SalaryEmployee extends Employee {
	private int annalSalary;
	
	public SalaryEmployee(String name, int annalSalary) {
		super(name);
		this.annalSalary = annalSalary;
	}

	@Override
	public int computePay() {
		int result = annalSalary/14;
		return result;
	}

}
