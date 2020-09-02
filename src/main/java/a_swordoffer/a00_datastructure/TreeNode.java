package a_swordoffer.a00_datastructure;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode() {

    }

    public static void printTreeNodeList(TreeNode head) {
        while (head != null) {
            System.out.print(head.val + "  ");
            head = head.right;
        }
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "val=" + val +
                '}';
    }
}
