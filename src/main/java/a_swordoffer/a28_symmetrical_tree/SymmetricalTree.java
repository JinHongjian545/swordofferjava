package a_swordoffer.a28_symmetrical_tree;

import a_swordoffer.a00_datastructure.TreeNode;

public class SymmetricalTree {
    /**
     * 判断一个二叉树是不是对称的，即一个树与它的镜像树相同
     * 与判断两棵树是不是互为镜像逻辑相同
     *
     * @param root
     */
    public static boolean judgeSymmetricalTree(TreeNode root) {
        return judgeSymmetricalTreeCore(root, root);
    }

    private static boolean judgeSymmetricalTreeCore(TreeNode root1, TreeNode root2) {
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
        return judgeSymmetricalTreeCore(root1.right, root2.left) && judgeSymmetricalTreeCore(root1.left, root2.right);
    }

}
