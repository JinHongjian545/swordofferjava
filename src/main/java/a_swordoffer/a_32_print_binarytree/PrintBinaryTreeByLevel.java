package a_swordoffer.a_32_print_binarytree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @program: swordofferjava
 * @description: 层序打印二叉树
 * @author: Jin Hongjian
 * @create: 2020-07-14
 **/
public class PrintBinaryTreeByLevel {

    /**
     * 找规律以后通过队列实现
     *
     * @param root
     */
    private static void printBinaryTreeByLevel(BinaryTreeNode root) {
        if (root == null) {
            return;
        }
        Queue<BinaryTreeNode> queue = new LinkedList<>();
        BinaryTreeNode node;
        queue.offer(root);
        while (!queue.isEmpty()) {
            node = queue.poll();
            System.out.print(node.value + "\t"); //print
            if (node.pLeft != null) {
                queue.offer(node.pLeft);
            }
            if (node.pRight != null) {
                queue.offer(node.pRight);
            }
        }
    }

    public static void main(String[] args) {
        /*
         *       8
         *    6     10
         *  5   7   9   11
         */
        BinaryTreeNode node1 = new BinaryTreeNode(8);
        BinaryTreeNode node2 = new BinaryTreeNode(6);
        BinaryTreeNode node3 = new BinaryTreeNode(10);
        BinaryTreeNode node4 = new BinaryTreeNode(5);
        BinaryTreeNode node5 = new BinaryTreeNode(7);
        BinaryTreeNode node6 = new BinaryTreeNode(9);
        BinaryTreeNode node7 = new BinaryTreeNode(11);

        node1.pLeft = node2;
        node1.pRight = node3;
        node2.pLeft = node4;
        node2.pRight = node5;
        node3.pLeft = node6;
        node3.pRight = node7;

        printBinaryTreeByLevel(node1);
    }
}
