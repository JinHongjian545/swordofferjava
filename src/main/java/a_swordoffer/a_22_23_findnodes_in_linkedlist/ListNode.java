package a_swordoffer.a_22_23_findnodes_in_linkedlist;

/**
 * @program: swordofferjava
 * @description:
 * @author: Jin Hongjian
 * @create: 2020-07-19
 **/
public class ListNode {
    int value;
    ListNode next;

    public ListNode(int value) {
        this.value = value;
    }

    public ListNode() {
    }

    @Override
    public String toString() {
        return value + "";
    }

    public static void printList(ListNode head) {
        while (head != null) {
            if (head.next != null)
                System.out.print(head.value + " --> ");
            else
                System.out.println(head.value);
            head = head.next;
        }
    }
}