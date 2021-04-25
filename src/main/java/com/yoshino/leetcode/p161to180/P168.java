package com.yoshino.leetcode.p161to180;

/**
 * @author wangxin
 * 2021/4/13 11:50
 * @since
 **/
public class P168 {
    public String convertToTitle(int n) {
        if (n <= 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            n--;
            sb.append((char) (n % 26 + 'A'));
            n /= 26;
        }
        return sb.reverse().toString();
    }
}
