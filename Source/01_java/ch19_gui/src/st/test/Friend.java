package st.test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

public class Friend {
	private String name;
	private String address;
	private String phone;
	private String birthday;

	public Friend(String name, String address, String phone, String birthday) {
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.birthday = birthday;
	}

	@Override
	public String toString() {
		return "�� �� : " + name + "\n�ּ� : " + address + "\n�ڵ��� : " + phone + "\n�� �� : " + birthday + "\n";
	}

	public String getAddress() {
		return address;
	}

}
