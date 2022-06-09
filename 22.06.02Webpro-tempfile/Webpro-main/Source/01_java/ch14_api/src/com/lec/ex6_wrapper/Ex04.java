package com.lec.ex6_wrapper;

import java.util.Scanner;

//»ç¿ëÀÚ·ÎºÎÅÍ ½ºÆ®¸µÀ» ÀÔ·Â¹Ş¾Æ Á¤¼ö·Î º¯È¯
public class Ex04 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("¹®ÀÚ¸¦ ÀÔ·ÂÇÏ¼¼¿ä");
		String numStr = sc.nextLine();
		numStr = numStr.trim(); //ÁÂ¿ì space Á¦°Å
		numStr = numStr.replaceAll("[a-zA-Z°¡-ÆR¤¡-¤¾]", ""); //¹®ÀÚ Á¦°Å. Áï, ¼ıÀÚ¸¸ ³²°ÔÇÏ±â
		// numStr = numStr.replaceAll("\\D", ""); //¹®ÀÚ Á¦°Å. Áï, ¼ıÀÚ¸¸ ³²°ÔÇÏ±â
		int num = Integer.parseInt(numStr); // ½ºÆ®¸µÀ» Á¤¼ö·Î ¹Ù²Ù´Â ÇÔ¼ö Inegre.parseInt(¹®ÀÚ¿­)
		System.out.println("º¯ÇüµÈ Á¤¼ö´Â : "+num);
		sc.close();
	}
}
