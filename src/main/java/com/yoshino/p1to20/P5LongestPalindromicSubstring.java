package com.yoshino.p1to20;

public class P5LongestPalindromicSubstring {

    public static String longestPalindrome(String s) {
        if (s.length() <= 1) {
            return s;
        }
        int strSize = s.length();
        int maxIndex = 0;
        int maxCount = 1;
        boolean[][] dp = new boolean[strSize][strSize];
        // 初始化
        for (int i = 0; i < strSize; i++) {
            dp[i][i] = true;
        }
        dp[strSize - 1][strSize - 1] = true;

        for (int i = 0; i < strSize - 1; i++) {
            dp[i][i + 1] = s.charAt(i) == s.charAt(i + 1);
            if (dp[i][i + 1]) {
                maxIndex = i;
                maxCount = 2;
            }
        }
        for (int length = 2; length < strSize; length++) {
            for (int i = 0; i + length < strSize; i++) {
                dp[i][i + length] = dp[i + 1][i + length - 1] && s.charAt(i) == s.charAt(i + length);
                if (dp[i][i + length]) {
                    maxIndex = i;
                    maxCount = length + 1;
                }
            }
        }
        return s.substring(maxIndex, maxIndex + maxCount);
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("bbbbacacabbbbb"));
        System.out.println(longestPalindrome("babad"));
        System.out.println(longestPalindrome("cbbd"));
        System.out.println(longestPalindrome("cc"));
        System.out.println(longestPalindrome("c"));
        System.out.println(longestPalindrome(""));
    }

}
