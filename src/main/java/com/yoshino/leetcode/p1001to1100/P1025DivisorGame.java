package com.yoshino.leetcode.p1001to1100;

/**
 * 除数博弈
 **/
public class P1025DivisorGame {

    /**
     * 动态规划，如果在自己操作完之后，能使得对方处于必输的位置，则当前处于必胜的位置，否则处于必输的位置。
     * @param N
     * @return
     */
    public boolean divisorGame(int N) {
        boolean[] dp = new boolean[N + 2];
        dp[1] = false;
        dp[2] = true;
        for (int i = 3; i <= N; i++) {
            for (int x = 1; x <= i / 2; x++) {
                if (i % x == 0 && !dp[i - x]) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[N];
    }
}
