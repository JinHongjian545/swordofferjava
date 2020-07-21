package a_swordoffer.a_52_treedepth;

import java.util.HashMap;
import java.util.HashSet;

/**
 * 判断一颗二叉树是不是平衡二叉树
 */
public class JudgeBalancedBinaryTree {

    /**
     * 解法一：最简单的方法，递归遍历，判断子树深度 NOTICE:包含了重复计算，可以使用后序遍历来优化
     *
     * @param root
     * @return
     */
    private static boolean isBalancedTree(BinaryTreeNode root) {
        if (root == null)
            return true;
        int leftDepth = TreeDepth.treeDepth(root.pLeft);
        int rightDepth = TreeDepth.treeDepth(root.pRight);
        if (Math.abs(leftDepth - rightDepth) > 1) {
            return false;
        }
        return isBalancedTree(root.pLeft) && isBalancedTree(root.pRight);
    }

    /**
     * 解法二：使用后序遍历并保存节点深度实现  后序遍历： 左 右 跟
     *
     * @param root
     * @return
     */
    private static int depth;

    private static boolean isBalancedTreeByAftOrder(BinaryTreeNode root) {
        if (root == null) {
            return true;
        }
        HashMap<BinaryTreeNode, Integer> depthMap = new HashMap<>();
        return isBalancedTreeByAftOrderCore(root, depthMap);
    }

    private static boolean isBalancedTreeByAftOrderCore(BinaryTreeNode root, HashMap<BinaryTreeNode, Integer> depthMap) {
        //空节点递归终止
        if (root == null) {
            depthMap.put(null, 0);
            return true;
        }
        //非空节点递归
        if (isBalancedTreeByAftOrderCore(root.pLeft, depthMap) && isBalancedTreeByAftOrderCore(root.pRight, depthMap)) {
            //两边子树都是平衡的，判断当前根是否平衡
            int leftDepth = depthMap.get(root.pLeft);
            int rightDepth = depthMap.get(root.pRight);
            int diff = Math.abs(leftDepth - rightDepth);
            if (diff <= 1) {
                depthMap.put(root, 1 + Math.max(leftDepth, rightDepth));
                return true;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        /*
         *       4
         *    1     12
         *  3   2
         * 6
         */
        BinaryTreeNode node1 = new BinaryTreeNode(4);
        BinaryTreeNode node2 = new BinaryTreeNode(1);
        BinaryTreeNode node3 = new BinaryTreeNode(12);
        BinaryTreeNode node4 = new BinaryTreeNode(3);
        BinaryTreeNode node5 = new BinaryTreeNode(2);
        BinaryTreeNode node6 = new BinaryTreeNode(6);
        node1.pLeft = node2;
        node1.pRight = node3;
        node2.pLeft = node4;
        node2.pRight = node5;
        node4.pLeft = node6;

        //map test
        HashMap<Integer, Integer> integerIntegerHashMap = new HashMap<>();
        integerIntegerHashMap.put(1, 2);
        integerIntegerHashMap.put(null, 0);
        System.out.println(integerIntegerHashMap.get(null));
        integerIntegerHashMap.put(null, 1);
        System.out.println(integerIntegerHashMap.get(null));
        System.out.println(integerIntegerHashMap.get(1));

        System.out.println("=========================");

        System.out.println(isBalancedTree(node1));
        System.out.println(isBalancedTreeByAftOrder(node1));

        System.out.println(isBalancedTree(node4));
        System.out.println(isBalancedTreeByAftOrder(node4));
    }
}
