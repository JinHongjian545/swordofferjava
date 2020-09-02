package a_swordoffer.a57_sum_of_two_numbers;

import java.util.Arrays;

public class FindNumbersWithSum {
    /**
     * 从排序好的递增数组中找到和为sum的两个数字，双指针法
     *
     * @return results 结果保存到数组results中
     */
    private static boolean findNumbersOfSum(int[] array, long target, int[] results) {
        int left = 0;
        int right = array.length - 1;
        while (left < right) {
            long sum = array[left] + array[right];
            if (sum == target) {
                results[0] = array[left];
                results[1] = array[right];
                return true;
            }
            if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        int[] ints = new int[]{1, 2, 4, 7, 11, 15};
        int[] results = new int[2];

        boolean found = findNumbersOfSum(ints, 176, results);
        if (found) {
            System.out.println("FOUND" + Arrays.toString(results));
        } else {
            System.out.println("NOT FOUND");
        }
    }
}
