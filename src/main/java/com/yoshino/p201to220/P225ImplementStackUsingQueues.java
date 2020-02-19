package com.yoshino.p201to220;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Optional;

/**Implement Stack using Queues*/
public class P225ImplementStackUsingQueues {
}

class MyStack {

    private Deque<Integer> deque;

    /** Initialize your data structure here. */
    public MyStack() {
        deque = new LinkedList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        deque.add(x);
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        int last = deque.getLast();
        deque.removeLast();
        return last;
    }

    /** Get the top element. */
    public int top() {
        return deque.getLast();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return deque.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */