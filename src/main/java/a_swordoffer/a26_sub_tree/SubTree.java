package a_swordoffer.a26_sub_tree;

import a_swordoffer.a00_datastructure.TreeNode;

/**
 * @program: swordofferjava
 * @description: 树的子结构
 * @author: Jin Hongjian
 * @create: 2020-07-14
 **/
public class SubTree {
    /*
    *  首先需要在root1中找到与root2根节点值相同的节点，然后才是判断，这样分开方便递归，因为有两个递归的逻辑
    * */
    private static boolean isRoot2SubTreeOfRoot1(TreeNode root1, TreeNode root2) {
        boolean result = false;
        if (root1 != null && root2 != null) {
            if (root1.val == root2.val) {
                result = isSubTreeCore(root1, root2);
            }
            if (!result) { //左子树来判断
                result = isRoot2SubTreeOfRoot1(root1.left, root2);
            }
            if (!result) { //右子树来判断
                result = isRoot2SubTreeOfRoot1(root1.right, root2);
            }
        }
        return result;
    }

    private static boolean isSubTreeCore(TreeNode root1, TreeNode root2) {
        if (root2 == null) { //子树已经遍历到叶子结点， 这个条件必须比下面的判断root1是否为空的条件先判断
            return true;
        }
        if (root1 == null) { //父树已经遍历到叶子结点，而子树还没遍历到叶子结点
            return false;
        }
        if (root1.val != root2.val) { //值不相等
            return false;
        }
        return isSubTreeCore(root1.left, root2.left) && isSubTreeCore(root1.right, root2.right); //递归判断子树
    }

    public static void main(String[] args) {
        /*
        *       4
        *    1     12
        *  3   2   5   3
        */
        TreeNode node1 = new TreeNode(4);
        TreeNode node2 = new TreeNode(1);
        TreeNode node3 = new TreeNode(12);
        TreeNode node4 = new TreeNode(3);
        TreeNode node5 = new TreeNode(2);
        TreeNode node6 = new TreeNode(5);
        TreeNode node7 = new TreeNode(3);

        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;


        /*
         *    1
         *  3   2
         */
        TreeNode node11 = new TreeNode(1);
        TreeNode node21 = new TreeNode(3);
        TreeNode node31 = new TreeNode(2);

        node11.left = node21;
        node11.right = node31;

        /*
         *    1
         *  3   3
         */
        TreeNode node12 = new TreeNode(1);
        TreeNode node22 = new TreeNode(3);
        TreeNode node32 = new TreeNode(3);

        node12.left = node22;
        node12.right = node32;

        System.out.println(isRoot2SubTreeOfRoot1(node1, node11));
        System.out.println(isRoot2SubTreeOfRoot1(node1, node12));
    }
}
