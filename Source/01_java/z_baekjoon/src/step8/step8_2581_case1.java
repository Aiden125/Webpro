package step8;
import java.util.*;
public class step8_2581_case1{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt(); // �ּҰ�
        int N = sc.nextInt(); // �ִ밪
        int sum = 0; // ���� ��
        int min = 10001; // �ּҰ�
        
        for(int i=M; i<=N; i++){
        	boolean sw = true; // �Ҽ� �Ǵ�
        	if(i==1) {
        		sw = false;
        	}
            for(int j=2; j<i; j++){
                
                if(i%j == 0){ // �Ҽ��� �ƴ� ���
                    sw = false;
                    break;
                }
            }
            if(sw){ // �Ҽ��� ���
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