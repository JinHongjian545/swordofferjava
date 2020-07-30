package a_swordoffer.a_64_1plus_to_n;

public class OneAddToN {
    /**
     * 不能使用乘除法，条件判断语句等
     * 使用短路法, 当 && 之前的条件满足时会执行后面的条件，当 && 之前的条件已经不满足时，不会再执行后面的条件语句
     * @param n
     * @return
     */
    public static int sumSolution(int n) {
        int ans = n;
        boolean a = (ans != 0) && (ans += sumSolution(n - 1)) == 0;
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(sumSolution(3));
    }
}
