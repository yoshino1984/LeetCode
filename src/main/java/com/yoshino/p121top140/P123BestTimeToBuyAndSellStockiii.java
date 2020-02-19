package com.yoshino.p121top140;

public class P123BestTimeToBuyAndSellStockiii {

    /**
     *
     * @param prices
     * @return
     */
    public static int maxProfit(int[] prices) {
        int daySize = prices.length;
        if (daySize <= 1) {
            return 0;
        }
        int[][][] dp = new int[2][2][daySize + 1];
        dp[0][0][1] = 0;
        dp[1][0][1] = -prices[1];
        dp[0][1][0] = 0;
        dp[1][1][0] = -prices[0];

        for (int i = 1; i <= daySize; i++) {
            if (i > 1) {
                dp[0][0][i] = Math.max(dp[0][0][i - 1], dp[1][0][i - 1] + prices[i - 1]);
                dp[1][0][i] = Math.max(dp[1][0][i - 1], dp[0][1][i - 1] - prices[i - 1]);
            }
            dp[0][1][i] = Math.max(dp[0][1][i - 1], dp[1][1][i - 1] + prices[i - 1]);
            dp[1][1][i] = Math.max(dp[1][1][i - 1], -prices[i - 1]);
        }
        return Math.max(dp[0][0][daySize], dp[0][1][daySize]);
    }

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{3,3,5,0,0,3,1,4}));
        System.out.println(maxProfit(new int[]{1,2,3,4,5}));
        System.out.println(maxProfit(new int[]{7,6,4,3,1}));
        System.out.println(maxProfit(new int[]{6,7}));
        System.out.println(maxProfit(new int[]{6,7,8}));
        System.out.println(maxProfit(new int[]{6,7,8,9}));
    }

}
