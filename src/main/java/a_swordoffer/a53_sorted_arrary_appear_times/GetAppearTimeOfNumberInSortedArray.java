package a_swordoffer.a53_sorted_arrary_appear_times;

/**
 * @program: swordofferjava
 * @description: 数字在排序数组中出现的次数
 * @author: Jin Hongjian
 * @create: 2020-09-19
 **/
public class GetAppearTimeOfNumberInSortedArray {
    /*剑指offer思路
     * 使用二分查找法找到第一个k，和最后一个k
     * */
    static int getFirstK(int[] array, int length, int k, int start, int end) {
        if (start > end) {
            return -1;
        }
        int midIndex = (start + end) / 2;
        if (array[midIndex] == k) {
            if ((midIndex > 0 && array[midIndex - 1] != k) || midIndex == 0) { //最前面一个k
                return midIndex;
            } else {
                end = midIndex - 1;
            }
        } else if (array[midIndex] > k) {
            end = midIndex - 1;
        } else {
            start = midIndex + 1;
        }
        return getFirstK(array, length, k, start, end);
    }

    static int getLastK(int[] array, int length, int k, int start, int end) {
        if (start > end) {
            return -1;
        }
        int midIndex = (start + end) / 2;
        if (array[midIndex] == k) {
            if ((midIndex < length - 1 && array[midIndex + 1] != k) || midIndex == length - 1) { //最前面一个k
                return midIndex;
            } else {
                start = midIndex + 1;
            }
        } else if (array[midIndex] < k) {
            start = midIndex + 1;
        } else {
            end = midIndex - 1;
        }
        return getLastK(array, length, k, start, end);
    }


    public static int getNumberOfK(int[] array, int k) {
        if (array == null) {
            throw new RuntimeException();
        }
        int res = 0;
        int firstK = getFirstK(array, array.length, k, 0, array.length - 1);
        int lastK = getLastK(array, array.length, k, 0, array.length - 1);
        if (firstK != -1 && lastK != -1) {
            res = lastK - firstK + 1;
        }
        return res;
    }


    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,3,3,3,4,5};
        int numberOfK = getNumberOfK(arr, 3);
        System.out.println(numberOfK);
    }
}
