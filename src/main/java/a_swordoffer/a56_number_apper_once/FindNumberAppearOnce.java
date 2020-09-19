package a_swordoffer.a56_number_apper_once;

import java.util.HashSet;
import java.util.Iterator;

/**
 * @program: swordofferjava
 * @description: 数组中只出现一次的两个数字
 * 除了这两个数字外，其他的数字都出现了两次
 * @author: Jin Hongjian
 * @create: 2020-09-19
 **/
public class FindNumberAppearOnce {
    /*
    * 最简单的解法，通过set找到已经出现过的数字
    //num1,num2分别为长度为1的数组。传出参数
    //将num1[0],num2[0]设置为返回结果
    * */
    static void findNumAppearOnce(int[] array, int num1[], int num2[]) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < array.length; i++) {
            if (set.contains(array[i])) {
                set.remove(array[i]);
            } else {
                set.add(array[i]);
            }
        }
//        Object[] objects = set.toArray();
        Iterator<Integer> iterator = set.iterator();
        num1[0] = iterator.next();
        num2[0] = iterator.next();
    }

    /**
     * 剑指offer上的基于异或的方法
     * 把数组中的所有数拿来异或一次，会得到一个结果， 比如 {2, 4, 3, 6, 2, 3, 5, 5} 会得到 0010
     * 由于两个相同的数异会得到0，因此所以倒数第二位的1肯定是由那两个不一样的数字异或得到的， 且一定其中一个为1，另一个为0
     * 因此可以根据这一位的值把原数组分为两个数组（为1的在一组，为0的在一组） 这两个数肯定会分到不同的组里，然后两个组里分别异或即可得到这个数的值
     */

    public static void main(String[] args) {
        int[] array = new int[]{2, 4, 3, 6, 2, 3, 5, 5};
        int[] num1 = new int[1];
        int[] num2 = new int[1];
        findNumAppearOnce(array, num1, num2);
        System.out.println(num1[0]);
        System.out.println(num2[0]);

        //找到一个数最右边的1所在的位置
        int a = 2;

    }

}
