package a_swordoffer.a24_reverse_linkedlist;


import a_swordoffer.a00_datastructure.ListNode;

import java.util.Stack;

/**
 * 反转链表
 */
public class ReverseLinkedList {
    /**
     * 反转链表，使用常数额外空间, 如可以使用任意额外空间的话直接使用栈存储一下
     *
     * @param head
     * @return
     */
    public static ListNode reverseLinkedList(ListNode head) {
        //这个reversedLast因为链表反转后指向相反，因此reversedLast就是reversedHead，直接返回即可
        ListNode reversedLast = null;
        ListNode unReversedFirst = head;
        ListNode currentNode;
        while (unReversedFirst != null) { //注意下面这几次交换和赋值的顺序不能变
            currentNode = unReversedFirst;
            unReversedFirst = unReversedFirst.next;
            currentNode.next = reversedLast;
            reversedLast = currentNode;
        }
        return reversedLast;
    }

    /**
     * 反转链表，使用栈来做临时存储
     *
     * @param head
     * @return
     */
    private static ListNode reverseLinkedListByStack(ListNode head) {
        if (head == null) {
            return null;
        }
        Stack<ListNode> stack = new Stack<ListNode>();
        ListNode node1 = null;
        while (head != null) {
            node1 = head;
            stack.push(head);
            head = head.next;
            node1.next = null; //注意此处，需要切断原链表之间的联系，否则会形成环形链表
        }

        ListNode reversedHead = stack.pop();
        ListNode node = reversedHead;
        while (!stack.empty()) {
            node.next = stack.pop();
            node = node.next;
        }
        return reversedHead;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode temp = head;
        for (int i = 2; i <= 10; i++) {
            temp.next = new ListNode(i);
            temp = temp.next;
        }

        //输出
        printList(head);
        //反转
        ListNode reversedHead = reverseLinkedList(head);
        printList(reversedHead);

        //基于栈的反转
        ListNode reversedHead2 = reverseLinkedListByStack(reversedHead);
        printList(reversedHead2);

    }

    static void printList(ListNode head) {
        while (head != null) {
            if (head.next != null)
                System.out.print(head.val + " --> ");
            else
                System.out.println(head.val);
            head = head.next;
        }
    }

}


