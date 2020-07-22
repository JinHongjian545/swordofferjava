package a_swordoffer.a_52_treedepth;

/**
 * 二叉树的深度
 */
public class TreeDepth {

    static int treeDepth(BinaryTreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(treeDepth(root.pLeft), treeDepth(root.pRight)) + 1;
    }


    public static void main(String[] args) {

        /*
         *       4
         *    1     12
         *  3   2
         */
        BinaryTreeNode node1 = new BinaryTreeNode(4);
        BinaryTreeNode node2 = new BinaryTreeNode(1);
        BinaryTreeNode node3 = new BinaryTreeNode(12);
        BinaryTreeNode node4 = new BinaryTreeNode(3);
        BinaryTreeNode node5 = new BinaryTreeNode(2);
        node1.pLeft = node2;
        node1.pRight = node3;
        node2.pLeft = node4;
        node2.pRight = node5;

        System.out.println(treeDepth(node1));
    }

}
