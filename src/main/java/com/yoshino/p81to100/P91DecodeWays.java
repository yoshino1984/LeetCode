package com.yoshino.p81to100;

public class P91DecodeWays {

    /**
     * 动态规划：需要特殊考虑0的情况
     * 动态转移方程
     * 时间复杂度O(N)
     * @param s
     * @return
     */
    public static int numDecodings(String s) {
        if (s.charAt(0) == '0') {
            return 0;
        }
        int len = s.length();
        int[] dp = new int[len + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= len; i++) {
            if (s.charAt(i - 2) == '0') {
                if (s.charAt(i - 1) != '0') {
                    dp[i] = dp[i - 1];
                } else {
                    return 0;
                }
            } else if (s.charAt(i - 1) == '0'){
                if (Integer.valueOf(s.substring(i - 2, i)) < 27) {
                    dp[i] = dp[i - 2];
                } else {
                    return 0;
                }
            } else {
                if (Integer.valueOf(s.substring(i - 2, i)) < 27) {
                    dp[i] = dp[i - 2] + dp[i - 1];
                } else {
                    dp[i] = dp[i - 1];
                }
            }

        }
        return dp[len];
    }

    public static void main(String[] args) {
        System.out.println(numDecodings("12"));
        System.out.println(numDecodings("226"));
        System.out.println(numDecodings("12330125"));
        System.out.println(numDecodings("12320125"));
    }

}
