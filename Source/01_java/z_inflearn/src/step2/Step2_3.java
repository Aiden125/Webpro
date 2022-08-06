package step2;
import java.util.Scanner;
// tip: each public class is put in its own file
public class Step2_3 {
    public String solution(int n, int[] a, int[] b){
        String answer = "";
        for(int i=0; i<n; i++){
            if(a[i]==b[i]){
                answer += "D";
            }else{
                if((a[i]==1 && b[i]==2) || (a[i]==2 && b[i]==3) || (a[i]==3 && b[i]==1)){ // b가 이긴 경우
                    answer += "B";
                }else{
                    answer += "A";
                }
            }
        }
        return answer;
    }
    
    // tip: arguments are passed via the field below this editor
    public static void main(String[] args) {
    	Step2_3 T = new Step2_3();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        
        for(int i=0; i<n; i++){
            a[i] = sc.nextInt();
        }
        for(int i=0; i<n; i++){
            b[i] = sc.nextInt();
        }
        for(char x : T.solution(n, a, b).toCharArray()){
            System.out.println(x);
        }
    }
}