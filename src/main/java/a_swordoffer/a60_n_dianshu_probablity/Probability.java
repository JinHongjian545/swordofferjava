package a_swordoffer.a60_n_dianshu_probablity;

/**
 * n个骰子的点数朝上一面的点数之和为s，输入n，打印出s的所有可能的值出现的概率 ??? todo 没有理解
 */
public class Probability {

    /**
     * 基于递归实现，n的骰子总的点数的可能性包含 n ~ 6n，总的可能性有 6n-n+1 = 5n+1 种
     * 因此创建长度为 5n+1 的数组，第i个索引存储点数 i+n 出现的次数，即有如下对应：
     * probabilities[0] - 点数n出现的次数
     * probabilities[5n] - 点数6n出现的次数
     *
     * @param number 骰子的数量
     */
    private static int g_maxValue = 6;

    static void printProbability(int n) {
        if (n < 1) {
            return;
        }
        int maxSum = g_maxValue * n;
        int[] probabilities = new int[maxSum - n + 1];
        getProbability(n, probabilities);
        double total = Math.pow(g_maxValue, n);//总的可能性
        for (int i = n; i <= maxSum; i++) {
            double ratio = (double) probabilities[i - n] / total;
            System.out.println(i + ": " + ratio);
        }
    }

    private static void getProbability(int n, int[] probabilities) {
        for (int i = 1; i <= g_maxValue; i++) {
            getProbabilityCore(n, n, i, probabilities);
        }
    }

    private static void getProbabilityCore(int original, int current, int sum, int[] probabilities) {
        if (current == 1) {
            probabilities[sum - original]++;
        } else {
            for (int i = 1; i < g_maxValue; i++) {
                getProbabilityCore(original, current - 1, i + sum, probabilities);
            }
        }
    }

    public static void main(String[] args) {
        printProbability(2);
    }
}
