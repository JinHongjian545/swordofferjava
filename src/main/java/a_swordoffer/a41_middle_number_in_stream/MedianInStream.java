package a_swordoffer.a41_middle_number_in_stream;

import java.util.PriorityQueue;

/**
 * @program: swordofferjava
 * @description: 数据流中的中位数
 * @author: Jin Hongjian
 * @create: 2020-07-26
 **/
public class MedianInStream {

    private static PriorityQueue<Integer> minHeap = new PriorityQueue<>(); //默认就是小顶堆; 小顶堆，所有元素都 大于等于 堆顶元素
    private static PriorityQueue<Integer> maxHeap = new PriorityQueue<>(((o1, o2) -> o2 - o1)); //大顶堆，所有元素都 小于等于 堆顶元素
    private static long intNumber = 0;

    //读取数据流
    private static void insert(int num) {
        intNumber++;
        Integer maxPeek = maxHeap.peek();
        Integer minPeek = minHeap.peek();
        if (intNumber % 2 == 1) { //第奇数个数据插入时，放到最大堆中，如第1,3,5个数
            if (minPeek != null && num > minPeek) { //如果来的这个数比最小堆中的数还要大的话，则需要把最小堆堆顶元素取过来
                minPeek = minHeap.poll();
                minHeap.offer(num);
                maxHeap.offer(minPeek);
            } else {
                maxHeap.offer(num);
            }
        } else { //第偶数个数据插入时，放到最小堆中，如第2,4,6个数
            if (num < maxPeek) {
                maxPeek = maxHeap.poll();
                maxHeap.offer(num);
                minHeap.offer(maxPeek);
            } else {
                minHeap.offer(num);
            }
        }
    }

    private static Double getMedian() {
        if (intNumber == 0) {
            return null;
        }
        if (intNumber % 2 == 1) { //一共奇数个数时，直接取大顶堆堆顶元素
            return maxHeap.peek().doubleValue();
        } else { //一共偶数个数时，取大顶堆堆顶元素和小顶堆堆顶元素平均值
            return (maxHeap.peek().doubleValue() + minHeap.peek().doubleValue()) / 2;
        }
    }

    public static void main(String[] args) {
        System.out.println(getMedian());
        insert(3);
        System.out.println(getMedian());
        insert(5);
        System.out.println(getMedian());
        insert(13);
        System.out.println(getMedian());
        insert(8);
        System.out.println(getMedian());
        insert(9);
        System.out.println(getMedian());
    }
}
