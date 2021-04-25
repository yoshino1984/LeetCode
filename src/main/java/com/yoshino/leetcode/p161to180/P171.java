package com.yoshino.leetcode.p161to180;

/**
 * @author wangxin
 * 2021/4/13 11:57
 * @since
 **/
public class P171 {

    public int titleToNumber(String columnTitle) {
        int result = 0;
        for (int i = 0; i < columnTitle.length(); i++) {
            result = result * 26 + (columnTitle.charAt(i) - 'A' + 1);
        }
        return result;
    }
}
