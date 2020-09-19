package a_swordoffer.a25_merge_linkedlists;

import a_swordoffer.a00_datastructure.ListNode;

/**
 * 合并两个有序的链表
 * head1: 1-->3-->5-->6--->7
 * head2: 2-->4-->6-->8
 * result: 1-->2-->3-->4-->5-->6-->6-->7-->8
 */
public class MergeTwoLinkedList {
    /**
     * 自己写的非递归的实现
     *
     * @param head1
     * @param head2
     * @return
     */
    private static ListNode mergeTwoLinkedList(ListNode head1, ListNode head2) {
        if (head1 == null) {
            return head2;
        }
        if (head2 == null) {
            return head1;
        }
        ListNode currentNodeFromHead1 = head1;
        ListNode currentNodeFromHead2 = head2;

        ListNode mergedHead = null;
        //找到Merge后的头节点
        if (currentNodeFromHead1.val > currentNodeFromHead2.val) {
            mergedHead = currentNodeFromHead2;
            currentNodeFromHead2 = currentNodeFromHead2.next;
        } else {
            mergedHead = currentNodeFromHead1;
            currentNodeFromHead1 = currentNodeFromHead1.next;
        }

        //merge
        ListNode node = mergedHead;
        while (currentNodeFromHead1 != null && currentNodeFromHead2 != null) {
            if (currentNodeFromHead1.val > currentNodeFromHead2.val) {
                node.next = currentNodeFromHead2;
                currentNodeFromHead2 = currentNodeFromHead2.next;
            } else {
                node.next = currentNodeFromHead1;
                currentNodeFromHead1 = currentNodeFromHead1.next;
            }
            node = node.next;
        }
        //连接上还未merge的链表
        node.next = currentNodeFromHead1 == null ? currentNodeFromHead2 : currentNodeFromHead1;

        return mergedHead;
    }

    /**
     * 剑指Offer上的递归的实现
     *
     * @param head1
     * @param head2
     * @return
     */
    private static ListNode mergeTwoLinkedList2(ListNode head1, ListNode head2) {
        if (head1 == null) {
            return head2;
        }
        if (head2 == null) {
            return head1;
        }

        //递归
        ListNode mergedHead = null;
        if (head1.val < head2.val) {
            mergedHead = head1;
            mergedHead.next = mergeTwoLinkedList2(head1.next, head2);
        } else {
            mergedHead = head2;
            mergedHead.next = mergeTwoLinkedList2(head1, head2.next);
        }

        return mergedHead;
    }


    //test
    public static void main(String[] args) {
        ListNode head1 = new ListNode(1);
        ListNode temp = head1;
        for (int i = 3; i < 10; i += 2) {
            temp.next = new ListNode(i);
            temp = temp.next;
        }
        printList(head1);

        ListNode head2 = new ListNode(2);
        temp = head2;
        for (int i = 4; i <= 10; i += 2) {
            temp.next = new ListNode(i);
            temp = temp.next;
        }
        printList(head2);

        //MERGE 1
        ListNode mergeTwoLinkedList = mergeTwoLinkedList(head1, head2);
        printList(mergeTwoLinkedList);

        System.out.println("========================================================");

        head1 = new ListNode(1);
        temp = head1;
        for (int i = 3; i < 10; i += 2) {
            temp.next = new ListNode(i);
            temp = temp.next;
        }
        printList(head1);

        head2 = new ListNode(2);
        temp = head2;
        for (int i = 4; i <= 10; i += 2) {
            temp.next = new ListNode(i);
            temp = temp.next;
        }
        printList(head2);
        //MERGE 2
        ListNode mergeTwoLinkedList2 = mergeTwoLinkedList2(head1, head2);
        printList(mergeTwoLinkedList2);
    }

    private static void printList(ListNode head) {
        while (head != null) {
            if (head.next != null)
                System.out.print(head.val + " --> ");
            else
                System.out.println(head.val);
            head = head.next;
        }
    }
}
