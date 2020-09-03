package b2_sort;

import java.util.Arrays;

/**
 * @program: swordofferjava
 * @description: 插入排序
 * @author: Jin Hongjian
 * @create: 2020-09-03
 **/
public class InsertSort {

    static void insertSort(int[] arr) {
        if (arr == null) {
            return;
        }
        int temp;
        for (int i = 1; i < arr.length; i++) { //外层循环确定当前要处理的数
            for (int j = i; j > 0; j--) { //内层循环处理往前插入，实际上就是一直往前比较，直到找到插入位置
                if (arr[j] < arr[j - 1]) {
                    temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                }else {
                    break;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3, 18, 11, 7, 66, 7, 8, 17, 32, 5, 19, 27, 12, 9, 13, 22, 4};
        insertSort(nums);
        System.out.println(Arrays.toString(nums));


    }

}
