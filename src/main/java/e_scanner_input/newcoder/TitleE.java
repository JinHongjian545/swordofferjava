package e_scanner_input.newcoder;

import java.util.Scanner;

/**
 * @program: swordofferjava
 * @description:
 * @author: Jin Hongjian
 * @create: 2020-07-30
 * 链接：https://ac.nowcoder.com/acm/contest/5647/E
 * 来源：牛客网
 *
 * 计算一系列数的和
 *
 * 输入描述:
 * 输入的第一行包括一个正整数t(1 <= t <= 100), 表示数据组数。
 * 接下来t行, 每行一组数据。
 * 每行的第一个整数为整数的个数n(1 <= n <= 100)。
 * 接下来n个正整数, 即需要求和的每个正整数。
 * 输出描述:
 * 每组数据输出求和的结果
 * 示例1
 * 输入
 * 复制
 * 2
 * 4 1 2 3 4
 * 5 1 2 3 4 5
 * 输出
 * 复制
 * 10
 * 15
 **/
public class TitleE {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int rows  = sc.nextInt();
        while(rows > 0){
            int num = sc.nextInt();
            int sum = 0;
            while(num > 0){
                sum += sc.nextInt();
                num--;
            }
            System.out.println(sum);
            rows--;
        }
    }
}
