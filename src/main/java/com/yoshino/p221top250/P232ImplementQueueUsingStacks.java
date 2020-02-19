package com.yoshino.p221top250;

import java.util.Stack;

public class P232ImplementQueueUsingStacks {
    public static void main(String[] args) {

    }
}

class MyQueue {

    private Stack<Integer> input;
    private Stack<Integer> output;
    /** Initialize your data structure here. */
    public MyQueue() {
        input = new Stack<>();
        output = new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        input.push(x);
        if (output.empty()) {
            moveInputToOutput();
        }
    }

    private void moveInputToOutput() {
        while (!input.empty()) {
            output.push(input.pop());
        }
    }
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if (!output.isEmpty()) {
            return output.pop();
        }
        if (!input.isEmpty()) {
            moveInputToOutput();
            return output.pop();
        }
        throw new IndexOutOfBoundsException();
    }

    /** Get the front element. */
    public int peek() {
        if (!output.isEmpty()) {
            return output.peek();
        }
        if (!input.isEmpty()) {
            moveInputToOutput();
            return output.peek();
        }
        throw new IndexOutOfBoundsException();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return output.isEmpty() && input.isEmpty();
    }
}
