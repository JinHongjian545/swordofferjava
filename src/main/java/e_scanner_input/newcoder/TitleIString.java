package e_scanner_input.newcoder;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @program: swordofferjava
 * @description:
 * @author: Jin Hongjian
 * @create: 2020-07-30
链接：https://ac.nowcoder.com/acm/contest/5647/I
来源：牛客网

题目描述
对输入的字符串进行排序后输出
输入描述:
多个测试用例，每个测试用例一行。

每行通过空格隔开，有n个字符，n＜100
输出描述:
对于每组测试用例，输出一行排序过的字符串，每个字符串通过空格隔开
示例1
输入
复制
a c bb
f dddd
nowcoder
输出
复制
a bb c
dddd f
nowcoder
 **/
public class TitleIString {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        while(sc.hasNextLine()){
            String[] strs = sc.nextLine().trim().split(" ");
            Arrays.sort(strs);
            for(int i = 0; i<strs.length-1; i++){
                System.out.print(strs[i]+" ");
            }
            System.out.println(strs[strs.length-1]);
        }
    }
}
