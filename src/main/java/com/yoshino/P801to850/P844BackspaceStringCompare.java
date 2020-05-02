package com.yoshino.P801to850;

import java.util.Stack;

/**
 * 比较退格的字符串：时间复杂度O(n) 一次遍历
 * @author wangxin
 * 2020/5/2 20:31
 * @since
 **/
public class P844BackspaceStringCompare {

    public static void main(String[] args) {
        System.out.println(getStackWithoutBackspace("y#fo##f"));
        System.out.println(getStackWithoutBackspace("y#f#o##f"));
    }

    public boolean backspaceCompare(String S, String T) {
        Stack<Character> stack1 = getStackWithoutBackspace(S);
        Stack<Character> stack2 = getStackWithoutBackspace(T);
        return compareStack(stack1, stack2);
    }

    private static Stack<Character> getStackWithoutBackspace(String S) {
        char backspace = '#';
        Stack<Character> stack = new Stack<>();
        for (char s : S.toCharArray()) {
            if (s == backspace) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.push(s);
            }
        }
        return stack;
    }

    private boolean compareStack(Stack<Character> stack1, Stack<Character> stack2) {
        while (!stack1.isEmpty() && !stack2.isEmpty()) {
            if (!stack1.pop().equals(stack2.pop())) {
                return false;
            }
        }
        return stack1.isEmpty() && stack2.isEmpty();
    }
}
