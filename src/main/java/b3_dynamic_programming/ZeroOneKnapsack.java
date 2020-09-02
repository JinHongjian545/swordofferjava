package b3_dynamic_programming;

/**
 * 0-1背包问题
 * 题目：有一个容量为 capacity 的背包，和一些物品1,2,3,···,n。这些物品分别有两个属性，重量 w[n] 和价值 v[n]，每种物品只有一个。
 * 要求用这个背包装下 价值 尽可能多的物品，求该最大价值，物品总重量不能超过背包容量。
 * <p>
 * 0-1背包问题：在最优解中，每个物品只有两种可能的情况，即在背包中或者不在背包中（背包中的该物品数为0或1），因此称为0-1背包问题。
 * <p>
 * 步骤1-找子问题：子问题必然是和物品有关的，对于每一个物品，有两种结果：能装下或者不能装下。
 * 第一，包的容量比物品重量小，装不下，这时的最大价值和前i-1个物品的最大价值是一样的。
 * 第二，还有足够的容量装下该物品，但是装了不一定大于当前相同重量的最优价值，所以要进行比较
 * 比较的两种情况，
 * 第一种：不装当前这个物品，这个好理解；
 * 第二种，装下这个物品，但是装下这个物品就意味着背包只能由更少的容量去装其他的物品，导致<其他部分加起来的价值> 加上 <当前物品新增的价值>
 * 不一定比<不装当前物品时的价值>更大，因此需要比较，使用动态规划时，这个<其他部分加起来的价值>就是已经计算过的内容。
 * 由上述分析，子问题中物品数和背包容量都应当作为变量。因此子问题确定为背包 剩余容量 为 j 时，求前i个物品所能达到最大价值。
 * <p>
 * 步骤2-确定状态：由上述分析，“状态”对应的“值”即为背包 剩余容量 为j时，求 前i个 物品所能达到最大价值，设为 dp[i][j] 。
 * 初始时，dp[0][j](0<=j<=capacity)为0，没有物品也就没有价值。
 * <p>
 * 步骤3-确定状态转移方程：由上述分析，第i个物品的重量为w,价值为v，则状态转移方程为
 * j<w，dp[i][j] = dp[i-1][j] //背包装不下该物品，最大价值不变
 * j>=w, dp[i][j] = max{dp[i-1][j-w[i]] + v[i], dp[i-1][j] } //和不放入该物品时同样达到该重量的最大价值比较
 */
public class ZeroOneKnapsack {
    /**
     * 0-1背包问题的动态规划解法
     *
     * @param capacity 背包容量
     * @param n        物品个数
     * @param w        物品的重量数组
     * @param v        物品的价值数组
     * @return 背包能装的最大价值
     */
    private static int zeroOneKnapsack(int capacity, int n, int[] w, int[] v) {
        //动态规划数组 dp[i][j]表示 前i个物品在背包容量为j时能装的最大价值，初始化数组时多给一个位置，方便从1开始计数
        int[][] dp = new int[n + 1][capacity + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= capacity; j++) {
                //如果第i件物品的重量大于背包容量j,则不装入背包
                //由于weight和value数组下标都是从0开始,故注意第i个物品的重量为 w[i-1],价值为 v[i-1]
                if (w[i - 1] > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], (dp[i - 1][j - w[i - 1]] + v[i - 1]));
                }
            }
        }
        return dp[n][capacity];
    }

    /*如果要看最大价值时哪些物品装进去了，通过如下方式：*/
    //逆推找出装入背包的所有商品的编号
       /*
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
        */

    public static void main(String[] args) {

        int[] weight = new int[]{5, 3, 4, 6};
        int[] value = new int[]{20, 10, 12, 30};
        int res = zeroOneKnapsack(15, 4, weight, value);
        System.out.println(res);


    }
}
