package a_swordoffer.a_36_treetolinkedlist;

import a_swordoffer.a_0_datastructure.TreeNode;
import sun.reflect.generics.tree.Tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @program: swordofferjava
 * @description: 二叉搜索树转双向链表
 * @author: Jin Hongjian
 * @create: 2020-07-26
 **/
public class BinaryTreeToLinkedList {
    /**
     * 使用中序遍历的思想，将二叉搜索树转为双向有序链表
     * 自己的方法：使用一个队列来缓存二叉树节点, 然后从队列中依次取出节点
     *
     * @param root
     * @return
     */
    private static TreeNode binaryTreeToLinkedListByQueue(TreeNode root) {
        if (root == null) {
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        addQueue(root, queue);
        //从队列中取出节点并连接成链表
        TreeNode head = queue.poll();
        TreeNode node = head;
        TreeNode pollNode = null;
        while (!queue.isEmpty()) {
            pollNode = queue.poll();
            node.right = pollNode;
            pollNode.left = node;
            node = pollNode;
        }
        return head;
    }

    private static void addQueue(TreeNode root, Queue<TreeNode> queue) {
        if (root.left != null) {
            addQueue(root.left, queue);
        }
        queue.offer(root);
        if (root.right != null) {
            addQueue(root.right, queue);
        }
    }

    /*=====================================================================*/

    /**
     * 使用剑指offer的思路，直接根据中序遍历的思想修改指针
     *
     * @param root
     */
    private static TreeNode lastNodeInList;
    private static TreeNode binaryTreeToLinkedList(TreeNode root) {
        if (root == null) {
            return null;
        }
        lastNodeInList = null;
        binaryTreeToLinkedListCore(root);
        //lastNodeInList是链表的最后一个节点，需要返回链表的头结点
        while (lastNodeInList.left != null) {
            lastNodeInList = lastNodeInList.left;
        }
        return lastNodeInList;
    }


    private static void binaryTreeToLinkedListCore(TreeNode root) {
        //中序遍历的思想
        if (root.left != null) {
            binaryTreeToLinkedListCore(root.left);
        }
        //当前根节点连到链表中最后一个节点上，并更新链表最后节点为当前节点
        root.left = lastNodeInList;
        if (lastNodeInList != null) {
            lastNodeInList.right = root;
        }
        lastNodeInList = root;

        if (root.right != null) {
            binaryTreeToLinkedListCore(root.right);
        }
    }

    public static void main(String[] args) {
        /*
         *       8
         *    6     10
         *  5   7   9   11
         */
        TreeNode node1 = new TreeNode(10);
        TreeNode node2 = new TreeNode(6);
        TreeNode node3 = new TreeNode(14);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(8);
        TreeNode node6 = new TreeNode(12);
        TreeNode node7 = new TreeNode(16);

        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;

        TreeNode head = binaryTreeToLinkedList(node1);
//        TreeNode head = binaryTreeToLinkedListByQueue(node1);

        TreeNode.printTreeNodeList(head);

    }


}
