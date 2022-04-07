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
		return "이 름 : " + name + "\n주소 : " + address + "\n핸드폰 : " + phone + "\n생 일 : " + birthday + "\n";
	}

	public String getAddress() {
		return address;
	}

}
