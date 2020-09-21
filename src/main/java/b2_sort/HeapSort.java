package b2_sort;

import java.util.Arrays;

/**
 * @program: swordofferjava
 * @description: 堆排序
 * 堆排序的基本思想是：将待排序序列构造成一个大顶堆，此时，整个序列的最大值就是堆顶的根节点。将其与末尾元素进行交换，此时末尾就为最大值。
 * 然后将剩余n-1个元素重新构造成一个堆，这样会得到n个元素的次小值。如此反复执行，便能得到一个有序序列了
 * <p>
 * !!! 参考： https://blog.csdn.net/u010452388/article/details/81283998
 * @author: Jin Hongjian
 * @create: 2020-09-03
 **/
public class HeapSort {

    public static void heapSort(int[] arr) {
        if (arr == null) {
            return;
        }
        buildHeap(arr);
        int size = arr.length;
        while (size > 1) {
            swap(arr, 0, size - 1);
            size--;
            //在交换后重新调整堆，此时size外的数据已经有序，不再更新
            heapify(arr, size);
        }
    }

    //构造大顶堆 （一般升序采用大顶堆，降序采用小顶堆) bottom -> top
    private static void buildHeap(int[] arr) {
        int currentIndex, fatherIndex;
        for (int i = 0; i < arr.length; i++) {
            currentIndex = i;
            fatherIndex = (i - 1) / 2;
            //如果当前插入的值大于其父结点的值,则交换值，并且将索引指向父结点
            //然后继续和上面的父结点值比较，直到不大于父结点，则退出循环
            while (arr[currentIndex] > arr[fatherIndex]) {
                swap(arr, currentIndex, fatherIndex);
                currentIndex = fatherIndex;
                fatherIndex = (currentIndex - 1) / 2;
            }
        }
    }

    //将剩余的数构造成大根堆（通过顶端的数下降） top -> bottom
    private static void heapify(int[] arr, int size) {
        int index = 0, left = 1, right = 2;
        int largeIndex;
        while (left < size) {
            //这个if-else找到左右孩子节点中更大的节点索引，访问右子节点时需要确保right索引在size范围内
            if (arr[left] < arr[right] && right < size) {
                largeIndex = right;
            } else {
                largeIndex = left;
            }
            //下面这两个这个if-else判断当前父节点是不是本来就比子节点最的较大值更大，如果是则已经是大顶推，结束循环
            if (arr[index] > arr[largeIndex]) {
                largeIndex = index;
            }
            if (index == largeIndex) {
                break;
            }
            //当前父节点值小于孩子节点的较大值，交换两者，并更新索引对交换下来的值继续循环判断
            swap(arr, largeIndex, index);
            index = largeIndex;
            left = 2 * index + 1;
            right = left + 1;
        }
    }

    private static void swap(int[] arr, int index1, int index2) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }


    public static void main(String[] args) {
        int[] nums = new int[]{3, 18, 11, 7, 66, 7, 8, 17, 32, 5, 19, 27, 12, 9, 13, 22, 4};
        heapSort(nums);
        System.out.println(Arrays.toString(nums));
    }

}
