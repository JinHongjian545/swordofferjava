import java.lang.reflect.Array;
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
        int i = Integer.MAX_VALUE;
        System.out.println(i);
        //Exception in thread "main" java.lang.OutOfMemoryError: Requested array size exceeds VM limit
        int[] arr = new int[i];
        arr[i - 1] = 5;
        System.out.println(arr[i - 1]);
    }
}
