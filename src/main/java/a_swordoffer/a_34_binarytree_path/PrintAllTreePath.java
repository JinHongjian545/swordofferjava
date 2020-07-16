package a_swordoffer.a_34_binarytree_path;

import java.util.Stack;

/**
 * @program: swordofferjava
 * @description: 打印所有的二叉树从根到叶子结点的路径
 * @author: Jin Hongjian
 * @create: 2020-07-14
 **/
public class PrintAllTreePath {

    static void printTreePath(BinaryTreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        Stack<BinaryTreeNode> stack = new Stack<>();
        printPathCore(stack, treeNode);
    }

    private static void printPathCore(Stack<BinaryTreeNode> stack, BinaryTreeNode treeNode) {
        stack.push(treeNode);

        if (treeNode.pLeft == null && treeNode.pRight == null) {
            //print path
            for (BinaryTreeNode binaryTreeNode : stack) {
                System.out.print(binaryTreeNode.value + "\t");
            }
            System.out.println();
        }
        //左子节点不为空
        if (treeNode.pLeft != null) {
            printPathCore(stack, treeNode.pLeft);
        }
        //右子节点不为空
        if (treeNode.pRight != null) {
            printPathCore(stack, treeNode.pRight);
        }
        //本方法调用完，返回上层调用，取出一个节点来，实现回溯 (在当前路径上删除节点)
        stack.pop();
    }

    public static void main(String[] args) {

        BinaryTreeNode node1 = new BinaryTreeNode(4);
        BinaryTreeNode node2 = new BinaryTreeNode(1);
        BinaryTreeNode node3 = new BinaryTreeNode(12);
        BinaryTreeNode node4 = new BinaryTreeNode(3);
        BinaryTreeNode node5 = new BinaryTreeNode(2);
        BinaryTreeNode node6 = new BinaryTreeNode(5);
        BinaryTreeNode node7 = new BinaryTreeNode(3);

        node1.pLeft = node2;
        node1.pRight = node3;
        node2.pLeft = node4;
        node2.pRight = node5;
        node3.pLeft = node6;
        node3.pRight = node7;

        printTreePath(node1);
        System.out.println("==========================");
        printTreePath(node2);
        System.out.println("==========================");
        printTreePath(node3);

    }


}
