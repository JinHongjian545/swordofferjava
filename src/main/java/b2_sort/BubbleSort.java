package b2_sort;

import java.util.Arrays;

/**
 * @program: swordofferjava
 * @description: 冒泡排序
 * @author: Jin Hongjian
 * @create: 2020-09-03
 **/
public class BubbleSort {

    static void bubbleSort(int[] arr) {
        if (arr == null) {
            return;
        }
        int temp;
        for (int i = 0; i < arr.length - 1; i++) { //这个循环用来决定每次冒泡排序比较的终点
            for (int j = 0; j < arr.length - 1 - i; j++) { //这个循环用来每次从起点到外层循环决定的终点进行逐个比较交换
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3, 8, 1, 7, 5, 2, 4};
        bubbleSort(nums);
        System.out.println(Arrays.toString(nums));


    }

}
