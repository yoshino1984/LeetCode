package com.yoshino.p201to220;

/**
 * 打家劫舍2
 **/
public class P213HouseRobberii {

    /**
     * 动态规划 因为是循环数组，因此第一家或者最后一家只能偷一家， ans = Math.max(max(1,len - 1), max(2, len))
     * 即将 循环队列遍历转换成了两次单队列的遍历
     * 时间间复杂度O(N)
     * 空间复杂度O(1)
     * @param nums
     * @return
     */
    public int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        return Math.max(rob(nums, 0, nums.length - 2),
            rob(nums, 1, nums.length - 1));
    }

    private int rob(int[] nums, int start, int end) {
        int first = 0, second = 0;
        for (int i = start; i <= end; i++) {
            int third = Math.max(first + nums[i], second);
            first = second;
            second = third;
        }
        return second;
    }

}
