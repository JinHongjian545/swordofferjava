package a_swordoffer.a31_stack_in_and_out;

import java.util.Stack;

/**
 * @program: swordofferjava
 * @description: 栈的压入，弹出序列
 * @author: Jin Hongjian
 * @create: 2020-09-20
 **/
public class StackInAndOut {
    static boolean IsPopOrder(int[] pushA, int[] popA) {
        if (pushA == null || popA == null) {
            return false;
        }
        Stack<Integer> stack = new Stack<>();
        int index = 0;
        for (int i = 0; i < pushA.length; i++) {
            stack.push(pushA[i]);
            while (!stack.isEmpty() && stack.peek() == popA[index]) {
                stack.pop();
                index++;
            }
        }
        return stack.empty();
    }
}
