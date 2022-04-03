package st1_api;

import java.util.Scanner;

public class Ex2_regex {
	public static void main(String[] args) {
		String str = "010-2222-2222 moan125@naver.com (02)111-2222 ¹İ°©½À´Ï´Ù. Hello 92122-1213121";
		
		// System.out.println("replace =>" + str.replace("0", "È«")); //0¸¸ È«À¸·Î ¹Ù²ñ,
		// ´Ü¼ø replace¸¦ ¾µ ¶§´Â ÀüÈ­¹øÈ£¸¦ ¾ø¾Ö¹ö·Á¶ó, ÇÑ±ÛÀ» ¾ø¾î¹ö·Á¶ó ÀÌ·±½ÄÀ¸·Î ¾²Áú ¸øÇÔ.
		// Á¤±ÔÇ¥Çö½Ä °£·« ¹®¹ı
		// 2.
		// \d(¸ğµç¼ıÀÚ) \D(¼ıÀÚ Á¦¿ÜÇÑ ¸ğµç °Í) \s(whitespace ÅÇ, ¿£ÅÍ, ½ºÆäÀÌ½º)
		// \w(¿µ¹®ÀÚ³ª ¼ıÀÚ) \W(¿µ¹®ÀÚ³ª ¼ıÀÚ°¡ ¾Æ´Ñ ¹®ÀÚ) .(¹®ÀÚÇÏ³ª)
		// +(1¹øÀÌ»ó)   *(0¹øÀÌ»ó)   ?(0~1¹ø ¹İº¹)   {2,4}(2~4È¸ ¹İº¹)
		// 3.
		// ¿¬½ÀÀå  ¨Íhttps://regexr.com/   ¨Îhttps://www.regexpal.com/
		// ex. ÀüÈ­¹øÈ£ : [(]?([0-9]){2,3}\D[0-9]{3,4}-[0-9]{4}
		//	       ÀÌ¸ŞÀÏ : \w+@\w+(.\w+){1,2} ¹®ÀÚ³ª ¼ıÀÚ¸¦ 1¹øÀÌ»ó ¹İº¹+@¹®ÀÚ³ª ¼ıÀÚ¿­À» 1¹øÀÌ³ª µÎ¹ø ¹İº¹
		// 4. Æ¯Á¤ Á¤±ÔÇ¥Çö½ÄÀÇ ¹®Àå¿­ º¯°æ : replaceAll("Á¤±ÔÇ¥Çö½Ä", "´ëÃ¼¹®ÀÚ¿­")
		
		//System.out.println(str.replaceAll("[0-9]",  "x")); // ¼ıÀÚ¸¦ x·Î ¹Ù²ã¶ó
		// System.out.println(str.replaceAll("\\d",  "x")); // ¿ª½½·¡½Ã¸¦ Ç¥ÇöÇÏ·Á¸é µÎ°³½á¾ßÇÔ ¼ıÀÚ¸¦ x·Î ¹Ù²ã¶ó
		//System.out.println(str.replaceAll("\\D",  "x")); // ¼ıÀÚ°¡ ¾Æ´Ñ°Í(½ºÆäÀÌ½ºµµ Æ÷ÇÔÇØ ¾ø¾Ö¹ö¸²)
		
		//ÀüÈ­¹øÈ£ Áö¿ì´Â ¹æ¹ı
		System.out.println(str.replaceAll("[(]?([0-9]){2,3}\\D[0-9]{3,4}-[0-9]{4}", "**ÀüÈ­¹øÈ£ Áö¿ò**"));
		//ÀÌ¸ŞÀÏ Áö¿ì´Â ¹æ¹ı
		System.out.println(str.replaceAll("\\w+@\\w+(.\\w+){1,2}", "**ÀÌ¸ŞÀÏ Áö¿ò**"));
		//¾ËÆÄºª ´ë½Å *·Î ´ëÃ¼
		System.out.println(str.replaceAll("[a-zA-Z]", "*"));
		//ÇÑ±Û ½Ï ´Ù ¾ø¾Ö
		System.out.println(str.replaceAll("[°¡-ÆR¤¡-¤¾]", "ÇÑ±Û"));
		//ÁÖ¹Î¹øÈ£ µŞÀÚ¸®¸¦ *·Î ´ëÃ¼
		System.out.println(str.replaceAll("[0-9]{7}", "*******")); //[0-9]{7} ¼ıÀÚ¸¦ 7¹ø ¹İº¹ÇÏ´Â °÷ÀÌ¶ó´Â ÀÇ¹Ì
		
		
		
		

	}
}
