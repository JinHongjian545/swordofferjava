package a_swordoffer.a_32_print_binarytree;

import java.util.ArrayList;
import java.util.Stack;

public class PrintBinaryTreeByZhiCharacter {
    public static ArrayList<ArrayList<Integer> > printBinaryTreeByZhiCharacter(BinaryTreeNode pRoot) {
        ArrayList<ArrayList<Integer> > result = new ArrayList<>();
        if (pRoot==null){
            return result;
        }
        Stack<BinaryTreeNode> stack1 = new Stack<>();
        Stack<BinaryTreeNode> stack2 = new Stack<>();

        stack1.push(pRoot);
        BinaryTreeNode node;
        while(true){
            ArrayList<Integer> ints = new ArrayList<>();
            while(!stack1.isEmpty()){
                node = stack1.pop();
                if(node.pLeft != null){
                    stack2.push(node.pLeft);
                }
                if(node.pRight != null){
                    stack2.push(node.pRight);
                }
                ints.add(node.value);
            }
            if(!ints.isEmpty())
                result.add(ints);

            ArrayList<Integer> ints2 = new ArrayList<>();
            while(!stack2.isEmpty()){
                node = stack2.pop();
                if(node.pRight != null){
                    stack1.push(node.pRight);
                }
                if(node.pLeft != null){
                    stack1.push(node.pLeft);
                }
                ints2.add(node.value);
            }
            if(!ints2.isEmpty())
                result.add(ints2);

            if (stack1.isEmpty() && stack2.isEmpty()){
                break;
            }
        }
        return result;
    }


    public static void main(String[] args) {
        /*
         *       8
         *    6     10
         *  5   7   9   11
         */
        BinaryTreeNode node1 = new BinaryTreeNode(8);
        BinaryTreeNode node2 = new BinaryTreeNode(6);
        BinaryTreeNode node3 = new BinaryTreeNode(10);
        BinaryTreeNode node4 = new BinaryTreeNode(5);
        BinaryTreeNode node5 = new BinaryTreeNode(7);
        BinaryTreeNode node6 = new BinaryTreeNode(9);
        BinaryTreeNode node7 = new BinaryTreeNode(11);

        node1.pLeft = node2;
        node1.pRight = node3;
        node2.pLeft = node4;
        node2.pRight = node5;
        node3.pLeft = node6;
        node3.pRight = node7;

        ArrayList<ArrayList<Integer>> arrayLists = printBinaryTreeByZhiCharacter(node1);
        System.out.println(arrayLists);
    }
}