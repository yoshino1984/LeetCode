package com.yoshino.p651to700;

/**
 * 验证回文字符串II
 **/
public class P680ValidPalindromeii {
    public boolean validPalindrome(String s) {
        int len = s.length(), start = 0, end = len - 1;
        char[] chars = s.toCharArray();

        while (start < end) {
            if (chars[start] == chars[end]) {
                start++;
                end--;
            } else {
                return isPalindrome(chars, start + 1, end) || isPalindrome(chars, start, end - 1);
            }
        }
        return true;
    }

    private boolean isPalindrome(char[] chars, int i, int j) {
        while (i < j) {
            if (chars[i] != chars[j]) {
                return false;
            } else {
                i++;
                j--;
            }
        }
        return true;
    }
}
