package d_company_real.bytedance;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * https://www.nowcoder.com/question/next?pid=8537209&qid=141021&tid=34688844
 作为一个手串艺人，有金主向你订购了一条包含n个杂色串珠的手串——每个串珠要么无色，要么涂了若干种颜色。为了使手串的色彩看起来不那么单调，
 金主要求，手串上的任意一种颜色（不包含无色），在任意连续的m个串珠里至多出现一次（注意这里手串是一个环形）。手串上的颜色一共有c种。
 现在按顺时针序告诉你n个串珠的手串上，每个串珠用所包含的颜色分别有哪些。请你判断该手串上有多少种颜色不符合要求。
 即询问有多少种颜色在任意连续m个串珠中出现了至少两次。


 输入描述:
 第一行输入n，m，c三个数，用空格隔开。(1 <= n <= 10000, 1 <= m <= 1000, 1 <= c <= 50)
 接下来n行每行的第一个数num_i(0 <= num_i <= c)表示第i颗珠子有多少种颜色。
 接下来依次读入num_i个数字，每个数字x表示第i颗柱子上包含第x种颜色(1 <= x <= c)

 输出描述:
 一个非负整数，表示该手链上有多少种颜色不符需求。
 * @program: swordofferjava
 * @description:
 * @author: Jin Hongjian
 * @create: 2020-07-11
 **/
public class Main02 {

    public static void main(String[] args) {
        //input
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int c = scanner.nextInt();
        ArrayList<Integer>[] colors = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            colors[i] = new ArrayList<Integer>();
            int kindsOfColors = scanner.nextInt();
            for (int j = 0; j < kindsOfColors; j++) {
                colors[i].add(scanner.nextInt());
            }
        }

        int result = getResult(colors, m, c);

        System.out.println(result);
    }

    private static int getResult(ArrayList<Integer>[] colors, int m, int c) {
        int result = 0;
        int length = colors.length;

        for (int j = 1; j <= c; j++) { //颜色的遍历
            boolean flag = false;
            for (int i = 0; i < length; i++) { //串珠的遍历
                int times = 0;
                for (int k = 0; k < m; k++) {//相邻串珠的遍历
                    if (colors[(i + k) % length].contains(j)) {
                        times++;
                    }
                }
                if (times > 1) {
                    flag = true;
                    break;
                }
            }
            if (flag){
                result++;
            }

        }
        return result;
    }
}
