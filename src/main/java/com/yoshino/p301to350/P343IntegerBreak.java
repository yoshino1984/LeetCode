package com.yoshino.p301to350;

/**
 * 整数拆分
 **/
public class P343IntegerBreak {

    public int integerBreak(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            for (int j = i - 1; j >= 1; j--) {
                dp[i] = Math.max(dp[i], Math.max(dp[j], j) * (i - j));
            }
        }

        return dp[n];
    }
}
