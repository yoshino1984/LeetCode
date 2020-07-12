package com.yoshino.P401to450;

/**
 * 分割数组的最大值
 **/
public class P410SplitArrayLargestSum {

    /**
     * 动态规划
     * @param nums
     * @param m
     * @return
     */
    public int splitArrayDp(int[] nums, int m) {
        int n = nums.length;
        int[][] dp = new int[n + 1][m + 1];
        int[] sub = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }
        for (int i = 0; i < n; i++) {
            sub[i + 1] = sub[i] + nums[i];
        }

        dp[0][0] = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                for (int k = j - 1; k < i; k++) {
                    dp[i][j] = Math.min(dp[i][j], Math.max(dp[k][j - 1], sub[i] - sub[k]));
                }
            }
        }

        return dp[n][m];
    }
}
