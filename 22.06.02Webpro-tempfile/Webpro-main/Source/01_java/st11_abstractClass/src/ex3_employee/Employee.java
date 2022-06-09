package ex3_employee;

public abstract class Employee {
	private String name;

	public Employee(String name) {
		this.name = name;
	}

	public abstract int computePay();

	public final int computeIncentive() {
		int result = computePay();
		if (result >= 2000000) {
			result = (int) (result * 0.1);
		}
		return result;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
