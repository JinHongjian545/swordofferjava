package a_swordoffer.a52_publicNode;

import a_swordoffer.a00_datastructure.ListNode;

import java.util.HashSet;
import java.util.Set;

public class PublicNodeOfLinkedList {
    //基于先获取长度，然后先走再一起走的方式 O(n+m) + O(n+m)
    public static ListNode firstPublicNode(ListNode pHead1, ListNode pHead2) {
        if (pHead1 == null || pHead2 == null) {
            return null;
        }
        //可以基于栈去做，也可以通过遍历获取长度差然后先走的方式去做
        ListNode head1 = pHead1;
        ListNode head2 = pHead2;
        int len1 = 0;
        int len2 = 0;
        while (head1 != null) {
            len1++;
            head1 = head1.next;
        }
        while (head2 != null) {
            len2++;
            head2 = head2.next;
        }

        //长的先走 |len1 - len2| 个节点, 让head1指向长的链表，head2指向短的链表
        if (len1 > len2) {
            head1 = pHead1;
            head2 = pHead2;
        } else {
            head1 = pHead2;
            head2 = pHead1;
        }
        for (int i = 0; i < Math.abs(len1 - len2); i++) {
            head1 = head1.next;
        }
        //然后找公共节点
        while (head1 != null && head2 != null && head1 != head2) {
            head1 = head1.next;
            head2 = head2.next;
        }
        return head1;
    }

    //基于HashSet做
    public static ListNode firstPublicNode2(ListNode pHead1, ListNode pHead2) {
        if (pHead1 == null || pHead2 == null) {
            return null;
        }
        //先把pHead1中的所有节点放进去，然后处理pHead2
        ListNode head1 = pHead1;
        ListNode head2 = pHead2;
        Set<ListNode> set = new HashSet<>();
        while (head1 != null) {
            set.add(head1);
            head1 = head1.next;
        }
        //找到相同节点
        while (head2 != null) {
            if (set.contains(head2)) {
                return head2;
            }
            head2 = head2.next;
        }
        return null;
    }
}
