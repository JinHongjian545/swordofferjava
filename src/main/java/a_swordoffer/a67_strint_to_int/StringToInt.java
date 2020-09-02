package a_swordoffer.a67_strint_to_int;

public class StringToInt {
    public static int stringToInt(String string) {
        if (string == null) {
            throw new RuntimeException("Invalid input");
        }
        //注意正负值
        boolean minus = false;
        if (string.startsWith("+")) {
            string = string.substring(1);
        }
        if (string.startsWith("-")) {
            string = string.substring(1);
            minus = true;
        }
        if (string.isEmpty()) {
            throw new RuntimeException("Invalid input");
        }

        int result = 0;
        int base = 1;
        for (int i = string.length() - 1; i >= 0; i--) {
            if (string.charAt(i) > '9' || string.charAt(i) < '0') {
                throw new RuntimeException("Invalid input");
            }
            result += (string.charAt(i) - '0') * base;
            base = base * 10;
        }

        return minus ? -result : result;
    }

    public static void main(String[] args) {
        try {
            System.out.println(stringToInt("12412"));
        } catch (Exception ignored) {
            System.out.println("Exception");
        }
        try {
            System.out.println(stringToInt(""));
        } catch (Exception ignored) {
            System.out.println("Exception");
        }
        try {
            System.out.println(stringToInt("+12412"));
        } catch (Exception ignored) {
            System.out.println("Exception");
        }
        try {
            System.out.println(stringToInt("-124122515"));
        } catch (Exception ignored) {
            System.out.println("Exception");
        }
        try {
            System.out.println(stringToInt("--124122515"));
        } catch (Exception ignored) {
            System.out.println("Exception");
        }
        try {
            System.out.println(stringToInt("+"));
        } catch (Exception ignored) {
            System.out.println("Exception");
        }
        try {
            System.out.println(stringToInt("-"));
        } catch (Exception ignored) {
            System.out.println("Exception");
        }
        try {
            System.out.println(stringToInt(""));
        } catch (Exception ignored) {
            System.out.println("Exception");
        }
        try {
            System.out.println(stringToInt(null));
        } catch (Exception ignored) {
            System.out.println("Exception");
        }
    }
}
