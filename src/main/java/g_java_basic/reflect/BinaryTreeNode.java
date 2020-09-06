package g_java_basic.reflect;

public class BinaryTreeNode {
    private int value;
    private String name;
    private String description = "aaaaa description";
    private BinaryTreeNode pLeft;
    private BinaryTreeNode pRight;

    public BinaryTreeNode(int value) {
        this.value = value;
    }

    public BinaryTreeNode(int value, String name) {
        this.value = value;
        this.name = name;
    }

    public BinaryTreeNode() {
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BinaryTreeNode getpLeft() {
        return pLeft;
    }

    public void setpLeft(BinaryTreeNode pLeft) {
        this.pLeft = pLeft;
    }

    public BinaryTreeNode getpRight() {
        return pRight;
    }

    public void setpRight(BinaryTreeNode pRight) {
        this.pRight = pRight;
    }

    @Override
    public String toString() {
        return "name: " + name + "; " + "value: " + value;
    }
}
