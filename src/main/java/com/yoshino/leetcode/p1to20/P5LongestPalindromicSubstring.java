package com.yoshino.leetcode.p1to20;

public class P5LongestPalindromicSubstring {

    /**
     * dp
     * 时间复杂度O(N^2)
     */
    public static String longestPalindrome(String s) {
        int len = s.length(), start = 0, maxLen = 0;
        boolean[][] dp = new boolean[len][len];

        for (int i = len - 1; i >= 0; i--) {
            for (int j = i; j < len; j++) {
                if (s.charAt(i) != s.charAt(j)) {
                    dp[i][j] = false;
                } else {
                    dp[i][j] = j - i < 2 || dp[i + 1][j - 1];
                }
                if (dp[i][j] && (j - i + 1 > maxLen)) {
                    maxLen = j - i + 1;
                    start = i;
                }
            }
        }

        return s.substring(start, start + maxLen);
    }

    /**
     * 中心扩展算法
     */
    public String longestPalindrome2(String s) {
        if (s == null || s.length() < 1) {
            return "";
        }
        int start = 0, maxLen = 0;
        char[] chars = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(chars, i, i);
            int len2 = expandAroundCenter(chars, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > maxLen) {
                start = i - (len - 1) / 2;
                maxLen = len;
            }
        }
        return s.substring(start, start + maxLen);
    }

    private int expandAroundCenter(char[] chars, int left, int right) {
        while (left >= 0 && right < chars.length && chars[left] == chars[right]) {
            left--;
            right++;
        }
        return right - left - 1;
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
