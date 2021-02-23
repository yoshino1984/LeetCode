package com.yoshino.leetcode.p21to40;

/**
 * 搜索插入位置
 **/
public class P35SearchInsertPosition {

    public int searchInsert(int[] nums, int target) {
        if (nums.length == 0) {
            return 0;
        }

        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return left;
    }

    public static void main(String[] args) {
        new P35SearchInsertPosition().searchInsert(new int[]{1,3,5,6}, 5);
    }
}
