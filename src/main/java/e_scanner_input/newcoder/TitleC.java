package e_scanner_input.newcoder;

import java.util.Scanner;

/**
 * @program: swordofferjava
 * @description:
 * @author: Jin Hongjian
 * @create: 2020-07-30
 * 链接：https://ac.nowcoder.com/acm/contest/5647/C
 * 来源：牛客网
 *
 * 计算a+b
 *
 * 输入描述:
 * 输入包括两个正整数a,b(1 <= a, b <= 10^9),输入数据有多组, 如果输入为0 0则结束输入
 * 输出描述:
 * 输出a+b的结果
 * 示例1
 * 输入
 * 复制
 * 1 5
 * 10 20
 * 0 0
 * 输出
 * 复制
 * 6
 * 30
 **/
public class TitleC {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        while(sc.hasNextLine()){
            int a = sc.nextInt();
            int b = sc.nextInt();
            if(a == 0 && b == 0){
                break;
            }
            System.out.println(a+b);
            sc.nextLine();
        }

    }
}
