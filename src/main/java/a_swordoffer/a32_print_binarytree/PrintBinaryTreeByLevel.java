package a_swordoffer.a32_print_binarytree;

import a_swordoffer.a00_datastructure.TreeNode;

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
    public static void printBinaryTreeByLevel(TreeNode root) {
        if (root == null) {
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode node;
        queue.offer(root);
        while (!queue.isEmpty()) {
            node = queue.poll();
            System.out.print(node.val + "\t"); //print
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
    }

    public static void main(String[] args) {
        /*
         *       8
         *    6     10
         *  5   7   9   11
         */
        TreeNode node1 = new TreeNode(8);
        TreeNode node2 = new TreeNode(6);
        TreeNode node3 = new TreeNode(10);
        TreeNode node4 = new TreeNode(5);
        TreeNode node5 = new TreeNode(7);
        TreeNode node6 = new TreeNode(9);
        TreeNode node7 = new TreeNode(11);

        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;

        printBinaryTreeByLevel(node1);
    }
}
