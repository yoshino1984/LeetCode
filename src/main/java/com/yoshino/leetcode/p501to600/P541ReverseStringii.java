package com.yoshino.leetcode.p501to600;

/**
 * 反转字符串ii
 **/
public class P541ReverseStringii {

    public String reverseStr(String s, int k) {
        char[] chArr = s.toCharArray();
        int index = 0;

        while (index < s.length()) {
            int limit = Math.min(s.length() - 1, index + k - 1);
            reverseStr(chArr, index, limit);
            index = limit + k + 1;
        }
        return String.valueOf(chArr);
    }

    private void reverseStr(char[] chArr, int start, int end) {
        while (start < end) {
            char temp = chArr[start];
            chArr[start] = chArr[end];
            chArr[end] = temp;
            start++;
            end--;
        }
    }
}
