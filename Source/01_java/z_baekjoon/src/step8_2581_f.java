import java.util.*;
public class step8_2581_f{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt(); // �ּҰ�
        int N = sc.nextInt(); // �ִ밪
        int sum = 0; // ���� ��
        int min = 10001; // �ּҰ�
        
        for(int i=M; i<=N; i++){
        	boolean sw = true; // �Ҽ� �Ǵ�
            for(int j=2; j<=Math.sqrt(M); j++){
                
                if(i==1 || i%j == 0){ // �Ҽ��� �ƴ� ���
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
        if((M==1 && N==1) || sum==0) {
        	System.out.println(-1);
        }
        else {
            System.out.println(sum);
            System.out.println(min);
        }
    }
}