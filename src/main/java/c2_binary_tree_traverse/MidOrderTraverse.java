package c2_binary_tree_traverse;

import java.util.Stack;

/**
 * @program: swordofferjava
 * @description: 中序遍历二叉树
 * @author: Jin Hongjian
 * @create: 2020-09-02
 **/
public class MidOrderTraverse {
    //递归遍历 中序：左-根-右
    private static void printTreeMidOrderRecursive(TreeNode root) {
        if (root != null) {
            printTreeMidOrderRecursive(root.left);
            System.out.print(root.val + " ");
            printTreeMidOrderRecursive(root.right);
        }
    }

    //非递归遍历 中序：左-根-右
    private static void printTreeMidOrderByStack(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();

        TreeNode cur = root;
        while (cur != null || !stack.empty()) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left; //这一步可能让cur变为 null
            } else {
                //cur为空时，说明栈顶元素已经没有左子节点了，栈顶元素就是最左节点, 输出
                cur = stack.pop();
                System.out.print(cur.val + " ");
                //此时把cur置为右节点，继续下一次循环，cur此时也可能会为null
                cur = cur.right;
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
        printTreeMidOrderRecursive(root);
        System.out.println();
        printTreeMidOrderByStack(root);
    }
}
