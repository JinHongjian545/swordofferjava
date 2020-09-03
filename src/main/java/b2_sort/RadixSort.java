package b2_sort;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @program: swordofferjava
 * @description: 基数排序
 * 基数排序与本系列前面讲解的七种排序方法都不同，它不需要比较关键字的大小。
 * 它是根据关键字中各位的值，通过对排序的N个元素进行若干趟“分配”与“收集”来实现排序的。
 * @author: Jin Hongjian
 * @create: 2020-09-03
 **/
public class RadixSort {

    static void radixSort(int[] arr) {
        if (arr == null) {
            return;
        }
        //先找到数组中的最大值，确定最大位数
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        //拿到最大值的位数
        int totalDigits = 0;
        while (max > 0) {
            totalDigits++;
            max = max / 10;
        }
        //分桶并计数
        int length = arr.length;
        int[] count = new int[10];//count数组用于计数，保存每个桶里有多少个数字
        int[][] bucket = new int[10][length];//二维数组用于存储每次排序后的结果，某个数字位上相同的放到一个桶里
        int curDigit = 1; //代表遍历的位数：1,2,3...
        int base = 1; //代表位数对应的数：1,10,100...
        while (curDigit <= totalDigits) {
            //将数组array里的每个数字放在相应的桶里
            for (int num : arr) {
                int digit = num / base % 10;
                bucket[digit][count[digit]] = num; //这里注意理解，如果 arr[i] 为 23 第一次循环base为1时， bucket[3][0]就会被置为23
                count[digit]++; //count[3] 会由0自增为1，表示这一轮循环中，该数位为3的数字已经有一个了
            }
            //将上面循环生成的桶里的数据覆盖到原数组中用于保存这一位的排序结果
            int k = 0;
            for (int i = 0; i < 10; i++) {
                if (count[i] != 0) {
                    for (int j = 0; j < count[i]; j++) {
                        arr[k++] = bucket[i][j];
                    }
                    count[i] = 0; //重置
                }
            }
            curDigit++;
            base *= 10;
        }


    }


    public static void main(String[] args) {
        int[] nums = new int[]{3, 18, 111, 7, 66, 3245, 7, 8, 171, 326, 5, 19, 27, 12, 9, 13, 22, 4, 64537, 23422, 1111, 43};
        radixSort(nums);
        System.out.println(Arrays.toString(nums));


    }

}
