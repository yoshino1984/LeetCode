package com.yoshino.leetcode.p41to60;

/**
 * 跳跃游戏
 *
 * @author wangxin
 * 2020/6/14 18:22
 * @since
 **/
public class P55JumpGame {

    /**
     * 倒序贪心，唯一一个能够抵达最后位置的一个节点的最开始值
     * 时间复杂度O(N)
     * 空间复杂度O(1)
     * @param nums
     * @return
     */
    public boolean canJump(int[] nums) {
        int reachedEnableIndex = nums.length - 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] + i >= reachedEnableIndex) {
                reachedEnableIndex = i;
            }
        }
        return reachedEnableIndex == 0;
    }

    /**
     * bfs解法 尝试所有可达的节点更新能够抵达节点的最大值，循环判断直到终止
     * 时间复杂度O(N)
     * 空间复杂度O(1)
     * @param nums
     * @return
     */
    public boolean canJump1(int[] nums) {
        int rightMax = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > rightMax) {
                return false;
            } else {
                rightMax = Math.max(rightMax, nums[i] + i);
            }
        }
        return true;
    }

}
