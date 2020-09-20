package a_swordoffer.a19_regex_match;

import java.util.Arrays;

/**
 * @program: swordofferjava
 * @description: 正则表达式匹配
 * @author: Jin Hongjian
 * @create: 2020-09-20
 **/
public class RegexMatch {

    static boolean match(String str, String pattern) {
        if (str == null || pattern == null) {
            return false;
        }
        char[] strChars = new char[str.length() + 1];
        char[] patternChars = new char[pattern.length() + 1];
        if (str.length() > 0) {
            System.arraycopy(str.toCharArray(), 0, strChars, 0, str.length());
        }
        if (pattern.length() > 0) {
            System.arraycopy(pattern.toCharArray(), 0, patternChars, 0, pattern.length());
        }
        strChars[str.length()] = '\0'; //最后追加一个字符串结束符，便可以使用剑指offer的解法，不需要频繁判断长度，也类似于一个哨兵
        patternChars[pattern.length()] = '\0';
        return matchCore(strChars, 0, patternChars, 0);
    }

    private static boolean matchCore(char[] str, int strIndex, char[] pattern, int patternIndex) {
        if (str[strIndex] == '\0' && pattern[patternIndex] == '\0') { //两个串都匹配到了最后，返回true
            return true;
        }
        if (str[strIndex] != '\0' && pattern[patternIndex] == '\0') { //正则匹配到了最后，str还没有匹配完成，返回false
            return false;
        }
        if (pattern[patternIndex + 1] == '*') { //正则下一个字符为*的情况
            //这里表示当前字符完全匹配，或者str匹配了正则的一个 . , 那么后面有三种匹配方式可供选择：
            if (pattern[patternIndex] == str[strIndex] || (pattern[patternIndex] == '.' && str[strIndex] != '\0')) {
                return matchCore(str, strIndex + 1, pattern, patternIndex + 2) //第一种方式， str的 x 字符清除表达式的 x* 或者 .* 字符，继续往后匹配
                        || matchCore(str, strIndex + 1, pattern, patternIndex) //第二种方式， 由于正则是 x* 或者 .* , 可以选择吸收str的 x 字符，继续往后匹配
                        || matchCore(str, strIndex, pattern, patternIndex + 2);  //第二种方式， 由于正则是 x* 或者 .* ，可以选择忽略这两个匹配字符，继续往后匹配
            } else { //这里表示当前字符不匹配，那么忽略正则的  x* 或者 .* ， 继续匹配
                return matchCore(str, strIndex, pattern, patternIndex + 2);
            }
        }
        //正则下一个字符不为*的情况， 正常后移一个字符继续匹配
        if (pattern[patternIndex] == str[strIndex] || (pattern[patternIndex] == '.' && str[strIndex] != '\0')) {
            return matchCore(str, strIndex + 1, pattern, patternIndex + 1);
        }
        //都不是，返回false
        return false;
    }

    public static void main(String[] args) {
        String str = "aaa";
        String pattern1 = "a.a";
        String pattern2 = "ab*ac*a";
        String pattern3 = "aa.a";
        String pattern4 = "ab*a";

        System.out.println(match(str, pattern1));
        System.out.println(match(str, pattern2));
        System.out.println(match(str, pattern3));
        System.out.println(match(str, pattern4));
        String str1 = "";
        String pattern11 = ".*";
        System.out.println(match(str1, pattern11));
    }

}
