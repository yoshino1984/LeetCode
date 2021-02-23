package com.yoshino.leetcode.p41to60;

/**
 * 跳跃游戏ii
 *
 * @author wangxin
 * 2020/6/14 18:34
 * @since
 **/
public class P45JumpGameii {

    /**
     * 时间复杂度O(N)
     * 空间复杂度O(1)
     * @param nums
     * @return
     */
    public int jump(int[] nums) {
        int len = nums.length;
        // 下一层跳所能达到的最右节点
        int maxPosition = 0;
        // 当前层所能到达的最右节点
        int end = 0;
        int step = 0;
        for (int i = 0; i < len - 1; i++) {
            maxPosition = Math.max(nums[i] + i, maxPosition);
            if (i == end) {
                end = maxPosition;
                step++;
            }
        }

        return step;
    }

    public static void main(String[] args) {
        new P45JumpGameii().jump(new int[]{2,3,1,1,4});
    }
}
