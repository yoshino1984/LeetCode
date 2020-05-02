package com.yoshino.p661to700;

import java.util.*;

/**
 * 棒球比赛
 */
public class P682BaseballGame {

    public static int calPoints(String[] ops) {
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        stack.push(0);
        for (String s : ops) {
            if ("+".equals(s)) {
                Integer point1 = stack.pop();
                Integer point2 = stack.pop();
                stack.push(point2);
                stack.push(point1);
                stack.push(point1 + point2);
            } else if ("D".equals(s)) {
                stack.push(stack.peek() * 2);
            } else if ("C".equals(s)) {
                stack.pop();
            } else {
                stack.push(Integer.valueOf(s));
            }
        }
        return stack.stream().reduce(0, Integer::sum);
    }

    public static void main(String[] args) {
        System.out.println(calPoints(new String[]{"5","-2","4","C","D","9","+","+"}));
    }


}
