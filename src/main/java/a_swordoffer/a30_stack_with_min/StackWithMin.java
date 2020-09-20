package a_swordoffer.a30_stack_with_min;

import java.util.Stack;

/**
 * @program: swordofferjava
 * @description: 包含min函数的栈
 * @author: Jin Hongjian
 * @create: 2020-09-20
 **/
public class StackWithMin {
    private Stack<Integer> data;
    private Stack<Integer> min;

    public StackWithMin() {
        data = new Stack<>();
        min = new Stack<>();
    }

    public void push(int node) {
        data.push(node);
        if (min.empty()) {
            min.push(node);
        } else {
            min.push(node < min.peek() ? node : min.peek());
        }
    }

    public void pop() {
        if (!data.empty()) {
            data.pop();
            min.pop();
        }
    }

    public int top() {
        if (!data.empty()) {
            return data.peek();
        } else {
            return 0;
        }
    }

    public int min() {
        if (!min.empty()) {
            return min.peek();
        } else {
            return 0;
        }
    }
}
