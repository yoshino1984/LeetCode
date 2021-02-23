package com.yoshino.leetcode.p251to300;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P279PerfectSquares {

    static List<Long> array = new ArrayList<>();

    /**
     * 动态规划的方法
     * 时间复杂度O(N^(3/2))
     * @param n
     * @return
     */
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; i - j * j >= 0; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(new P279PerfectSquares().numSquares(12));
        System.out.println(new P279PerfectSquares().numSquares(13));
        System.out.println(new P279PerfectSquares().numSquares(25));
        System.out.println(new P279PerfectSquares().numSquares(1000));
        System.out.println(Integer.MAX_VALUE - 1);
    }

}
