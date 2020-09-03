package b2_sort;

import java.util.*;

/**
 * @program: swordofferjava
 * @description: 桶排序
 * @author: Jin Hongjian
 * @create: 2020-09-03
 **/
public class BucketSort {

    static void bucketSort(float[] arr) {
        if (arr == null) {
            return;
        }
        ArrayList<LinkedList<Float>> buckets = new ArrayList<LinkedList<Float>>();
        for (int i = 0; i < 10; i++) { //分桶得看具体数据分布
            // 新建一个桶，并将其添加到桶的集合中去。
            // 由于桶内元素会频繁的插入，所以选择 LinkedList 作为桶的数据结构
            buckets.add(new LinkedList<>());
        }
        // 将输入数据全部放入桶中并完成排序
        for (float data : arr) {
            int index = (int) data; //桶的序号
            insertSort(buckets.get(index), data);
        }
        // 将桶中元素全部取出来并放入 arr 中输出
        int index = 0;
        for (LinkedList<Float> bucket : buckets) {
            for (Float data : bucket) {
                arr[index++] = data;
            }
        }

    }

    /**
     * 选择插入排序作为桶内元素排序的方法 每当有一个新元素到来时，我们都调用该方法将其插入到恰当的位置
     */
    public static void insertSort(List<Float> bucket, float data) {
        ListIterator<Float> it = bucket.listIterator();
        boolean insertFlag = true;
        while (it.hasNext()) {
            if (data <= it.next()) {
                it.previous(); // 把迭代器的位置偏移回上一个位置
                it.add(data); // 把数据插入到迭代器的当前位置
                insertFlag = false;
                break;
            }
        }
        if (insertFlag) {
            bucket.add(data); // 否则把数据插入到链表末端
        }
    }


    public static void main(String[] args) {
        float[] arr = new float[]{0.12f, 2.2f, 8.8f, 7.6f, 7.2f, 6.3f, 9.0f, 1.6f, 5.6f, 2.4f};
        bucketSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
