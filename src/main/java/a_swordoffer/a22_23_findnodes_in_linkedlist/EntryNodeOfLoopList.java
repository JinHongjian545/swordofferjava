package a_swordoffer.a22_23_findnodes_in_linkedlist;

public class EntryNodeOfLoopList {
    /**
     * 找到链表中环的入口节点, 思路：
     * 分为如下步骤：
     * 1、找到快慢指针的相遇节点，如果快指针遍历到空，直接返回null，不存在环 （找到环）
     * 2、通过相遇节点遍历一圈，得到环中节点的个数 n （2、3步：找到入口节点）
     * 3、一个指针先走 n 步，然后另一指针从头开始一起走，当两者相遇时，相遇的节点即为入口节点
     *
     * @return
     */
    private static ListNode findEntryNode(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode meetNode = findMeetingNode(head);
        if (meetNode == null) {
            return null;
        }
        //计算环中节点个数
        int count = 1;
        ListNode node = meetNode.next;
        while (node != meetNode) {
            node = node.next;
            count++;
        }
        //双指针遍历找到环的入口节点
        ListNode fast = head; //走在前面的指针，并不是指速度快的指针
        ListNode slow = head; //走在后面的指针
        for (int i = 0; i < count; i++) { //先走 n 步
            fast = fast.next;
        }
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }

    /**
     * 找到环中的一个节点，或不存在环则返回null
     *
     * @param head
     * @return
     */
    private static ListNode findMeetingNode(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return fast;
            }
        }
        return null; //循环结束出来说明没有相遇节点
    }

    public static void main(String[] args) {
        ListNode[] nodes = new ListNode[10];
        for (int i = 0; i < 10; i++) {
            nodes[i] = new ListNode(i);
        }
        for (int i = 0; i < 9; i++) {
            nodes[i].next = nodes[i + 1];
        }

        ListNode.printList(nodes[0]);
        System.out.println(findEntryNode(nodes[0]));

        nodes[9].next = nodes[9]; //环
        System.out.println(findEntryNode(nodes[0]));

//        ListNode.printList(nodes[0]);

        System.out.println();


    }
}
