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
public class PrintBinaryTreeLeftRightView {

    /**
     * 找规律以后通过两个队列实现
     *
     * @param root
     */
    public static void printBinaryTreeLeftView(TreeNode root) {
        if (root == null) {
            return;
        }
        Queue<TreeNode> queue1 = new LinkedList<>();
        Queue<TreeNode> queue2 = new LinkedList<>();
        TreeNode node;
        queue1.offer(root);
        while (!queue1.isEmpty() || !queue2.isEmpty()) {
            Queue<TreeNode> q1, q2; //q1指向当前不为空的那个队列
            if (queue1.isEmpty()) {
                q1 = queue2;
                q2 = queue1;
            } else {
                q1 = queue1;
                q2 = queue2;
            }
            System.out.println(q1.peek().val);
            //拿出队列的节点，并把下层节点放到另一个队列
            while (!q1.isEmpty()) {
                node = q1.poll();
                if (node.left != null) {
                    q2.offer(node.left);
                }
                if (node.right != null) {
                    q2.offer(node.right);
                }
            }
        }
    }

    /**
     * 找规律以后通过两个队列实现，右视图
     *
     * @param root
     */
    public static void printBinaryTreeRightView(TreeNode root) {
        if (root == null) {
            return;
        }
        Queue<TreeNode> queue1 = new LinkedList<>();
        Queue<TreeNode> queue2 = new LinkedList<>();
        TreeNode node;
        queue1.offer(root);
        while (!queue1.isEmpty() || !queue2.isEmpty()) {
            Queue<TreeNode> q1, q2; //q1指向当前不为空的那个队列
            if (queue1.isEmpty()) {
                q1 = queue2;
                q2 = queue1;
            } else {
                q1 = queue1;
                q2 = queue2;
            }
            System.out.println(q1.peek().val);
            //拿出队列的节点，并把下层节点放到另一个队列
            while (!q1.isEmpty()) {
                node = q1.poll();
                if (node.right != null) {
                    q2.offer(node.right);
                }
                if (node.left != null) {
                    q2.offer(node.left);
                }
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

        printBinaryTreeLeftView(node1);

        System.out.println("=================================");

        printBinaryTreeRightView(node1);
    }
}
