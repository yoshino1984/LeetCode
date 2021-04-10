package com.yoshino.leetcode.p61to80;

/**
 * @author wangxin
 * 2021/4/6 21:25
 * @since
 **/
public class P80 {

    public int removeDuplicates(int[] nums) {
        int index = Math.min(2, nums.length);
        for (int i = index; i < nums.length; i++) {
            if (nums[index - 2] != nums[i]) {
                swap(nums, index++, i);
            }
        }

        return index;
    }

    private void swap(int[] nums, int i1, int i2) {
        int temp = nums[i1];
        nums[i1] = nums[i2];
        nums[i2] = temp;
    }
}
