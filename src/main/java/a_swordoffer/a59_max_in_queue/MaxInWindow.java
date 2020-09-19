package a_swordoffer.a59_max_in_queue;


import java.util.*;

/**
 * @program: swordofferjava
 * @description: 滑动窗口的最大值
 * @author: Jin Hongjian
 * @create: 2020-09-19
 **/
public class MaxInWindow {

    /**
     * 滑动串口类似于队列，不过其中的元素个数是固定的，进去一个就意味着最开始进去那里马上出来，因此问题可以转化为求一个队列中的最大值
     * 为了方便判断是否超过窗口长度，队列中并不保存真实的数据，而是保存数值的索引
     *
     * @param num  数组
     * @param size 窗口长度
     * @return
     */
    static ArrayList<Integer> maxInWindow(int[] num, int size) {
        ArrayList<Integer> res = new ArrayList<>();
        if (num != null && num.length >= size && size > 0) {
            Deque<Integer> indexDeque = new LinkedList<>();
            //前size个数
            for (int i = 0; i < size; i++) {
                while (!indexDeque.isEmpty() && num[i] >= num[indexDeque.peekLast()]) {
                    indexDeque.pollLast();
                }
                indexDeque.offerLast(i);
            }
            //size索引后的数
            for (int i = size; i < num.length; i++) { //这里会处理 length-size 个结果， 最后的结果是length-size+1个
                res.add(num[indexDeque.peekFirst()]); //每次来一个数，先把之前一个串口的最大值写到结果集中
                while (!indexDeque.isEmpty() && num[i] >= num[indexDeque.peekLast()]) { //把队列后面的不可能成为最大值的数poll拿走
                    indexDeque.pollLast();
                }
                if (!indexDeque.isEmpty() && indexDeque.peekFirst() <= i - size) { //把前面已经处于窗口之外的索引poll出来
                    indexDeque.pollFirst();
                }
                indexDeque.offerLast(i); //然后把当前索引放进去
            }
            res.add(num[indexDeque.peekFirst()]); //把最后一个数拿出来
        }
        return res;
    }

    public static void main(String[] args) {
/*        Deque<Integer> deque = new LinkedList<>();
        for (int i = 1; i < 5; i++) {
            deque.add(i);
        }
        System.out.println(deque.element());
        System.out.println(deque.peek());
        System.out.println(deque.peekFirst());
        System.out.println(deque.peekLast());*/
        //int[] array = new int[]{2, 3, 4, 2, 6, 2, 5, 1};
        int[] array = new int[]{16, 14, 12, 10, 8, 6, 4};
        ArrayList<Integer> integers = maxInWindow(array, 1);
        for (Integer integer : integers) {
            System.out.print(integer + " ");
        }

    }

}
