package com.yoshino.leetcode.p901to950;

/**
 * 仅仅反转字母
 **/
public class P917ReverseOnlyLetters {
    public String reverseOnlyLetters(String S) {
        int start = 0, end = S.length() - 1;
        char[] chars = S.toCharArray();
        while (start < end) {
            if (!Character.isAlphabetic(chars[start])) {
                start++;
                continue;
            }
            if (!Character.isAlphabetic(chars[end])) {
                end--;
                continue;
            }
            char temp = chars[start];
            chars[start] = chars[end];
            chars[end] = temp;
            start++;
            end--;
        }

        return String.valueOf(chars);
    }
}
