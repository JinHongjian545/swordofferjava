package a_swordoffer.a_36_treetolinkedlist;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int value) {
        this.val = value;
    }

    public TreeNode() {

    }


    public static void printTreeNodeList(TreeNode head) {
        while (head != null) {
            System.out.print(head.val + "  ");
            head = head.right;
        }
    }
}
