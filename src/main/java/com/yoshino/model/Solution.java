package com.yoshino.model;


import java.util.*;

/**
 * 刻意练习地方
 *
 * @author wangxin
 * 2020/6/11 20:51
 * @since
 **/
public class Solution {

    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;

        for (int i = 0; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (p.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i][j - 2] || (match(s, p, i, j - 1) && dp[i - 1][j]);
                } else {
                    if (match(s, p, i, j)) {
                        dp[i][j] = dp[i - 1][j - 1];
                    }
                }
            }
        }

        return dp[m][n];
    }

    private boolean match(String s, String p, int i, int j) {
        if (i == 0) {
            return false;
        }
        return p.charAt(j - 1) == '.' || p.charAt(j - 1) == s.charAt(i - 1);
    }

}
