package c2_binary_tree_traverse;

import java.util.Stack;

/**
 * @program: swordofferjava
 * @description: 后序遍历二叉树
 * @author: Jin Hongjian
 * @create: 2020-09-02
 **/
public class LaterOrderTraverse {
    //递归遍历 后序：左-右-根
    private static void printTreeLaterOrderRecursive(TreeNode root) {
        if (root != null) {
            printTreeLaterOrderRecursive(root.left);
            printTreeLaterOrderRecursive(root.right);
            System.out.print(root.val + " ");
        }
    }

    //非递归遍历 前序：根-左-右
    private static void printTreePreOrderByStack(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();

        TreeNode cur = root;
        // 标记最近出栈的节点，用于判断是否是p节点的右孩子，如果是的话，就可以访问p节点
        TreeNode pre = cur;
        while (cur != null || !stack.empty()) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else { //cur==null 的情况
                cur = stack.pop();

                if (cur.right == null || cur.right == pre) {
                    System.out.print(cur.val + " ");
                    pre = cur;
                    cur = null;
                } else {
                    stack.push(cur);
                    cur = cur.right;
                    stack.push(cur);
                    cur = cur.left;
                }
            }
        }
    }

    public static void main(String[] args) {
        /*
         *         1
         *     2       3
         *  4         5   6
         * 前序结果（根左右）：1 2 4 3 5 6
         * 中序结果（左根右）：4 2 1 5 3 6
         * 后序结果（左右根）：4 2 5 6 3 1
         */
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);

        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node3.left = node5;
        node3.right = node6;

        TreeNode root = node1;
        printTreeLaterOrderRecursive(root);
        System.out.println();
        printTreePreOrderByStack(root);
    }
}
