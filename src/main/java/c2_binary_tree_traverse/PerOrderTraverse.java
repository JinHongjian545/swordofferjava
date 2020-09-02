package c2_binary_tree_traverse;

import java.util.Stack;

/**
 * @program: swordofferjava
 * @description: 前序遍历二叉树
 * @author: Jin Hongjian
 * @create: 2020-09-02
 **/
public class PerOrderTraverse {
    //递归遍历 前序：根-左-右
    private static void printTreePreOrderRecursive(TreeNode root) {
        if (root != null) {
            System.out.print(root.val + " ");
            printTreePreOrderRecursive(root.left);
            printTreePreOrderRecursive(root.right);
        }
    }

    //非递归遍历 前序：根-左-右
    private static void printTreePreOrderByStack(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        TreeNode c;
        while (!stack.empty()) {
            c = stack.pop();
            //先输出根节点
            System.out.print(c.val + " ");
            //把右节点放进去，后拿出来
            if (c.right != null) {
                stack.push(c.right);
            }
            //把左节点放进去，先拿出来
            if (c.left != null) {
                stack.push(c.left);
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
        printTreePreOrderRecursive(root);
        System.out.println();
        printTreePreOrderByStack(root);
    }
}
