package a_swordoffer.a_26_27_28_sub_mirror_tree;

import a_swordoffer.a_0_datastructure.TreeNode;
import a_swordoffer.a_32_print_binarytree.PrintBinaryTreeByLevel;

/**
 * 二叉树的镜像
 */
public class MirrorTree {
    /**
     * 输入一颗二叉树，输出该树的镜像
     *
     * @param root
     */
    public static void getMirrorTree(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode node = root.left;
        root.left = root.right;
        root.right = node;
        if (root.left != null) {
            getMirrorTree(root.left);
        }
        if (root.right != null) {
            getMirrorTree(root.right);
        }
    }

    /**
     * 输入一颗二叉树，输出该树的镜像, 这个方法是用来测试判断两个二叉树是不是互为镜像的方法，新建了一棵树
     *
     * @param root
     */
    public static TreeNode getMirrorTree2(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode newRoot = new TreeNode(root.val);
        if (root.left != null) {
            newRoot.right = getMirrorTree2(root.left);
        }
        if (root.right != null) {
            newRoot.left = getMirrorTree2(root.right);
        }
        return newRoot;
    }

    /**
     * 判断一个二叉树是不是另一个二叉树的镜像
     *
     * @param root1
     * @param root2
     */
    public static boolean judgeMirrorTree(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {//两个都为空
            return true;
        }
        if (root1 == null || root2 == null) {//到这里说明至少有一个不为空，如果其中一个为空，则返回false
            return false;
        }
        //现在两个都不为空,先判定值，如果值相同则递归进行判断，这句实际上是可以合并到上面的
        if (root1.val != root2.val) {
            return false;
        }
        return judgeMirrorTree(root1.right, root2.left) && judgeMirrorTree(root1.left, root2.right);

    }


    //test
    public static void main(String[] args) {
        /*
         *       8
         *    6     10
         *  5   7   9
         */
        TreeNode node1 = new TreeNode(8);
        TreeNode node2 = new TreeNode(6);
        TreeNode node3 = new TreeNode(10);
        TreeNode node4 = new TreeNode(5);
        TreeNode node5 = new TreeNode(7);
        TreeNode node6 = new TreeNode(9);

        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;

        TreeNode mirrorTree2 = getMirrorTree2(node1);
        PrintBinaryTreeByLevel.printBinaryTreeByLevel(mirrorTree2);
        System.out.println();
        System.out.println("====================");
        getMirrorTree(node1);
        PrintBinaryTreeByLevel.printBinaryTreeByLevel(node1);


    }

}
