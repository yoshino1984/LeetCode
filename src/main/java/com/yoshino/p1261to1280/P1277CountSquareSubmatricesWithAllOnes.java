package com.yoshino.p1261to1280;

public class P1277CountSquareSubmatricesWithAllOnes {

    /**
     * 动态规划，如果dp[i][j] 定义为 以(i,j)为右下角，不同length的正方形的数量
     * dp[i][j] = min(dp[i-1][j-1], dp[i-1][j], dp[i][j-1]) + 1;
     * @param matrix
     * @return
     */
    public int countSquares(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    if (matrix[i][j] != 0) {
                        ans++;
                    }
                    continue;
                }
                if (matrix[i][j] == 0) {
                    continue;
                }
                matrix[i][j] = Math.min(Math.min(matrix[i - 1][j - 1], matrix[i - 1][j]), matrix[i][j - 1]) + 1;
                ans += matrix[i][j];
            }
        }
        return ans;
    }

}
