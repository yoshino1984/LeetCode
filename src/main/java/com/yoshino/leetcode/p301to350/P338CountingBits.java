package com.yoshino.leetcode.p301to350;

import com.alibaba.fastjson.JSON;

public class P338CountingBits {

    /**
     * 动态规划：O(N)
     * dp[i] = dp[i - 2^n] + 1(n岁数字的增加而变大)
     * @param num
     * @return
     */
    public int[] countBits(int num) {
        int[] dp = new int[num + 1];
        int curN = 0;
        for (int i = 1; i < num + 1; ) {
            int size = (int) Math.min(num, Math.pow(2, curN + 1) - 1);
            int base = (int) Math.pow(2, curN);
            for (; i <= size; i++) {
                dp[i] = dp[i - base] + 1;
            }
            curN++;
        }
        return dp;
    }

    public static void main(String[] args) {
        System.out.println(JSON.toJSONString(new P338CountingBits().countBits(0)));
        System.out.println(JSON.toJSONString(new P338CountingBits().countBits(1)));
        System.out.println(JSON.toJSONString(new P338CountingBits().countBits(2)));
        System.out.println(JSON.toJSONString(new P338CountingBits().countBits(3)));
        System.out.println(JSON.toJSONString(new P338CountingBits().countBits(4)));
        System.out.println(JSON.toJSONString(new P338CountingBits().countBits(5)));
    }

}
