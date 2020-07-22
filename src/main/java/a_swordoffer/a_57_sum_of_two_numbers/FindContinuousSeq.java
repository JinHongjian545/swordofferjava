package a_swordoffer.a_57_sum_of_two_numbers;

import java.util.ArrayList;
import java.util.List;

public class FindContinuousSeq {

    /**
     * 找到和为target的连续整数序列， 剑指282页思考题
     *
     * @param target
     * @return
     */
    public static List<String> findSeq(int target) {
        List<String> results = new ArrayList<>();
        int left = 1;
        int right = 2;
        int currentSum = 3;

        //要加到target的一半，例如t=9时，left到4，10时也是到4，因此先加1再除以2
        int mid = (target + 1) / 2;

        while (left < mid) {
            if (currentSum == target) {
                addResult(results, left, right);
            }

            while (currentSum > target && left < mid) { //左指针右移，减值
                currentSum -= left;
                left++;
                if (currentSum == target) {
                    addResult(results, left, right);
                }
            }
            //右指针右移，加值
            right++;
            currentSum += right;
        }
        return results;

    }

    private static void addResult(List<String> results, int left, int right) {
        StringBuilder sb = new StringBuilder();
        for (int i = left; i < right; i++) {
            sb.append(i).append(',');
        }
        sb.append(right);
        results.add(sb.toString());
    }

    public static void main(String[] args) {

        List<String> seq = findSeq(100);
        for (String s : seq) {
            System.out.println(s);
        }
    }
}
