package b2_sort;

import java.util.Arrays;

/**
 * @program: swordofferjava
 * @description: 计数排序
 * 计数排序，基数排序，桶排序等非比较排序算法，平均时间复杂度都是O(n)。这些排序因为其待排序元素本身就含有了定位特征，
 * 因而不需要比较就可以确定其前后位置，从而可以突破比较排序算法时间复杂度O(nlgn)的理论下限。
 *
 * 可以看到辅助数组的长度和桶的数量由最大值和最小值决定，假如两者之差很大，而待排序数组又很小，那么就会导致辅助数组或桶大量浪费。
 *
 * @author: Jin Hongjian
 * @create: 2020-09-03
 **/
public class CountSort {

    static void countSort(int[] arr) {
        if (arr == null) {
            return;
        }
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (max < arr[i]) {
                max = arr[i];
            }
        }
        //构造计数桶
        int[] bucket = new int[max + 1];
        for (int value : arr) {
            bucket[value]++;
        }
        int k = 0;
        for (int i = 0; i <= max; i++) {
            for (int j = 0; j < bucket[i]; j++) {
                arr[k++] = i;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3, 18, 11, 7, 66, 7, 8, 17, 17, 17, 17, 32, 5, 19, 27, 12, 9, 13, 22, 4};
        countSort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
