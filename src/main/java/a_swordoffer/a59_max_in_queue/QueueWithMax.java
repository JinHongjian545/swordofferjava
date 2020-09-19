package a_swordoffer.a59_max_in_queue;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Deque;

/**
 * @program: swordofferjava
 * @description: 包含max函数的最大值
 * @author: Jin Hongjian
 * @create: 2020-09-19
 **/
public class QueueWithMax {
    private ArrayDeque<InternalData> data;
    private ArrayDeque<InternalData> maxes;
    private int currentIndex;

    /**
     * 使用一个内部类，添加一个index字段，来表示数据插入到队列中的顺序，方便在data和maxes中进行数据同步
     */
    private class InternalData {
        int number;
        int index;

        public InternalData(int number, int index) {
            this.number = number;
            this.index = index;
        }
    }

    public QueueWithMax() {
        this.data = new ArrayDeque<>();
        this.maxes = new ArrayDeque<>();
        currentIndex = 0;
    }

    /**
     * 项队列尾部添加数据
     *
     * @param number 数据
     */
    public void push_back(int number) {
        InternalData currentData = new InternalData(number, currentIndex);
        data.offerLast(currentData);

        while (!maxes.isEmpty() && number >= maxes.peekLast().number) { //如果number>maxes.peekLast().number 则只要有number在，maxes.peekLast().number就不可能是最大值
            maxes.pollLast();
        }
        maxes.offerLast(currentData);
        currentIndex++;
    }


    /**
     * 从队列前端取数据
     *
     * @return
     */
    public int pop_front() {
        if (data.isEmpty()) {
            throw new RuntimeException("Empty queue");
        }
        InternalData internalData = data.pollFirst();
        if (internalData.index == maxes.peekFirst().index) {  //如果data里的这个数被poll出去了，要同步把maxes里的最大值poll出去
            maxes.pollFirst();
        }
        return internalData.number;
    }

    public int max() {
        if (maxes.isEmpty()) {
            throw new RuntimeException("Empty queue");
        }
        return maxes.peekFirst().number;
    }

    public boolean isEmpty() {
        return data.isEmpty();
    }


    public static void main(String[] args) {
        //tests
        QueueWithMax queueWithMax = new QueueWithMax();
        int[] array = new int[]{2, 3, 4, 2, 6, 2, 5, 1};
        for (int i = 0; i < 8; i++) {
            queueWithMax.push_back(array[i]);
        }

        for (int i = 0; i < 8; i++) {
            System.out.print(queueWithMax.max() + " ");
            System.out.print(queueWithMax.pop_front() + "\n");
        }


    }
}
