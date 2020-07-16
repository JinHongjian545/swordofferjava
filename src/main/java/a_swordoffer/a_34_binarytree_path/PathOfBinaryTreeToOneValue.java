package a_swordoffer.a_34_binarytree_path;

import java.util.Stack;

/**
 * @program: swordofferjava
 * @description: 二叉树中和为某一值的路径
 * @author: Jin Hongjian
 * @create: 2020-07-14
 **/
public class PathOfBinaryTreeToOneValue {

    /**
     * 利用回溯的思想
     *
     * @param treeNode
     * @param target
     * @return
     */
    static boolean pathFound = false;

    static boolean findPathToOneValue(BinaryTreeNode treeNode, int target) {
        pathFound = false;
        if (treeNode == null) {
            return false;
        }
        Stack<BinaryTreeNode> stack = new Stack<>();
        int currentSum = 0;
        findPathCore(stack, treeNode, target, currentSum);
        return pathFound;
    }

    private static void findPathCore(Stack<BinaryTreeNode> stack, BinaryTreeNode treeNode, int target, int currentSum) {
        stack.push(treeNode);
        currentSum += treeNode.value;
/*        if (currentSum > target) { //不要这个判断，可能节点存在负数的值
            stack.pop();
            return;
        }*/
        //是叶子节点且和为指定值
        if (currentSum == target && treeNode.pLeft == null && treeNode.pRight == null) {
            //print
            pathFound = true;
            System.out.println("Path found!");
            for (BinaryTreeNode binaryTreeNode : stack) {
                System.out.print(binaryTreeNode.value + "\t");
            }
            System.out.println();
        }
        //左子节点不为空
        if (treeNode.pLeft != null) {
            findPathCore(stack, treeNode.pLeft, target, currentSum);
        }
        //右子节点不为空
        if (treeNode.pRight != null) {
            findPathCore(stack, treeNode.pRight, target, currentSum);
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

        boolean pathFound = findPathToOneValue(node1, 7);
        if (!pathFound) {
            System.out.println("NOT FOUND!");
        }
        pathFound = findPathToOneValue(node1, 4);
        if (!pathFound) {
            System.out.println("NOT FOUND!");
        }
    }
}
