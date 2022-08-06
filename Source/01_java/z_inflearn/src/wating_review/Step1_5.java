package wating_review;
import java.util.Scanner;
  
public class Step1_5 {
  public String solution(String str){
    String answer;
    char[] s = str.toCharArray();
    int lt=0;
    int rt=str.length()-1;
    
    while(lt<rt){
      if(Character.isAlphabetic(s[lt])){ // lt°¡ ¾ËÆÄºª
        if(Character.isAlphabetic(s[rt])){ // rtµµ ¾ËÆÄºª
          char temp = s[lt];
          s[lt] = s[rt];
          s[rt] = temp;
          lt++;
          rt--;
        }else {
        	rt--;
        }
      }else {
    	  lt++;
      }
    }
    answer=String.valueOf(s);
    return answer;
  }
  
  public static void main(String[] args){
	Step1_5 T = new Step1_5();
    Scanner sc = new Scanner(System.in);
    String str = sc.next();
    System.out.println(T.solution(str));
  }
}