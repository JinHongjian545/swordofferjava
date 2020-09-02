package a_swordoffer.a45_print_min_number;

import java.util.Arrays;

/**
 * 打印整数数组中所有的数组合起来的最小数
 */
public class PrintMinNumber {
    private static String printMinNumber(int[] nums) {
        //先转为字符串
        String[] strings = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strings[i] = nums[i] + "";
        }
        //lambda 写法
        Arrays.sort(strings, (str1, str2) -> (str1 + str2).compareTo(str2 + str1));
        StringBuilder sb = new StringBuilder();
        for (String string : strings) {
            sb.append(string);
        }
        return sb.toString();
    }

            /*        //定义一个比较器
        Comparator<String> comparator = new Comparator<String>() {
            @Override
            public int compare(String str1, String str2) {
                return (str1 + str2).compareTo(str2 + str1);
            }
        };
        Arrays.sort(strings, comparator); //使用定义的比较器排序*/

    public static void main(String[] args) {
        int[] nums = new int[]{3, 32, 321};
        System.out.println(printMinNumber(nums));
    }

}
