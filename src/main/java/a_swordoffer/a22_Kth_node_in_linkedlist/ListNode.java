package a_swordoffer.a22_Kth_node_in_linkedlist;

/**
 * @program: swordofferjava
 * @description:
 * @author: Jin Hongjian
 * @create: 2020-07-19
 **/
public class ListNode {
    int val;
    ListNode next;

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode() {
    }

    @Override
    public String toString() {
        return val + "";
    }

    public static void printList(ListNode head) {
        while (head != null) {
            if (head.next != null)
                System.out.print(head.val + " --> ");
            else
                System.out.println(head.val);
            head = head.next;
        }
    }
}