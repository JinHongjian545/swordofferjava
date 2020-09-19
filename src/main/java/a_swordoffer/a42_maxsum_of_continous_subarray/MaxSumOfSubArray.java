package a_swordoffer.a42_maxsum_of_continous_subarray;

/**
 * @program: swordofferjava
 * @description: 连续数组的最大和
 * @author: Jin Hongjian
 * @create: 2020-09-19
 **/
public class MaxSumOfSubArray {

    static int maxSum(int[] array) {
        if (array == null) {
            throw new RuntimeException("Invalid input");
        }
        int currentSum = 0;
        int maxSum = 0x80000000; //最小的int，-2147483648
        for (int i = 0; i < array.length; i++) {
            if (currentSum <= 0) {
                currentSum = array[i];
            } else {
                currentSum += array[i];
            }
            maxSum = Math.max(maxSum, currentSum);
        }
        return maxSum;
    }

    public static void main(String[] args) {
        System.out.println(0x80000000);

        int[] arr = new int[]{1, -1, 3, 10, -4, 7, 2, -5};
        int sum = maxSum(arr);
        System.out.println(sum);

    }
}
