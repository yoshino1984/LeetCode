package com.yoshino.p1to20;

import java.util.*;

public class P20ValidParentheses {
    public boolean isValid(String s) {
        if (s == null || s.isEmpty()) {
            return true;
        }
        Map<Character, Character> map = new HashMap<>(4);
        map.put('}', '{');
        map.put(']', '[');
        map.put(')', '(');
        Deque<Character> deque = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            Character s1 = s.charAt(i);
            Character s2 = map.get(s1);
            if (s2 == null) {
                deque.push(s1);
            } else if (deque.isEmpty() || !s2.equals(deque.pop())){
                return false;
            }
        }
        return deque.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(new P20ValidParentheses().isValid("()"));
    }
}
