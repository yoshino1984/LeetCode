package com.yoshino.p141to160;

import java.util.Stack;

/**
 * 最小栈
 *
 * @author wangxin
 * 2020/5/2 20:29
 * @since
 **/
public class P155MinStack {
}

class MinStack {

    Stack<Integer> stack;
    Stack<Integer> minStack;


    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
        if (minStack.empty() || x <= minStack.peek()) {
            minStack.push(x);
        }
    }

    public void pop() {
        if (stack.empty()) {
            return;
        }
        int temp = stack.pop();
        if (temp == minStack.peek()) {
            minStack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */