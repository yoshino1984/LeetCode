package com.yoshino.p501to600;

/**
 * 反转字符串中的单词III
 **/
public class P557ReverseWordsInAStringiii {

    public String reverseWords(String s) {
        if (s.length() < 2) {
            return s;
        }
        char[] chars = s.toCharArray();
        int index = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == ' ') {
                reverseStr(chars, index, i - 1);
                index = i + 1;
            }
        }
        if (chars[chars.length - 1] != ' ') {
            reverseStr(chars, index, s.length() - 1);
        }
        return String.valueOf(chars);
    }

    private void reverseStr(char[] chars, int start, int end) {
        while (start < end) {
            char temp = chars[start];
            chars[start] = chars[end];
            chars[end] = temp;
            start++;
            end--;
        }
    }
}
