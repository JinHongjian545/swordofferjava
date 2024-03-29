package a_swordoffer.a18_delete_listnode;

import a_swordoffer.a00_datastructure.ListNode;

/**
 * 使用O（1）的时间删除节点：
 * 思路：当前节点保存下一节点的值，删除下一节点
 */
public class DeleteNode {
    private static void deleteNode(ListNode head, ListNode target) {
        if (head == null || target == null) {
            return;
        }
        //target是尾节点
        if (target.next == null) {
            if (target == head) { //也是头节点
                head = null;
            } else { //遍历
                while (head != null) {
                    if (head.next == target) {
                        head.next = null;
                        return;
                    } else {
                        head = head.next;
                    }
                }
            }
        } else {
            target.val = target.next.val;
            target.next = target.next.next;
        }
    }

    public static void main(String[] args) {
        ListNode[] nodes = new ListNode[11];
        nodes[0] = new ListNode(0);
        for (int i = 0; i <= 9; i++) {
            nodes[i+1] = new ListNode(i+1);
            nodes[i].next = nodes[i+1];
        }

        ListNode head = nodes[0];
        ListNode.printList(head);

        deleteNode(head, nodes[5]);
        ListNode.printList(head);

        deleteNode(head, nodes[10]);
        ListNode.printList(head);
    }
}
