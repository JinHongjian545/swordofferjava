package b2_sort;

import java.util.Arrays;

/**
 * @program: swordofferjava
 * @description: 希尔排序
 * @author: Jin Hongjian
 * @create: 2020-09-03
 **/
public class ShellSort {

    static void shellSort(int[] arr) {
        if (arr == null) {
            return;
        }
        int temp = 0;
        int inc = arr.length; //希尔排序的增量
        while (true) {
            inc = inc / 2;
            for (int k = 0; k < inc; k++) { //最外层循环根据增量划分子序列，实际上就是确定每个子序列的最开始数
                //里面的这两层循环实际上就是插入排序，不过是对应子序列的插入排序
                for (int i = k + inc; i < arr.length; i += inc) { //i = k + inc 开始循环就类比与插入排序的 i=1开始循环， 即子序列的第二个元素
                    for (int j = i; j > k; j -= inc) { //j > k 结束循环就类比与插入排序的 j>0 开始循环， 也即子序列的第二个元素和第一个元素比较
                        if (arr[j] < arr[j - inc]) {
                            temp = arr[j - inc];
                            arr[j - inc] = arr[j];
                            arr[j] = temp;
                        } else {
                            break;
                        }
                    }
                }

            }

            if (inc == 1) {
                break;
            }
        }

    }

    public static void main(String[] args) {
        int[] nums = new int[]{3, 18, 11, 7, 66, 7, 8, 17, 32, 5, 19, 27, 12, 9, 13, 22, 4};
        shellSort(nums);
        System.out.println(Arrays.toString(nums));
    }

}
