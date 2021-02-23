package com.yoshino.leetcode.p141to160;

/**
 * 寻找旋转排序数组中的最小值ii
 **/
public class P154FindMinimumInRotatedSortedArrayii {


    public int findMin(int[] nums) {
        int low = 0, high = nums.length - 1;
        while (low < high) {
            int m = low + (high - low) / 2;
            if (nums[m] < nums[high]) {
                high = m;
            } else if (nums[m] > nums[high]) {
                low = m + 1;
            } else {
                high--;
            }
        }
        return nums[low];
    }

}
