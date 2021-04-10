package com.yoshino.leetcode.p41to60;

/**
 * @author wangxin
 * 2021/4/10 18:44
 * @since
 **/
public class P43 {
    public String multiply(String num1, String num2) {
        if ("0".equals(num1) || "0".equals(num2)) {
            return "0";
        }

        int m = num1.length(), n = num2.length();
        int[] resArr = new int[n + m];
        for (int i = m - 1; i >= 0; i--) {
            int x = num1.charAt(i) - '0';
            for (int j = n - 1; j >= 0; j--) {
                int y = num2.charAt(j) - '0';
                resArr[i + j + 1] += x * y;
            }
        }
        for (int i = m + n - 1; i > 0; i--) {
            resArr[i - 1] += resArr[i] / 10;
            resArr[i] %= 10;
        }
        int index = resArr[0] == 0 ? 1 : 0;
        StringBuilder result = new StringBuilder();
        while (index < m + n) {
            result.append(resArr[index++]);
        }

        return result.toString();
    }
}
