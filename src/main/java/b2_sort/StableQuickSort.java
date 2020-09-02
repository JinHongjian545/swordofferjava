package b2_sort;

import java.util.Arrays;

/**
 * @program: swordofferjava
 * @description: 稳定的快速排序，基于数据搬移而不是交换，会增加复杂度
 * @author: Jin Hongjian
 * @create: 2020-07-14
 **/
public class StableQuickSort {
    //递归
    public static void quickSort(int[] nums, int start, int end) {
        if (start >= end) {
            return;
        }
        int index = partition(nums, start, end);
        System.out.println("======");
        System.out.println(Arrays.toString(nums));
        quickSort(nums, start, index - 1);
        quickSort(nums, index + 1, end);
    }

    private static int partition(int[] nums, int start, int end) {
        int pivot = nums[end];
        int left = start;
        int right = start;
        while (right <= end - 1) {
            if (nums[right] <= pivot) { //注意这里一定要是小于等于，让等于pivot的数也放到前面去，保证稳定性
                for (int i = right; i > left; i--) { //数据依次移动
                    int temp = nums[i];
                    nums[i] = nums[i - 1];
                    nums[i - 1] = temp;
                }
                left++;
            }
            right++;
        }
        nums[end] = nums[left];
        nums[left] = pivot;
        return left;
    }

    public static void main(String[] args) {
        int[] nums = {9, 3, 2, 10, 1, 5, 8, 9, 4, 6, 3, 5};
        System.out.println(Arrays.toString(nums));

        quickSort(nums, 0, nums.length-1);

        System.out.println(Arrays.toString(nums));
    }


}
