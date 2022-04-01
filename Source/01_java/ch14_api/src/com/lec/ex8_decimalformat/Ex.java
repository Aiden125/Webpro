package com.lec.ex8_decimalformat;

import java.text.DecimalFormat;

public class Ex {
	public static void main(String[] args) {
		double num = 1234567.89;
		DecimalFormat df0 = new DecimalFormat("00000000"); //0이 8개 만약 8자리가 아니라면 앞에는 0을 붙여 채워줌
		System.out.println(df0.format(num));
		DecimalFormat df1 = new DecimalFormat("########"); //#8자리 : 숫자가 부족해도 그냥 그대로 뽑아줌
		System.out.println(df1.format(num));
		DecimalFormat df2 = new DecimalFormat("0,000.000"); //3자리마다 콤마. 소수점 3자리 출력
		System.out.println(df2.format(num)); //만약 소수점이 지정한 곳을 넘어가게 된다면 그 뒷자리에서 반올림해서 계산해줌
		DecimalFormat df3 = new DecimalFormat("#,###.##%"); //%도 계산되기 때문에 내가 출력하려던거에서 *100해서 출력해줌
		System.out.println(df3.format(num));
		num = 123000000000000L; //1.23E14 이런 형식으로 컴퓨터는 계산함
		DecimalFormat df4 = new DecimalFormat("#.##E00");
		System.out.println(df4.format(num));
	}
}
