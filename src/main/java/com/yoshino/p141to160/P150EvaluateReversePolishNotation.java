package com.yoshino.p141to160;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class P150EvaluateReversePolishNotation {

    /**
     * 使用栈 按照一定的出入栈规则即可
     *
     * @param tokens
     * @return
     */
    public static int evalRPN(String[] tokens) {
        if (tokens.length == 0) {
            return 0;
        }
        Set<String> operators = new HashSet<>(Arrays.asList("+", "-", "*", "/"));
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            if (operators.contains(token)) {
                stack.push(calculate(token, stack.pop(), stack.pop()));
            } else {
                stack.push(Integer.valueOf(token));
            }
        }
        return stack.pop();
    }

    private static int calculate(String operator, int val1, int val2) {
        int resVal = 0;
        switch (operator) {
            case "+" : resVal = val1 + val2; break;
            case "-" : resVal = val2 - val1; break;
            case "*" : resVal = val1 * val2; break;
            case "/" : resVal = val2 / val1; break;
        }
        return resVal;
    }

    public static void main(String[] args) {
        System.out.println(evalRPN(new String[]{"2", "1", "+", "3", "*"}));
        System.out.println(evalRPN(new String[]{"4", "13", "5", "/", "+"}));
        System.out.println(evalRPN(new String[]{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"}));
    }
}
