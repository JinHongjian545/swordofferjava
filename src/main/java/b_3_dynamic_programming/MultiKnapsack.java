package b_3_dynamic_programming;

/**
 * 多重背包问题
 * 题目：有一个容量为 capacity 的背包，和一些物品1,2,3,···,n。这些物品分别有两个属性，重量 w[n] 和价值 v[n]，物品个数分别为 num[n]
 * 要求用这个背包装下 价值 尽可能多的物品，求该最大价值，物品总重量不能超过背包容量。
 * <p>
 * 与0-1背包和完全背包的不同之处则在于每个物品的数量不再是一个也不是无数个，而是个数由num[n]数组给出。
 */
public class MultiKnapsack {
    /**
     * 多重背包问题的动态规划解法
     *
     * @param capacity 背包容量
     * @param n        物品个数
     * @param w        物品的重量数组
     * @param v        物品的价值数组
     * @return 背包能装的最大价值
     */
    private static int completeKnapsack(int capacity, int n, int[] w, int[] v, int[] num) {
        //动态规划数组 dp[i][j]表示 前i个物品在背包容量为j时能装的最大价值，初始化数组时多给一个位置，方便从1开始计数
        int[][] dp = new int[n + 1][capacity + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= capacity; j++) {
                //由于weight和value数组下标都是从0开始,故注意第i个物品的重量为 w[i-1],价值为 v[i-1],数量为 num[i-1]
                //递推方向就是从上向下的一个递推方向，即只要知道矩阵的第i-1行就能推出矩阵的第i行
                //多重背包递推公式 dp[i][j] = max{dp[i-1][j-k*w[i-1]] + k*v[i-1])}，其中 k 满足 0 <= k && k * w[i-1] <= j && k <= num[i - 1]
                //max{}表示在集合中的最大值
                for (int k = 0; k * w[i - 1] <= j && k <= num[i - 1]; k++) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - k * w[i - 1]] + k * v[i - 1]);
                }
            }
        }
        //todo
        //暂不知如何确定哪些物品分别放了多少个到背包中怎么得到
        return dp[n][capacity];
    }

    public static void main(String[] args) {

        int[] weight = new int[]{5, 3, 4, 6};
        int[] value = new int[]{20, 10, 12, 30};
        int[] num = new int[]{1, 2, 1, 1};
        int res = completeKnapsack(15, 4, weight, value, num);
        System.out.println(res);


    }
}
