package a_swordoffer.a22_Kth_node_in_linkedlist;

public class KthNodeToTail {
    /**
     * 查找链表中的倒数第 k 个节点， k = 3 时，返回节点 8
     * 1 --> 2 --> 3 --> 4 --> 5 --> 6 --> 7 --> 8 --> 9 --> 10
     * slow         fast
     * 思路：
     * 在链表中查找节点的典型思路，双指针（快慢指针）遍历法
     *
     * @param head
     * @param k
     */
    private static ListNode findKthNodeToTail(ListNode head, int k) {
        if (k <= 0) {
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;
        for (int i = 1; i < k; i++) {
            if (fast == null) {
                return null;
            }
            fast = fast.next;
        }
        if (fast == null) {
            return null;
        }
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode temp = head;
        for (int i = 2; i <= 10; i++) {
            temp.next = new ListNode(i);
            temp = temp.next;
        }

        ListNode.printList(head);

        System.out.println(findKthNodeToTail(head, 1));
        System.out.println(findKthNodeToTail(head, 3));
        System.out.println(findKthNodeToTail(head, 6));
        System.out.println(findKthNodeToTail(head, 10));
        System.out.println(findKthNodeToTail(head, 11));
        System.out.println(findKthNodeToTail(head, 15));
    }

}
