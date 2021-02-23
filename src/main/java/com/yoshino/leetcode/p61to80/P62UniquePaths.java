package com.yoshino.leetcode.p61to80;

public class P62UniquePaths {

    public int uniquePaths(int m, int n) {
        int[] dp = new int[m];
        dp[0] = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (j > 0) {
                    dp[j] += dp[j - 1];
                }
            }
        }
        return dp[m - 1];
    }

    public static void main(String[] args) {
        System.out.println(new P62UniquePaths().uniquePaths(0, 0));
    }

}
