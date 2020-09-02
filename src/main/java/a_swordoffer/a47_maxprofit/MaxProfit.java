package a_swordoffer.a47_maxprofit;

/**
 * 第47题，动态规划，礼物的最大价值
 */
public class MaxProfit {
    public static int maxProfit(int[][] nums, int rows, int cols) {
        int[][] dp = new int[rows + 1][cols + 1]; //哨兵，避免边界判断
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= cols; j++) {
                dp[i][j] = nums[i - 1][j - 1] + Math.max(dp[i][j - 1], dp[i - 1][j]);
            }
        }
        return dp[rows][cols];
    }

    public static void main(String[] args) {
        int[][] nums = new int[][]{
                {1, 10, 3, 8},
                {12, 2, 9, 6},
                {5, 7, 4, 11},
                {3, 7, 16, 5}
        };

        System.out.println(maxProfit(nums,4,4));
    }
}
