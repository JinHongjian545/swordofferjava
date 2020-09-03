package b2_sort;

import java.util.Arrays;

/**
 * @program: swordofferjava
 * @description: 归并排序
 * @author: Jin Hongjian
 * @create: 2020-09-03
 **/
public class MergeSort {

    static void mergeSort(int[] arr) {
        if (arr == null)
            return;
        int[] res = new int[arr.length];
        mergeSortCore(arr, res, 0, arr.length - 1);
    }

    static void mergeSortCore(int[] arr, int[] res, int start, int end) {
        if (start >= end) { //递归结束条件
            return;
        }
        int mergeLen = end - start;
        int mid = mergeLen / 2 + start;
        //两边分别merge排序
        int start1 = start, end1 = mid;
        int start2 = mid + 1, end2 = end;
        mergeSortCore(arr, res, start1, end1);
        mergeSortCore(arr, res, start2, end2);

        //合并到res中
        int k = start;
        //同步合并, 把原数组的内容归并排到res中去
        while (start1 <= end1 && start2 <= end2) {
            res[k++] = arr[start1] < arr[start2] ? arr[start1++] : arr[start2++];
        }
        //合并剩下的还未合并的部分
        while (start1 <= end1){
            res[k++] = arr[start1++];
        }
        while (start2 <= end2){
            res[k++] = arr[start2++];
        }
        //归并完成后将res数组内容复制回原数组arr
        for (int i = start; i <= end; i++) {
            arr[i] = res[i];
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3, 18, 11, 7, 66, 7, 8, 17, 32, 5, 19, 27, 12, 9, 13, 22, 4};
        mergeSort(nums);
        System.out.println(Arrays.toString(nums));
    }

}
