package com.yoshino.leetcode.p651to700;

import java.util.Arrays;

/**
 * 划分为k个相等的子集
 *
 * @author wangxin
 * 2020/5/3 15:51
 * @since
 **/
public class P698PartitionToKEqualSumSubsets {

    public boolean canPartitionKSubsets(int[] nums, int k) {
        long sum = 0L;
        for (int num : nums) {
            sum += num;
        }
        if (sum % k != 0) {
            return false;
        }
        int avg = (int)(sum / (long)k);
        Arrays.sort(nums);
        return false;
    }


}
