package a_26_sub_tree;

/**
 * @program: swordofferjava
 * @description: 判断两棵树是否相同
 * @author: Jin Hongjian
 * @create: 2020-07-14
 **/
public class TheSameTree {

    public static boolean isTheSameTree(BinaryTreeNode root1, BinaryTreeNode root2) {
        if (root1 == null || root2 == null) {
            return root1 == null && root2 == null; //两个都是空的话返回 true
        }
        if (root1.value != root2.value) {
            return false;
        }
        return isTheSameTree(root1.pLeft, root2.pLeft) && isTheSameTree(root1.pRight, root2.pRight);
    }


    public static void main(String[] args) {

        /*
         *       4
         *    1     12
         *  3   2   5
         */
        BinaryTreeNode node1 = new BinaryTreeNode(4);
        BinaryTreeNode node2 = new BinaryTreeNode(1);
        BinaryTreeNode node3 = new BinaryTreeNode(12);
        BinaryTreeNode node4 = new BinaryTreeNode(3);
        BinaryTreeNode node5 = new BinaryTreeNode(2);
        BinaryTreeNode node6 = new BinaryTreeNode(5);
        node1.pLeft = node2;
        node1.pRight = node3;
        node2.pLeft = node4;
        node2.pRight = node5;
        node3.pLeft = node6;

        /*
         *       4
         *    1     12
         *  3   2   5
         */
        BinaryTreeNode node11 = new BinaryTreeNode(4);
        BinaryTreeNode node21 = new BinaryTreeNode(1);
        BinaryTreeNode node31 = new BinaryTreeNode(12);
        BinaryTreeNode node41 = new BinaryTreeNode(3);
        BinaryTreeNode node51 = new BinaryTreeNode(2);
        BinaryTreeNode node61 = new BinaryTreeNode(5);
        node11.pLeft = node21;
        node11.pRight = node31;
        node21.pLeft = node41;
        node21.pRight = node51;
        node31.pLeft = node61;


        System.out.println(isTheSameTree(node1, node11)); // true
        System.out.println(isTheSameTree(node1, node2));  //false


        System.out.println(isTheSameTree(node6, node61)); // true
        System.out.println(isTheSameTree(node6, null)); //false
        System.out.println(isTheSameTree(null, null)); //true

        System.out.println(Math.abs(0.00000005d - 0.00000006d) < 1e-6);
        System.out.println(Math.abs(0.0005d - 0.00000006d) < 1e-6);

    }


}
