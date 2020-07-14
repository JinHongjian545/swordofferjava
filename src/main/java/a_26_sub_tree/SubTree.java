package a_26_sub_tree;

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
    private static boolean isRoot2SubTreeOfRoot1(BinaryTreeNode root1, BinaryTreeNode root2) {
        boolean result = false;
        if (root1 != null && root2 != null) {
            if (root1.value == root2.value) {
                result = isSubTreeCore(root1, root2);
            }
            if (!result) { //左子树来判断
                result = isRoot2SubTreeOfRoot1(root1.pLeft, root2);
            }
            if (!result) { //右子树来判断
                result = isRoot2SubTreeOfRoot1(root1.pRight, root2);
            }
        }
        return result;
    }

    private static boolean isSubTreeCore(BinaryTreeNode root1, BinaryTreeNode root2) {
        if (root2 == null) { //子树已经遍历到叶子结点， 这个条件必须比下面的判断root1是否为空的条件先判断
            return true;
        }
        if (root1 == null) { //父树已经遍历到叶子结点，而子树还没遍历到叶子结点
            return false;
        }
        if (root1.value != root2.value) { //值不相等
            return false;
        }
        return isSubTreeCore(root1.pLeft, root2.pLeft) && isSubTreeCore(root1.pRight, root2.pRight); //递归判断子树
    }

    public static void main(String[] args) {
        /*
        *       4
        *    1     12
        *  3   2   5   3
        */
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


        /*
         *    1
         *  3   2
         */
        BinaryTreeNode node11 = new BinaryTreeNode(1);
        BinaryTreeNode node21 = new BinaryTreeNode(3);
        BinaryTreeNode node31 = new BinaryTreeNode(2);

        node11.pLeft = node21;
        node11.pRight = node31;

        /*
         *    1
         *  3   3
         */
        BinaryTreeNode node12 = new BinaryTreeNode(1);
        BinaryTreeNode node22 = new BinaryTreeNode(3);
        BinaryTreeNode node32 = new BinaryTreeNode(3);

        node12.pLeft = node22;
        node12.pRight = node32;

        System.out.println(isRoot2SubTreeOfRoot1(node1, node11));
        System.out.println(isRoot2SubTreeOfRoot1(node1, node12));
    }
}
