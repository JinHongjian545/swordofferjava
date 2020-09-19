package a_swordoffer.a24_reverse_linkedlist;


import a_swordoffer.a00_datastructure.ListNode;

import java.util.LinkedList;

/**
 * 反转链表
 */
public class ReverseLinkedListByGroup {
       /**
     * 反转链表，每 k 个节点反转一次，不足 k 就保持原有顺序，k=3时
     * 实现方式1 使用计数器直接反转, k = 3 时，要求结果:
     * 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> 8
     * 3 -> 2 -> 1 -> 6 -> 5 -> 4 -> 7 -> 8
     *
     * @param head
     * @return
     */
    private static ListNode reverseLinkedListInKNodes(ListNode head, int k) {
        if (head == null || head.next == null || k <= 1) {
            return head;
        }
        //获取k个元素的首尾节点，head为首，CNode遍历到尾
        ListNode cNode = head;
        for (int i = 1; i < k; i++) { //注意这里已经有一个head了，只需要在往后 遍历k-1个
            cNode = cNode.next;
            //不够k个则返回
            if (cNode == null) {
                return head;
            }
        }
        //先保存下一节点然后局部反转
        ListNode next = cNode.next;
        reverseNodes(head, cNode);
        //递归反转剩下的部分，连到本来的head后面！！！
        head.next = reverseLinkedListInKNodes(next, k);
        //直接返回cNode,因为反转后一个组的最后一个节点就是头结点了
        return cNode;
    }

    //递归反转的局部函数
    private static void reverseNodes(ListNode head, ListNode tail) {
        if (head == null || head.next == null) {
            return;
        }
        ListNode reversedLast = null;
        ListNode unReversedFirst = head;
        ListNode currentNode;
        ListNode end = tail.next;
        while (unReversedFirst != end) { //注意下面这几次交换和赋值的顺序不能变
            currentNode = unReversedFirst;
            unReversedFirst = unReversedFirst.next;
            currentNode.next = reversedLast;
            reversedLast = currentNode;
        }
    }

    /**
     * 反转链表，每 k 个节点反转一次，不足 k 就保持原有顺序
     * 实现方式2 使用栈来实现，但是这里用LinkedList来模拟栈，方便最后像队列一样拿取数据
     *
     * @param head
     * @return
     */
    private static ListNode reverseLinkedListInKNodesByStack(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        LinkedList<ListNode> list = new LinkedList<>();
        ListNode reversedHead = null; //反转后的链表头
        ListNode reverseNode = null;
        while (head != null) {
            list.push(head);
            head = head.next;
            if (list.size() == k) {
                while (!list.isEmpty()) {
                    if (reversedHead == null) {
                        reversedHead = list.pop();
                        reverseNode = reversedHead;
                    } else {
                        reverseNode.next = list.pop();
                        reverseNode = reverseNode.next;
                    }
                    reverseNode.next = null; //注意这里，切断新旧链表联系，防止出现环形链表导致死循环
                }
            }
        }
        while (!list.isEmpty() && reverseNode != null) {
            reverseNode.next = list.pollLast();
            reverseNode = reverseNode.next;
            reverseNode.next = null;
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

/*        //基于栈的k反转
        ListNode reversedHead3 = reverseLinkedListInKNodesByStack(head, 4);
        printList(reversedHead3);*/
        //直接的k反转
        ListNode reversedHead = reverseLinkedListInKNodes(head, 6);
        printList(reversedHead);
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


