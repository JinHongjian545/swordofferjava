package a_swordoffer.a_63_maxprofit;

/**
 * 股票的最大利润
 */
public class MaxProfit {
    public static int maxProfit(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }
        int result = nums[1] - nums [0];
        int cProfit = 0;
        int cMin = Math.min(nums[0],nums[1]);
        for (int i = 2; i < nums.length; i++) {
            cProfit = nums[i] - cMin;
            if (cProfit > result) {
                result = cProfit;
            }
            if (nums[i] < cMin) {
                cMin = nums[i];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{9,11,8,5,7,12,16,14};
        int maxProfit = maxProfit(nums);
        System.out.println(maxProfit);

    }
}
