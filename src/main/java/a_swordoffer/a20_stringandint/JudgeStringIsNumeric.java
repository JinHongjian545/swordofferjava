package a_swordoffer.a20_stringandint;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @program: swordofferjava
 * @description: 判断字符串是不是数字
 * @author: Jin Hongjian
 * @create: 2020-07-14
 **/
public class JudgeStringIsNumeric {

    //使用正则表达式
    private static boolean isNumeric(String string) {
        if (string == null || string.isEmpty()) {
            return false;
        }
        String regExp = "[+-]?(\\d+)?(\\.\\d+)?([eE][+-]?\\d+)?";

        Pattern compile = Pattern.compile(regExp);
        Matcher matcher = compile.matcher(string);

        return matcher.find() && matcher.group(0).equals(string);
    }

    public static void main(String[] args) {
        String s = "+100\n" +
                "-100\n" +
                "5e2\n" +
                ".234234\n" +
                ".\n" +
                "  \n" +
                " \n" +
                "-.123\n" +
                "-123\n" +
                "3.1456\n" +
                "3.1456e\n" +
                "3.1456e-2\n" +
                "-3.1456e-2\n" +
                "-1e-6\n" +
                "-1E12\n" +
                "asd\n" +
                "1qsd\n" +
                "12e\n" +
                "1a3.14\n" +
                "1.2.3\n" +
                "+-5\n" +
                "12e+5.4";

        String[] split = s.split("\\n");
        for (String s1 : split) {
            System.out.println(s1 + ": " + isNumeric(s1));
        }

    }

}
