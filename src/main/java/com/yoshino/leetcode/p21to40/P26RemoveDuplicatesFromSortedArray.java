package com.yoshino.leetcode.p21to40;

/**
 * 删除排序数组中的重复项
 *
 * @author wangxin
 * 2020/5/30 08:38
 * @since
 **/
public class P26RemoveDuplicatesFromSortedArray {

    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int index = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[index - 1]) {
                nums[index++] = nums[i];
            }
        }
        return index;
    }

    public int removeDuplicates2(int[] nums) {
        if (nums.length < 1) {
            return 0;
        }
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != nums[index]) {
                index++;
                nums[index] = nums[i];
            }
        }
        return index + 1;
    }
}
