package com.yoshino.leetcode.p121top140;

public class P121BestTimeToBuyAndSellStock {


    /**
     * 状态转移方程Max(, cur - min)
     * 时间复杂度：O(N)
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        int min = prices[0];
        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (min > prices[i]) {
                min = prices[i];
            }
            maxProfit = Math.max(maxProfit, prices[i] - min);
        }

        return maxProfit;
    }

}
