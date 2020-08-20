package d_company_real.huawei;
import java.util.Scanner;

/**
 * @program: swordofferjava
 * @description: 华为真题
 * @author: Jin Hongjian
 * @create: 2020-08-18
 **/

public class HighestScore{
    public static void main(String[] args){
        Scanner sc  = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] scores = new int[N + 1]; //索引表示学生id
        for(int i = 1; i <= N; i++ ){
            scores[i] = sc.nextInt();
        }
        for(int i = 1; i <= M; i++ ){
            char c = sc.next().charAt(0);
            int left = sc.nextInt();
            int right = sc.nextInt();
            if(left > right){
                int temp = left;
                left  = right;
                right = temp;
            }
            if(c == 'Q'){
                int max = 0;
                while(left <= right){
                    if(scores[left] > max){
                        max = scores[left];
                    }
                    left++;
                }
                System.out.println(max);
            }
            if(c == 'U'){
                scores[left] = right;
            }
        }
    }
}
