package a_swordoffer.a21_change_array_even_odd;

/**
 * @program: swordofferjava
 * @description: 调整数组是奇数位于偶数前面, 奇偶数的相对位置不变
 * @author: Jin Hongjian
 * @create: 2020-09-20
 **/
public class ReorderOddEven {

    /*不考虑原始顺序*/
    static void reOrderArray(int[] array) {
        int left = 0;
        int right = array.length - 1;

        while (left < right) {
            while (left < right && (array[left] & 1) != 0) {
                left++;
            }
            while (left < right && (array[right] & 1) == 0) {
                right--;
            }
            if (left < right) {
                int temp = array[left];
                array[left] = array[right];
                array[right] = temp;

            }
        }

    }

    /*考虑原始顺序, 空间换时间的做法*/
    static void reOrderArray1(int[] array) {
        int[] odd = new int[array.length]; //保存奇数
        int[] even = new int[array.length]; //保存偶数
        int oddNum = 0;
        int evenNum = 0;
        for (int i = 0; i < array.length; i++) {
            if ((array[i] & 1) == 0) {
                even[evenNum++] = array[i];
            } else {
                odd[oddNum++] = array[i];
            }
        }
        for (int i = 0; i < oddNum; i++) {
            array[i] = odd[i];
        }
        for (int i = 0; i < evenNum; i++) {
            array[i + oddNum] = even[i];
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7};
        reOrderArray(arr);
    }

}
