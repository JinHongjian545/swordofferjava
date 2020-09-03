package b2_sort;

import java.util.Arrays;

/**
 * @program: swordofferjava
 * @description: 选择排序
 * @author: Jin Hongjian
 * @create: 2020-09-03
 **/
public class SelectSort {

    static void selectSort(int[] arr) {
        if (arr == null) {
            return;
        }
        int minIndex, temp;
        for (int i = 0; i < arr.length - 1; i++) { //外层循环用来确定待交换索引
            minIndex = i;
            for (int j = i + 1; j < arr.length; j++) { //内层循环用来在后面的所有数中找到一个最小数所在的索引
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            //swap，然后执行交换
            temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3, 8, 1, 7, 5, 2, 4};
        selectSort(nums);
        System.out.println(Arrays.toString(nums));


    }

}
