import java.util.*;
public class step8_2581{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt(); // 최소값
        int N = sc.nextInt(); // 최대값
        int sum = 0; // 누적 값
        int min = 10001; // 최소값
        boolean sw = true; // 소수 판단
        
        for(int i=M; i<=N; i++){
            for(int j=2; j<M; j++){
                
                if(i%j == 0){ // 소수가 아닌 경우
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
        if(sum==0) {
        	System.out.println(-1);
        }
        else {
            System.out.println(sum);
            System.out.println(min);
        }
    }
}