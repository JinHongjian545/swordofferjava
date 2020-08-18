package d_company_real.bytedance;

import java.util.Scanner;

/**
 * @program: swordofferjava
 * @description:
 * @author: Jin Hongjian
 * @create: 2020-07-25
 **/
public class LinkedListProblem {

    private static Node dealLinkedList(Node head){
        if(head == null){
            return null;
        }
        Node originalHead = head;
        int count = 1;
        int cVal = head.val;
        head = head.next;
        if(head == null){
            Node node = new Node(originalHead.val);
            node.prev = originalHead;
            originalHead.next = node;
            return originalHead;
        }
        while(head != null){
            if(cVal != head.val){ //已经到跟前一节点值不同的节点
                if(count == 1){ //增加一个节点
                    Node node = new Node(cVal);
                    node.next = head;
                    node.prev = head.prev;
                    head.prev.next = node;
                    head.prev = node;
                }
                if(count > 2){
                    while(count != 2){
                        //删除前一节点
                        head.prev.prev.next = head;
                        head.prev = head.prev.prev;
                        count--;
                    }
                }
                if(head.next == null){
                    Node node = new Node(head.val);
                    node.prev = head;
                    head.next = node;
                    return originalHead;
                }
                count = 1;//count重置
                cVal = head.val; //cVal重置
            }else{
                count++;
            }
            head = head.next;
        }
        if(count > 2){ //如果存在输入 2 2 2 2 2这种情况，特殊处理
            originalHead.next.next.prev = null;
            originalHead.next.next = null;
        }
        return originalHead;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int headVal  = in.nextInt();
        Node head = new Node(headVal);
        Node node = head;
        while (in.hasNextInt()) {
            int a = in.nextInt();
            Node cNode = new Node(a);
            node.next = cNode;
            node = cNode;
        }
        //前节点
        node = head;
        Node prev = null;
        while(node != null){
            node.prev = prev;
            prev = node;
            node = node.next;
        }

        Node newHead = dealLinkedList(head);
        while(newHead != null){
            System.out.print(newHead.val);
            if(newHead.next != null){
                System.out.print(" ");
            }
            newHead = newHead.next;
        }
    }
}

//静态内部类，链表的节点
class Node{
    int val;
    Node prev;
    Node next;
    Node(int val){
        this.val = val;
    }
}