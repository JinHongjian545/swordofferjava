package b_3_dynamic_programming;

/**
 * 完全背包问题
 * 题目：有一个容量为 capacity 的背包，和一些物品1,2,3,···,n。这些物品分别有两个属性，重量 w[n] 和价值 v[n]，每种物品有 无数个！
 * 要求用这个背包装下 价值 尽可能多的物品，求该最大价值，物品总重量不能超过背包容量。
 * <p>
 * 与0-1背包的不同之处则在于每个物品的数量不再是一个，而是无数个。
 */
public class CompleteKnapsack {
    /**
     * 0-1背包问题的动态规划解法
     *
     * @param capacity 背包容量
     * @param n        物品个数
     * @param w        物品的重量数组
     * @param v        物品的价值数组
     * @return 背包能装的最大价值
     */
    private static int completeKnapsack(int capacity, int n, int[] w, int[] v) { //todo
        //动态规划数组 dp[i][j]表示 前i个物品在背包容量为j时能装的最大价值，初始化数组时多给一个位置，方便从1开始计数
        int[][] dp = new int[n + 1][capacity + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= capacity; j++) {
                //如果第i件物品的重量大于背包容量j,则不装入背包
                //由于weight和value数组下标都是从0开始,故注意第i个物品的重量为 w[i-1],价值为 v[i-1]
                for (int k = 0; k * w[i-1] <= j; k++) {
                    dp[i][j] = Math.max(dp[i][j], dp[i][j - k * w[i - 1]] + k * v[i - 1]);
                }
            }
        }
        int j = capacity;
        StringBuilder numStringBuilder = new StringBuilder();
        for (int i = n; i > 0; i--) {
            //若果dp[i][j]>dp[i-1][j],这说明第i件物品是放入背包的
            if (dp[i][j] > dp[i - 1][j]) {
                numStringBuilder.append(',').append(i);
                j = j - w[i - 1];
            }
            if (j == 0) {
                break;
            }
        }
        String numStr = numStringBuilder.length() == 0 ? "" : numStringBuilder.reverse().substring(0, numStringBuilder.length() - 1);
        System.out.println(numStr);
        return dp[n][capacity];

    }

    /*如果要看最大价值时哪些物品装进去了，通过如下方式：*/
    //逆推找出装入背包的所有商品的编号

    public static void main(String[] args) {

        int[] weight = new int[]{5, 3, 4, 6};
        int[] value = new int[]{20, 10, 12, 30};
        int res = completeKnapsack(15, 4, weight, value);
        System.out.println(res);


    }
}
