package a_swordoffer.a07_08_binarytree;

public class BinaryTreeNodeWithParentPointer {
    public int value;
    public BinaryTreeNodeWithParentPointer pLeft;
    public BinaryTreeNodeWithParentPointer pRight;
    public BinaryTreeNodeWithParentPointer pParent;

    public BinaryTreeNodeWithParentPointer(int value) {
        this.value = value;
    }

    public BinaryTreeNodeWithParentPointer() {

    }
}