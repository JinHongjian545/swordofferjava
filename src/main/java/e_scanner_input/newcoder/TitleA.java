package e_scanner_input.newcoder;

import java.util.Scanner;

/**
 * @program: swordofferjava
 * @description:
 * @author: Jin Hongjian
 * @create: 2020-07-30

链接：https://ac.nowcoder.com/acm/contest/5647/A
来源：牛客网

计算a+b

输入描述:
输入包括两个正整数a,b(1 <= a, b <= 10^9),输入数据包括多组。
输出描述:
输出a+b的结果
示例1
输入
复制
1 5
10 20
输出
复制
6
30


 **/
public class TitleA {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        while(sc.hasNextLine()){
            int a = sc.nextInt();
            int b = sc.nextInt();
            System.out.println(a+b);
            sc.nextLine();
        }

    }

}
