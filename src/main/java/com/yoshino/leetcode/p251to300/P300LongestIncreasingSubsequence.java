package com.yoshino.leetcode.p251to300;

import java.util.Arrays;

/**
 * 最长上升子序列
 **/
public class P300LongestIncreasingSubsequence {

    /**
     * dp
     * 时间复杂度O(N^2)
     */
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int max = 0;

        for (int i = 1; i < nums.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    /**
     * dp
     * 时间复杂度O(N^2)
     */
    public int lengthOfLIS2(int[] nums) {
        int[] tails = new int[nums.length];
        int res = 0;
        for (int num : nums) {
            int low = 0, high = res;
            while (low < high) {
                int mid = low + (high - low) / 2;
                if (tails[mid] < num) {
                    low = mid + 1;
                } else {
                    high = mid;
                }
            }
            tails[low] = num;
            if (res == low) {
                res++;
            }
        }
        return res;
    }
}
