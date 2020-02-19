package com.yoshino.p61to80;

public class P62UniquePaths {

    public int uniquePaths(int m, int n) {

        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                dp[i][j] = Math.max(dp[i - 1][j] + dp[i][j - 1], 1);
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        System.out.println(new P62UniquePaths().uniquePaths(0, 0));
    }

}
