package com.yoshino.leetcode.p181to200;

public class P188BestTimeToBuyAndSellStockiv {

    /**
     * 动态规划解法 时间复杂度O(N)
     * 如果对k求解优化，对于k > daysize/2 的情况，可以直接无视k的影响，转换为以为数组求解，时间复杂度不变
     *
     * @param k
     * @param prices
     * @return
     */
    public static int maxProfit(int k, int[] prices) {
        int daySize = prices.length;
        if (daySize <= 1 || k == 0) {
            return 0;
        }
        if ( k > daySize / 2) {
            return otherMaxProfit(prices);
        }
        int [][] dp = new int[2][k];

        dp[1][0] = -prices[0];
        int initalSize = Math.min(daySize, k);
        for (int i = 1; 2 * i - 1 < initalSize; i++) {
            dp[1][i] = -prices[2 * i - 1];
        }

        for (int i = 1; i <= daySize; i++) {
            for (int j = Math.min(i / 2, k - 1); j > 0; j--) {
                dp[0][j] = Math.max(dp[0][j], dp[1][j] + prices[i - 1]);
                dp[1][j] = Math.max(dp[1][j], dp[0][j - 1] - prices[i - 1]);
            }
            dp[0][0] = Math.max(dp[0][0], dp[1][0] + prices[i - 1]);
            dp[1][0] = Math.max(dp[1][0], -prices[i - 1]);
        }

        int max = 0;
        for (int i = 0; i < k; i++) {
            max = Math.max(max, dp[0][i]);
        }
        return max;
    }

    private static int otherMaxProfit(int[] prices) {
        int day = prices.length;
        // 分别代表不持有股票和持有股票的情况
        int[] dp = new int[2];
        dp[1] = -prices[0];

        for (int i = 1; i <= day; i++) {
            int temp = dp[0];
            dp[0] = Math.max(dp[0], dp[1] + prices[i - 1]);
            dp[1] = Math.max(dp[1], temp - prices[i - 1]);
        }
        return dp[0];
    }

    public static void main(String[] args) {
        System.out.println(maxProfit(2, new int[]{2, 4, 1}));
        System.out.println(maxProfit(7, new int[]{3, 2, 6, 5, 0, 3}));
        System.out.println(maxProfit(1, new int[]{1, 2}));
    }
}
