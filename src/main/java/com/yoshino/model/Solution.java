package com.yoshino.model;

import java.util.Arrays;

/**
 * 刻意练习地方
 **/
class Solution {

    public String reverseWords(String s) {
        s = s.trim();
        int blankCnt = 0, wordCnt = 0, index = 0, len = 0;
        char[] chars = s.toCharArray();
        reverseStr(chars, 0, chars.length - 1);
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == ' ') {
                blankCnt++;
                if (chars[i - 1] != ' ') {
                    wordCnt++;
                    reverseStr(chars, i - len, i - 1);
                    System.arraycopy(chars, i - len, chars, index, len);
                    index += len + 1;
                    chars[index - 1] = ' ';
                    len = 0;
                }
            } else {
                len++;
            }
        }

        reverseStr(chars, chars.length - len, chars.length - 1);
        System.arraycopy(chars, chars.length - len, chars, index, len);

        return String.valueOf(chars).substring(0, s.length() + wordCnt - blankCnt);
    }

    private void reverseStr(char[] chars, int l, int r) {
        while (l < r) {
            char temp = chars[l];
            chars[l] = chars[r];
            chars[r] = temp;
            l++;
            r--;
        }
    }

    public static void main(String[] args) {
        new Solution().reverseWords("a good   example");
    }

}