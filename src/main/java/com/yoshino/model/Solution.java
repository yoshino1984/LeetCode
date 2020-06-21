package com.yoshino.model;


import java.util.*;

/**
 * 刻意练习地方
 *
 * @author wangxin
 * 2020/6/11 20:51
 * @since
 **/
public class Solution {

    public int coinChange(int[] coins, int amount) {
        if (amount < 1) {
            return 0;
        }

        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }

}
