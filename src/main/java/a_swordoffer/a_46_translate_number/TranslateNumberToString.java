package a_swordoffer.a_46_translate_number;

import netscape.security.UserTarget;

/**
 * 把数字翻译成字符串，问给定一个数字，有多少种翻译方法
 */
public class TranslateNumberToString {
    static int getKindsOfTranslate(int number) {
        if (number < 0)
            return 0;
        //递归结束条件
        if (number < 10)  //0-9
            return 1;
        if (number < 26) //10-25
            return 2;
        if (number < 100) //26-99
            return 1;
        //三位数，递归
        String numString = number + "";
        int firstTwo = Integer.parseInt(numString.substring(0, 2));
        if (firstTwo < 26)
            return getKindsOfTranslate(Integer.parseInt(numString.substring(2))) + getKindsOfTranslate(Integer.parseInt(numString.substring(1)));
        else
            return getKindsOfTranslate(Integer.parseInt(numString.substring(1)));
    }

    public static void main(String[] args) {
        System.out.println(getKindsOfTranslate(12258));
    }
}
