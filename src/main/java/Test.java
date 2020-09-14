import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @program: swordofferjava
 * @description:
 * @author: Jin Hongjian
 * @create: 2020-09-07
 **/
public class Test {
    public static void main(String[] args) {
        Object o = new Object();
        ArrayList<String> arrayList = new ArrayList<>();

        List<String> synchronizedList = Collections.synchronizedList(arrayList);

    }
}
