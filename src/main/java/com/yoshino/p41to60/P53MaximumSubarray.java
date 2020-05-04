package com.yoshino.p41to60;

/**
 * 最大子序和
 *
 * @author wangxin
 * 2020/5/3 23:32
 * @since
 **/
public class P53MaximumSubarray {

    /**
     * 动态规划解法
     * 时间复杂度O(N)
     */
    public static int maxSubArray1(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int lastMaxSub = nums[0];
        int ret = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int curMaxSub = lastMaxSub < 0 ? nums[i] : lastMaxSub + nums[i];
            ret = Math.max(curMaxSub, ret);
            lastMaxSub = curMaxSub;
        }
        return ret;
    }

    public static void main(String[] args) {
        System.out.println(maxSubArray1(new int[] {-2,1,-3,4,-1,2,1,-5,4}));
    }
}
