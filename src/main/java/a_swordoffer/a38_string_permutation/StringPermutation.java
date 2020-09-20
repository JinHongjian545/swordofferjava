package a_swordoffer.a38_string_permutation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.TreeSet;

/**
 * @program: swordofferjava
 * @description: 字符串中所有字符的全排列
 * @author: Jin Hongjian
 * @create: 2020-09-20
 **/
public class StringPermutation {

    static ArrayList<String> permutation(String str) {
        TreeSet<String> set = new TreeSet<>();
        if (str == null || str.isEmpty()) {
            return new ArrayList<>();
        }
        permutationCore(set, str.toCharArray(), 0);
        return new ArrayList<>(set);
    }

    private static void permutationCore(TreeSet<String> set, char[] str, int begin) {
        if (begin == str.length) { //递归结束条件
            set.add(new String(str));
        } else {
            for (int i = begin; i < str.length; i++) { //以第一次循环 begin=0 为例， 这里的交换就是以第 i 个字符作为开头
                //swap
                swap(str, i, begin);
                permutationCore(set, str, begin + 1);
                //swap back 处理完成以后交换回来，下一个字符在原基础上进行处理
                swap(str, i, begin);
            }
        }
    }

    private static void swap(char[] str, int a, int b) {
        char temp = str[a];
        str[a] = str[b];
        str[b] = temp;
    }


    public static void main(String[] args) {
        String s = "abc";
        ArrayList<String> permutation = permutation(s);
        for (String s1 : permutation) {
            System.out.println(s1);
        }
    }

}
