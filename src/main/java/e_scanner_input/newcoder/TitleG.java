package e_scanner_input.newcoder;

import java.util.Scanner;

/**
 * @program: swordofferjava
 * @description:
 * @author: Jin Hongjian
 * @create: 2020-07-30
链接：https://ac.nowcoder.com/acm/contest/5647/G
来源：牛客网

题目描述
计算一系列数的和
输入描述:
输入数据有多组, 每行表示一组输入数据。

每行不定有n个整数，空格隔开。(1 <= n <= 100)。
输出描述:
每组数据输出求和的结果
示例1
输入
复制
1 2 3
4 5
0 0 0 0 0
输出
复制
6
9
0
*/
public class TitleG {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        while(sc.hasNextLine()){
            String[] nums = sc.nextLine().trim().split(" ");
            int sum = 0;
            for(String num:nums){
                sum += Integer.parseInt(num);
            }
            System.out.println(sum);
        }
    }
}
