package a_swordoffer.a17_print_one_to_maxN;

/**
 * @program: swordofferjava
 * @description: 打印从1到最大n位数，考虑到数值的范围，不能直接打印
 * @author: Jin Hongjian
 * @create: 2020-09-20
 **/
public class PrintOneToMaxN {
    /*使用全排列的思想*/
    static void printOneToMaxOfNDigits(int n) {
        if (n <= 0) {
            return;
        }
        char[] number = new char[n];
        for (int i = 0; i < 10; i++) {
            number[0] = (char) (i + '0');
            PrintOneToMaxNRecu(number, n, 0);
        }
    }

    private static void PrintOneToMaxNRecu(char[] number, int length, int index) {
        if (index == length - 1) {
            System.out.println(new String(number)); //注意这里其实还需要处理一下前面的0，例如 005
            return;
        }
        for (int i = 0; i < 10; i++) {
            number[index + 1] = (char) (i + '0');
            PrintOneToMaxNRecu(number, length, index + 1);
        }
    }


    public static void main(String[] args) {

        printOneToMaxOfNDigits(2);

        /*System.out.println(Integer.MAX_VALUE);
        System.out.println((Integer.MAX_VALUE + "").length());
        System.out.println(Long.MAX_VALUE);
        System.out.println((Long.MAX_VALUE + "").length());
        String str = String.valueOf("12345");
        System.out.println(str);*/
    }


}
