package a_swordoffer.a58_reverse_string;

/**
 * @program: swordofferjava
 * @description: 翻转字符串
 * 例如 I am a student. 翻转为
 * student. a am I
 * @author: Jin Hongjian
 * @create: 2020-09-19
 **/
public class ReverseString {
    /*更简单的方法，切割拼接*/
    static String reverseString2(String str) {
        if (str == null) {
            return null;
        }
        String[] s = str.split(" ", -1); //注意这里必须要有-1
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = s.length - 1; i > 0; i--) {
            stringBuilder.append(s[i]).append(' ');
        }
        stringBuilder.append(s[0]);
        return stringBuilder.toString();
    }


    /*剑指offer思路
     * 先翻转整个字符串，然后在翻转字符串的基础上翻转每个单词
     * */
    static void reverseChars(char string[], int start, int end) {
        while (start < end) {
            char temp = string[start];
            string[start] = string[end];
            string[end] = temp;
            start++;
            end--;
        }
    }

    static String reverseString(String str) {
        if (str == null) {
            return null;
        }
        char[] chars = str.toCharArray();
        reverseChars(chars, 0, str.length() - 1);
        int start = 0;
        int end = -1;
        while (start < chars.length) {
            end++;
            start = end;
            while (end < chars.length) {
                if (chars[end] != ' ') {
                    end++;
                } else {
                    break;
                }
            }
            int reverseEnd = end >= chars.length ? chars.length - 1 : end - 1;
            reverseChars(chars, start, reverseEnd);
        }
        return new String(chars);
    }


    public static void main(String[] args) {
        String a = "I am a student.";
        String res = reverseString(a);
        System.out.println(res);
    }
}
