package com.yoshino.leetcode.p181to200;

/**
 * 打家劫舍
 **/
public class P198HouseRobber {

    /**
     * dp 维持两个状态
     * 时间复杂度O(N)
     * 空间复杂度O(N)
     */
    public int rob1(int[] nums) {
        int len = nums.length;
        int[][] dp = new int[len + 1][2];
        for (int i = 1; i <= len; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);
            dp[i][1] = dp[i - 1][0] + nums[i - 1];
        }

        return Math.max(dp[len][0], dp[len][1]);
    }

    /**
     * dp 简化无关变量
     * 时间复杂度O(N)
     * 空间复杂度O(1)
     */
    public int rob2(int[] nums) {
        int len = nums.length;
        int first = 0, second = 0;
        for (int num : nums) {
            int third = Math.max(first + num, second);
            first = second;
            second = third;
        }

        return second;
    }


}
