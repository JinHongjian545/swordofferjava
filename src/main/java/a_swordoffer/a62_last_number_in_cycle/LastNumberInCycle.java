package a_swordoffer.a62_last_number_in_cycle;

import java.util.LinkedList;
import java.util.ListIterator;

/**
 * 0~n-1 一共n个数字拍成圆圈，从数字0开始，每次从这个圆圈里删除第m个数字，求最后一个数字
 */
public class LastNumberInCycle {
    /*使用LinkedList构造环形链表*/
    static int lastRemaining(int n, int m) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            linkedList.add(i);
        }
        int count = 0;
        int dif = m - 1;
        while (linkedList.size() > 1) {
            count = (count + dif) % linkedList.size();  //注意此处的求余
            linkedList.remove(count);
        }
        return linkedList.getFirst();
    }

    public static void main(String[] args) {
        System.out.println(lastRemaining(5, 3));
    }
}
