package com.yoshino.p701to750;

public class P714BestTimeToBuyAndSellStockWithTransactionFee {

    /**
     * 动态规划：时间复杂度O(N)
     * 仔细分析状态机的转移，（当前持有，则只能变成卖出变成不持有或者继续持有两种状态）
     * 已经其实时刻的状态机应该的值
     *
     * @param prices
     * @param fee
     * @return
     */
    public static int maxProfit(int[] prices, int fee) {
        int day = prices.length;
        // 分别代表不持有股票和持有股票的情况
        int[] dp = new int[2];
        dp[1] = -prices[0];

        for (int i = 1; i <= day; i++) {
            int temp = dp[0];
            dp[0] = Math.max(dp[0], dp[1] + prices[i - 1] - fee);
            dp[1] = Math.max(dp[1], temp - prices[i - 1]);
        }

        return dp[0];
    }

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{1,3,2,8,4,9}, 2));
    }
}
