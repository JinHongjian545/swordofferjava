package f_bit_shift;

/**
 * @program: swordofferjava
 * @description: 不通过四则运算获取int的最大值
 * @author: Jin Hongjian
 * @create: 2020-07-15
 **/
public class GetValueOfMaxInt {

    public static void main(String[] args) {
        //1
        System.out.println(Integer.MAX_VALUE);

        //2
        System.out.println(0x7fffffff);

        //3
        int max = 1;
        for (int i = 1; i < 31; i++) {
            max = (max << 1) | 1;
        }
        System.out.println(max);

        //4
        int max1 = -1 >>> 1;   //注意 >> 是带符号移位运算， >>> 是不带符号的移位运算，统一补0
        System.out.println(max1);

        //long
        System.out.println(Long.MAX_VALUE);
        System.out.println(-1L >>> 1);
    }
}
