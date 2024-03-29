package e_scanner_input.newcoder;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @program: swordofferjava
 * @description:
 * @author: Jin Hongjian
 * @create: 2020-07-30
 * 链接：https://ac.nowcoder.com/acm/contest/5647/H
 * 来源：牛客网
 *
 * 题目描述
 * 对输入的字符串进行排序后输出
 * 输入描述:
 * 输入有两行，第一行n
 *
 * 第二行是n个空格隔开的字符串
 * 输出描述:
 * 输出一行排序后的字符串，空格隔开，无结尾空格
 * 示例1
 * 输入
 * 复制
 * 5
 * c d a bb e
 * 输出
 * 复制
 * a bb c d e
 **/
public class TitleHString {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        String[] strs = new String[num];
        for(int i = 0; i<num; i++){
            strs[i] = sc.next();
        }
        Arrays.sort(strs);
        for(int i = 0; i<num-1; i++){
            System.out.print(strs[i]+" ");
        }
        System.out.print(strs[num-1]);
    }
}
