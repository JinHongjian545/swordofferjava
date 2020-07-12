package d_bytedance_realquestion;

import java.util.Scanner;

/**
 * @program: javaStudyTest
 * @description:
 * @author: Jin Hongjian
 * @create: 2020-07-11
 * https://www.nowcoder.com/question/next?pid=8537209&qid=141022&tid=34688844
 *
 * 为了不断优化推荐效果，今日头条每天要存储和处理海量数据。假设有这样一种场景：我们对用户按照它们的注册时间先后来标号，对于一类文章，每个用
 * 户都有不同的喜好值，我们会想知道某一段时间内注册的用户（标号相连的一批用户）中，有多少用户对这类文章喜好值为k。因为一些特殊的原因，不会
 * 出现一个查询的用户区间完全覆盖另一个查询的用户区间(不存在L1<=L2<=R2<=R1)。

 * 输入描述:
 * 输入： 第1行为n代表用户的个数 第2行为n个整数，第i个代表用户标号为i的用户对某类文章的喜好度 第3行为一个正整数q代表查询的组数
 * 第4行到第（3+q）行，每行包含3个整数l,r,k代表一组查询，即标号为l<=i<=r的用户中对这类文章喜好值为k的用户的个数。
 * 数据范围n <= 300000,q<=300000 k是整型
 **/
public class Main01 {

    public static void main(String[] args) {
        //input
        Scanner scanner = new Scanner(System.in);
        int userNumber = scanner.nextInt();
        int[] prefer = new int[userNumber];
        for (int i = 0; i < userNumber; i++) {
            prefer[i] = scanner.nextInt();
        }

        int queryNumber = scanner.nextInt();
        int[] results = new int[queryNumber];
        int start = 0;
        int end = 0;
        int id = 0;
        for (int i = 0; i < queryNumber; i++) {
            start = scanner.nextInt();
            end = scanner.nextInt();
            id = scanner.nextInt();
            results[i] = getResult(prefer, start, end, id);
        }

        for (int i = 0; i < queryNumber; i++) {
            System.out.println(results[i]);
        }
    }

    private static int getResult(int[] prefer, int start, int end, int id) {
        int result = 0;
        start--;
        end--;
        if (start < 0 || end >= prefer.length) {
            return 0;
        }
        while (start <= end) {
            if (prefer[start] == id) {
                result++;
            }
            start++;
        }

        return result;
    }
}