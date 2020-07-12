package e_scanner_input;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @program: swordofferjava
 * @description:
 * @author: Jin Hongjian
 * @create: 2020-07-12
 **/
public class ScannerInfiniteInput {

    /**
     * 测试无线输入，类似于, 可以有无线多行，来自字节笔试题
     * EFIWUEFGSDFSDJH SDFSD
     * ASDASJHJKEHFE DWES
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> results = new ArrayList<>();
        String line;
        while (!(line = scanner.nextLine()).isEmpty()) {
            int index = line.indexOf(' ');
            results.add(doSomething(line.substring(0, index), line.substring(index + 1)));
        }

        System.out.println(results);
    }

    private static String doSomething(String string1, String string2) {
        return string1 + string2;
    }
}
