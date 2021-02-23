package com.yoshino.leetcode.p221top250;

import java.util.Stack;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 基本计算器（假设所给定的表达式都是有效的）
 * 单元优先级计算 //考虑使用解释器模式优化代码
 * 时间复杂度O(N)
 *
 * @author wangxin
 * 2020/5/2 20:44
 * @since
 **/
public class P224BasicCalculator {


    public int calculate(String s) {
        int ans = 0;
        if (s == null || s.length() == 0) {
            return ans;
        }
        ans = getUnitAns(s, new AtomicInteger());
        return ans;
    }

    int getUnitAns(String s, AtomicInteger index) {
        Stack<String> stack = new Stack<>();
        while (s.length() > index.get()) {
            char item = s.charAt(index.get());
            if (isNum(item)) {
                int startIndex = index.get();
                while (index.get() + 1 < s.length() && isNum(s.charAt(index.get() + 1))) {
                    index.incrementAndGet();
                }
                index.incrementAndGet();
                processNum(stack, s.substring(startIndex, index.get()));
//            stack
            } else if (item == ')'){
                index.incrementAndGet();
                return getAns(stack);
            } else if (item == '('){
                index.incrementAndGet();
                processNum(stack, String.valueOf(getUnitAns(s, index)));
            } else if (item == ' ') {
                index.incrementAndGet();
            } else {
                index.incrementAndGet();
                stack.push(String.valueOf(item));
            }
        }
        return getAns(stack);
    }

    private boolean isNum(char item) {
        return item >= '0' && item <= '9';
    }

    private void processNum(Stack<String> stack, String item) {
        if (stack.isEmpty()) {
            stack.push(String.valueOf(item));
        } else {
            int sum = calculate(stack.pop(), stack.pop(), item);
            stack.push(String.valueOf(sum));
        }
    }

    private int getAns(Stack<String> stack) {
        return stack.isEmpty() ? 0 : Integer.parseInt(stack.pop());
    }


    private Integer calculate(String operator, String num1, String num2) {
        if ("+".equals(operator)) {
            return Integer.parseInt(num1) + Integer.parseInt(num2);
        } else {
            return Integer.parseInt(num1) - Integer.parseInt(num2);
        }
    }

    public static void main(String[] args) {
        System.out.println(new P224BasicCalculator().calculate("(1+(4+5+2)-3)+(6+8)"));
        System.out.println(new P224BasicCalculator().calculate("1 + 1"));
        System.out.println(new P224BasicCalculator().calculate(" 22-1 + 2 "));
    }
}
