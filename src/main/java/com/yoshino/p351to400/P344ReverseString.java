package com.yoshino.p351to400;

import com.alibaba.fastjson.JSON;

public class P344ReverseString {

    public static void reverseString(char[] s) {
        int size = s.length / 2;
        char temp;
        for (int i = 0; i < size; i++) {
            temp = s[s.length - i - 1];
            s[s.length - i - 1] = s[i];
            s[i] = temp;
        }
    }

    public static void main(String[] args) {
        char[] s = new char[] {'h', 'e', 'l', 'l', 'o'};
        reverseString(s);
        System.out.println(JSON.toJSONString(s));
        char[] s1 = new char[] {'h'};
        reverseString(s1);
        System.out.println(JSON.toJSONString(s1));
        char[] s2 = new char[] {};
        reverseString(s2);
        System.out.println(JSON.toJSONString(s2));

    }

}
