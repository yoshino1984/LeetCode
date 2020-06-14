package com.yoshino.p121top140;

public class P122BestTimeToBuyAndSellStockii {

    /**
     * 没有交易成本，直接贪心解法
     * 时间复杂度 O(N)
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int max = 0;
        for (int i = 1; i < prices.length; i++) {
            max += Math.max(0, prices[i] - prices[i - 1]);
        }
        return max;
    }

}
