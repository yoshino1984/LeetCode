package com.yoshino.leetcode.p201to220;

/**
 * 长度最小的子数组
 **/
public class P209MinimumSizeSubarraySum {

    public int minSubArrayLen(int s, int[] nums) {
        if (nums.length == 0 || s == 0) {
            return 0;
        }
        int sum = 0;
        int left = 0, right = 0;
        int min = Integer.MAX_VALUE;
        while (right < nums.length) {
            sum += nums[right++];
            if (sum >= s) {
                while (sum >= s) {
                    sum -= nums[left++];
                }
                min = Math.min(right - left + 1, min);
            }
        }

        return min == Integer.MAX_VALUE ? 0 : min;
    }
}
