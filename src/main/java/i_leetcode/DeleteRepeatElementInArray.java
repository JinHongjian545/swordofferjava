package i_leetcode;

/**
 * @program: swordofferjava
 * @description:
 * @author: Jin Hongjian
 * @create: 2020-07-30
 **/
public class DeleteRepeatElementInArray {
    public static int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int resultNum = 1;
        int cVal = nums[0];
        int len = nums.length;
        for (int i = 1; i < len; i++) {
            while (i < len && nums[i] == cVal) {
                i++;
            }
            if (i == len) {
                return resultNum;
            }
            //现在i是第一个满足 nums[i] != cVal 的数的索引
            if (i != resultNum) {//复制到前面去
                nums[resultNum] = nums[i];
            }
            resultNum++;
            cVal = nums[i];
        }
        return resultNum;
    }

    public static void main(String[] args) {

        int[] nums = new int[]{1, 2};
        int i = removeDuplicates(nums);
        System.out.println(i);
    }
}
