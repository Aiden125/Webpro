package st3_set;
//ex3���ϰ� ����
public class Student {
	private int grade;
	private String name;

	public Student(int grade, String name) {
		this.grade = grade;
		this.name = name;
	}

	@Override
	public String toString() {
		return grade + "�г� " + name;
	}
	// equals �� hashcode override
	// ���� ���� ������ ���ٰ� ���̰� ����� �ַ���
	@Override
	public boolean equals(Object obj) {
		if(obj!=null && obj instanceof Student) {
//			boolean gradeChk = grade == ((Student)obj).grade;
//			boolean nameChk = name.equals(((Student)obj).name);
//			return gradeChk && nameChk;
			//�� ���ٰ� �Ʒ� ������ ����
			return toString().equals(obj.toString());
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		return toString().hashCode();
	}

}