package com.yoshino.leetcode.offer;

/**
 * 表示数值的字符串
 **/
public class P20BiaoShiShuZhiDeZiFuChuanLcof {


    public boolean isNumber(String s) {
        s = s.trim();
        boolean isNum = false, isDot = false, isE = false;
        char[] chars = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            char ch = chars[i];
            if (ch >= '0' && ch <= '9') {
                isNum = true;
            } else if (ch == '.') {
                if (isE || isDot) {
                    return false;
                }
                isDot = true;
            } else if (ch == 'e' || ch == 'E') {
                if (!isNum || isE) {
                    return false;
                }
                isE = true;
                isNum = false;
            } else if (ch == '-' || ch == '+') {
                if (i != 0 && chars[i - 1] != 'e' && chars[i - 1] != 'E') {
                    return false;
                }
            } else {
                return false;
            }
        }
        return isNum;
    }
}
