package a_swordoffer.a32_print_binarytree;

import a_swordoffer.a00_datastructure.TreeNode;

import java.util.ArrayList;
import java.util.Stack;

public class PrintBinaryTreeByZhiCharacter {
    public static ArrayList<ArrayList<Integer> > printBinaryTreeByZhiCharacter(TreeNode pRoot) {
        ArrayList<ArrayList<Integer> > result = new ArrayList<>();
        if (pRoot==null){
            return result;
        }
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();

        stack1.push(pRoot);
        TreeNode node;
        while(true){
            ArrayList<Integer> ints = new ArrayList<>();
            while(!stack1.isEmpty()){
                node = stack1.pop();
                if(node.left != null){
                    stack2.push(node.left);
                }
                if(node.right != null){
                    stack2.push(node.right);
                }
                ints.add(node.val);
            }
            if(!ints.isEmpty())
                result.add(ints);

            ArrayList<Integer> ints2 = new ArrayList<>();
            while(!stack2.isEmpty()){
                node = stack2.pop();
                if(node.right != null){
                    stack1.push(node.right);
                }
                if(node.left != null){
                    stack1.push(node.left);
                }
                ints2.add(node.val);
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
        TreeNode node1 = new TreeNode(8);
        TreeNode node2 = new TreeNode(6);
        TreeNode node3 = new TreeNode(10);
        TreeNode node4 = new TreeNode(5);
        TreeNode node5 = new TreeNode(7);
        TreeNode node6 = new TreeNode(9);
        TreeNode node7 = new TreeNode(11);

        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;

        ArrayList<ArrayList<Integer>> arrayLists = printBinaryTreeByZhiCharacter(node1);
        System.out.println(arrayLists);
    }
}