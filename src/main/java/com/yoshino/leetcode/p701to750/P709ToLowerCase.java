package com.yoshino.leetcode.p701to750;

/**
 * 转换成小写字母
 **/
public class P709ToLowerCase {

    public String toLowerCase(String str) {
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] >= 'A' && chars[i] <= 'Z') {
                chars[i] = (char) (chars[i] - 'A' + 'a');
            }
        }
        return String.valueOf(chars);
    }
}
