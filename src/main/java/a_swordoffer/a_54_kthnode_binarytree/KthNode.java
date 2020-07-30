package a_swordoffer.a_54_kthnode_binarytree;

import a_swordoffer.a_0_datastructure.TreeNode;

public class KthNode {

    /**
     * 找到二叉搜索树中的第k大节点，使用中序遍历法 左根右
     *
     * @param root
     * @param k
     * @return
     */
    public static TreeNode findKthNodeOfBinarySearchTree(TreeNode root, int k) {
        if (root == null || k <= 0) {
            return null;
        }
        staticK = k;
        return findKthCore(root);
    }

    private static int staticK = 0;

    private static TreeNode findKthCore(TreeNode root) {
        TreeNode result = null;
        //左
        if (root.left != null) {
            result = findKthCore(root.left);
        }
        //中
        if (result == null){
            if (staticK == 1) {
                return root;
            }
            staticK--;
        }
        //右
        if (result == null && root.right != null) {
            result = findKthCore(root.right);
        }
        
        return result;
    }

    public static void main(String[] args) {
        /*
         *       6
         *    4     12
         *  3   5  9   28
         * 1
         */
        TreeNode node1 = new TreeNode(6);
        TreeNode node2 = new TreeNode(4);
        TreeNode node3 = new TreeNode(12);
        TreeNode node4 = new TreeNode(3);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(9);
        TreeNode node7 = new TreeNode(28);
        TreeNode node8 = new TreeNode(1);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        node4.left = node8;


        System.out.println(findKthNodeOfBinarySearchTree(node1, 1));
        System.out.println(findKthNodeOfBinarySearchTree(node1, 2));
        System.out.println(findKthNodeOfBinarySearchTree(node1, 3));
        System.out.println(findKthNodeOfBinarySearchTree(node1, 4));
        System.out.println(findKthNodeOfBinarySearchTree(node1, 5));
        System.out.println(findKthNodeOfBinarySearchTree(node1, 6));
        System.out.println(findKthNodeOfBinarySearchTree(node1, 7));
        System.out.println(findKthNodeOfBinarySearchTree(node1, 8));
        System.out.println(findKthNodeOfBinarySearchTree(node1, 9));
    }
}
