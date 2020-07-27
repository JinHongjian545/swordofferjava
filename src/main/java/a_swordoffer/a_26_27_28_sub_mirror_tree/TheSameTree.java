package a_swordoffer.a_26_27_28_sub_mirror_tree;

import a_swordoffer.a_0_datastructure.TreeNode;

/**
 * @program: swordofferjava
 * @description: 判断两棵树是否相同
 * @author: Jin Hongjian
 * @create: 2020-07-14
 **/
public class TheSameTree {

    public static boolean isTheSameTree(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 == null) {
            return root1 == null && root2 == null; //两个都是空的话返回 true
        }
        if (root1.val != root2.val) {
            return false;
        }
        return isTheSameTree(root1.left, root2.left) && isTheSameTree(root1.right, root2.right);
    }


    public static void main(String[] args) {

        /*
         *       4
         *    1     12
         *  3   2   5
         */
        TreeNode node1 = new TreeNode(4);
        TreeNode node2 = new TreeNode(1);
        TreeNode node3 = new TreeNode(12);
        TreeNode node4 = new TreeNode(3);
        TreeNode node5 = new TreeNode(2);
        TreeNode node6 = new TreeNode(5);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;

        /*
         *       4
         *    1     12
         *  3   2   5
         */
        TreeNode node11 = new TreeNode(4);
        TreeNode node21 = new TreeNode(1);
        TreeNode node31 = new TreeNode(12);
        TreeNode node41 = new TreeNode(3);
        TreeNode node51 = new TreeNode(2);
        TreeNode node61 = new TreeNode(5);
        node11.left = node21;
        node11.right = node31;
        node21.left = node41;
        node21.right = node51;
        node31.left = node61;


        System.out.println(isTheSameTree(node1, node11)); // true
        System.out.println(isTheSameTree(node1, node2));  //false


        System.out.println(isTheSameTree(node6, node61)); // true
        System.out.println(isTheSameTree(node6, null)); //false
        System.out.println(isTheSameTree(null, null)); //true

        System.out.println(Math.abs(0.00000005d - 0.00000006d) < 1e-6);
        System.out.println(Math.abs(0.0005d - 0.00000006d) < 1e-6);

    }


}
