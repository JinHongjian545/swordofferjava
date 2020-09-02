package a_swordoffer.a65_addwithout_arithmetic;

/**
 * 不用加减乘除做加法
 */
public class Add {
    /**
     * 转为二进制使用位运算
     * 第一步：使用异或运算计算两个数不计进位时的加法
     * 第二步：使用位与运算计算两个数相加时的进位(需要左移一位)
     * 第三步：把第一二步的结果加起来（这就变成循环了）
     *
     * @param a
     * @param b
     * @return
     */
    public static int add(int a, int b) {
        int sumWithoutCarry, carry = 0;
        do {
            sumWithoutCarry = a ^ b;
            carry = (a & b) << 1;
            a = sumWithoutCarry;
            b = carry;
        } while (carry != 0);
        return sumWithoutCarry;
    }

    public static void main(String[] args) {
        System.out.println(add(2, 3));
    }

}
