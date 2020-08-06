package com.yoshino.p101to120;

import java.util.Arrays;

/**
 * 不同的子序列
 **/
public class P115DistinctSubsequences {

    public int numDistinct(String s, String t) {
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        int[][] dp = new int[s.length() + 1][t.length() + 1];
        for (int i = 0; i <= s.length(); i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= t.length(); j++) {
                dp[i][j] = dp[i - 1][j] + (sChars[i - 1] == tChars[j - 1] ? dp[i - 1][j - 1] : 0);
            }
        }
        return dp[s.length()][t.length()];
    }

    public static void main(String[] args) {
        new P115DistinctSubsequences().numDistinct("rabbbit", "rabbit");
    }
}
