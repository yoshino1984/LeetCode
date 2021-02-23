package com.yoshino.leetcode.P401to450;

import java.util.ArrayList;
import java.util.List;

/**
 * 字符串相加
 *
 * @author wangxin
 * 2020/8/3 23:40
 * @since
 **/
public class P415AddStrings {

    public String addStrings(String num1, String num2) {
        List<Character> ans = new ArrayList<>();

        int len1 = num1.length(), len2 = num2.length();
        int len = Math.max(len1, len2);
        int last = 0;
        for (int i = 0; i < len; i++) {
            int v1 = i >= num1.length() ? 0 : num1.charAt(len1 - i - 1) - '0';
            int v2 = i >= num2.length() ? 0 : num2.charAt(len2 - i - 1) - '0';
            int sum = v1 + v2 + last;
            ans.add((char) ('0' + sum % 10));
            last = sum / 10;
        }
        if (last == 1) {
            ans.add('1');
        }

        char[] chars = new char[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            chars[i] = ans.get(ans.size() - i - 1);
        }

        return ans.size() == 0 ? "0" : String.valueOf(chars);
    }

    public static void main(String[] args) {
        System.out.println(new P415AddStrings().addStrings("10", "0"));
    }
}
