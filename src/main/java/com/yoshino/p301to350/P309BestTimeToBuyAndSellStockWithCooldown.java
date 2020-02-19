package com.yoshino.p301to350;

public class P309BestTimeToBuyAndSellStockWithCooldown {

    /**
     * 动态规划
     * 当前持有状态只能从昨天的持有或者前天的不持有状态转移过来（冷冻）
     * 时间复杂度O(N)
     * @param prices
     * @return
     */
    public static int maxProfit(int[] prices) {
        int daySize = prices.length;
        if (daySize <= 1) {
            return 0;
        }
        int[][] dp = new int[2][daySize + 1];
        dp[0][0] = 0;
        dp[1][0] = -prices[0];

        dp[0][1] = Math.max(dp[0][0], dp[1][0] + prices[0]);
        dp[1][1] = Math.max(dp[1][0], - prices[0]);
        for (int i = 2; i <= daySize; i++) {
            dp[0][i] = Math.max(dp[0][i - 1], dp[1][i - 1] + prices[i - 1]);
            dp[1][i] = Math.max(dp[1][i - 1], dp[0][i - 2] - prices[i - 1]);
        }
        return dp[0][daySize];
    }

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{1, 2, 3, 0, 2}));
        System.out.println(maxProfit(new int[]{1}));
        System.out.println(maxProfit(new int[]{}));
        System.out.println(maxProfit(new int[]{1,2}));
    }

}
