package st09_ex1;

import java.util.Scanner;
/*
주차장 들어올 때 결과 : “11라1111”님 어서오세요
                       입차시간 : 12시
주차장 나갈 때 결과 : “11라1111”님 안녕히 가세요
	             * 입차시간 : 12시
		     * 출차시간 : 14시
		     * 주차요금 : 4000원
 */
public class Parking {
	//데이터
	private String no;
	private int inTime;
	private int outTime;
	private int fee;
	private final int HOURLYPARKINGRATE=2000; //상수를 위에 정의 해주는 것 final써서 고정값을 명시
	public Parking() {}
	
	//생성자 함수
	public Parking(String no, int inTime) {
		this.no = no;
		this.inTime = inTime;
		System.out.printf("\"%s\"님 어서오세요\n입차시간 : %d시\n\n", no, inTime);
	}
	//메소드
	public void out(int outTime) {
		this.outTime = outTime;
		fee = (outTime-inTime)* HOURLYPARKINGRATE;
		System.out.printf("\"%s\"님 안녕히 가세요\n입차시간 : %d시\n출차시간 : %d시\n주차요금 : %d원\n\n",no, inTime, outTime, fee);
	}

	public void out() {
		Scanner scanner = new Scanner(System.in);
		System.out.print(inTime+"시에 들어오셨는데 몇시에 출차하고 계신가요?");
		outTime = scanner.nextInt();
		out(outTime);
		scanner.close();
	}
}
