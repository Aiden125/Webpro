import java.util.*;
public class step8_2581_f{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt(); // 최소값
        int N = sc.nextInt(); // 최대값
        int sum = 0; // 누적 값
        int min = 10001; // 최소값
        
        for(int i=M; i<=N; i++){
        	boolean sw = true; // 소수 판단
            for(int j=2; j<=Math.sqrt(M); j++){
                
                if(i==1 || i%j == 0){ // 소수가 아닌 경우
                    sw = false;
                    break;
                }
            }
            if(sw){ // 소수인 경우
                sum += i;
                if(i<min){
                    min = i;
                }
            }
            
        }
        if((M==1 && N==1) || sum==0) {
        	System.out.println(-1);
        }
        else {
            System.out.println(sum);
            System.out.println(min);
        }
    }
}