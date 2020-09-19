package a_swordoffer.a00_datastructure;

/**
 * @program: swordofferjava
 * @description:
 * @author: Jin Hongjian
 * @create: 2020-07-19
 **/
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode() {
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