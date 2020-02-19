package com.yoshino.p81to100;

public class P96UniqueBinarySearchTrees {

    /**
     * 1 ... i ... n 一个序列 = dp[i - 1] * dp[n - i]
     * 将每个元素作为分割点一次，计算出的综合即当前二叉搜索树的可能性
     * @param n
     * @return
     */
    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }
        return dp[n];
    }


}
