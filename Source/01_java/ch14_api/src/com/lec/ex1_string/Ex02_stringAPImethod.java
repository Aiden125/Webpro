package com.lec.ex1_string;

public class Ex02_stringAPImethod {
	public static void main(String[] args) {
		String str1 = "abcXabc";
		String str2 = new String("ABCXabc");
		String str3 = "                       ja  va         ";
		System.out.println("1¹ø °ª "+str1.concat(str2)); // ¹®ÀÚ¿­°áÇÕ ÇÔ¼ö¸¦ ´õÇÏ´Â °Í abcXabcABCXabc
		System.out.println("2¹ø °ª "+str1.substring(3)); // 3¹øÂ°ºÎÅÍ ³¡±îÁö Xabc
		System.out.println("3¹ø °ª "+str1.substring(3,5)); // 3¹øÂ°ºÎÅÍ 5¹øÂ°¾Õ±îÁöXa
		System.out.println("4¹ø °ª "+str1.length()); //±ÛÀÚ±æÀÌ7
		System.out.println("5¹ø °ª "+str1.toUpperCase()); //´ë¹®ÀÚ·Î ABCXABC
		System.out.println("6¹ø °ª "+str1.toLowerCase()); //¼Ò¹®ÀÚ·Î abcxabc
		System.out.println("7¹ø °ª "+str1.charAt(3)); //3¹øÂ° ¹®ÀÚ¸¦ ¹İÈ¯ 'X'
		System.out.println("8¹ø °ª "+str1.indexOf('b')); //Ã¹¹øÂ° b¹®ÀÚ°¡ ³ª¿À´Â À§Ä¡ÀÇ ÀÎµ¦½º
		System.out.println("9¹ø °ª "+str1.indexOf('b', 3)); //3¹øÂ°ºÎÅÍ °Ë»öÇØ¼­ Ã¹¹øÂ°'b'À§Ä¡ ÀÎµ¦½º 5 (ÀÎµ¦½º´Â Ã³À½ºÎÅÍ½ÃÀÛ)
		System.out.println("10¹ø °ª "+str1.indexOf("abc")); //Ã¹¹øÂ° "abc" ³ª¿À´Â À§Ä¡ ÀÎµ¦½º 0
		System.out.println("11¹ø °ª "+str1.indexOf("abc", 3)); //3¹øÂ°ºÎÅÍ °Ë»öÇØ¼­ Ã¹¹øÂ° "abc" ³ª¿À´Â À§Ä¡ÀÎµ¦½º 4(ÀÎµ¦½º´Â Ã³À½ºÎÅÍ½ÃÀÛ)
		System.out.println("12¹ø °ª "+str1.indexOf('z')); //¾øÀ¸¸é -1
		System.out.println("13¹ø °ª "+str1.lastIndexOf('b')); //¸¶Áö¸·'b'À§Ä¡ ¹İÈ¯
		System.out.println("14¹ø °ª "+str1.lastIndexOf('b',3)); //3¹øÂ°ºÎÅÍ ¸Ç ¸¶Áö¸· b
		
		System.out.println("15¹ø : "+str1.equals(str2)); //str1°ú str2°¡ °°Àº ¹®ÀÚ¿­ÀÎÁö false
		System.out.println("16¹ø : "+str1.equalsIgnoreCase(str2)); //´ë¼Ò¹®ÀÚ ±¸ºĞ¾øÀÌ ºñ±³ true
		System.out.println("17¹ø : "+str3.trim()); //¾ÕµÚ °ø¹éÁ¦°Å. Áß°£°ø¹éÀº Á¦°Åx
		System.out.println("18¹ø : "+str1.replace('a', '9')); //'a'¸¦ '9'·Î ¼öÁ¤ 9bcX9bc
		System.out.println("19¹ø : "+str1.replace("abc", "¤±¤±¤±")); //"abc"À» "¤±¤±¤±"·Î ¼öÁ¤
		System.out.println("20¹ø : "+str3.replace(" ", "")); // °ø¹éÀ» ¾ø¾Ù ¶§
		System.out.println("21¹ø : "+str1.replaceAll("abc", "ZZZ")); // "abc"¸¦ "ZZZ"·Î
		
		//Á¤±ÔÇ¥Çö½Ä https://goo.gl/Hlntbd
		//Á¤±ÔÇ¥Çö½Ä ¿¬½ÀÀå https://www.nextree.co.kr/p4327
		String str = "¾È³çHello";
		System.out.println(str.replaceAll("[a-zA-Z]", ""));//¾ËÆÄºªÀ» ""·Î ¼öÁ¤
		System.out.println(str.replaceAll("[°¡-ÆR]", ""));//ÇÑ±Û¹®ÀÚ¸¦ ""·Î ¼öÁ¤
		//¹®ÀÚ¿­ ¸Ş¼Òµå´Â ¹®ÀÚ¿­À» ¼öÁ¤ ¾ÈÇÔ
		System.out.println("stsr1 = "+str1);
		System.out.println("stsr2 = "+str2);
		System.out.println("stsr3 = "+str3);
	}
}
