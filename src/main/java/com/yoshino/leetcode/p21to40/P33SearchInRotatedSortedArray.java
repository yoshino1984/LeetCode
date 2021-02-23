package com.yoshino.leetcode.p21to40;

/**
 * 搜索旋转排序数组
 * 二分查找，时间复杂度O(logN)
 * 需要配合画图分析清楚当点落在左半边或者右半边的情况下，low和high的趋向性
 *
 * @since
 **/
public class P33SearchInRotatedSortedArray {
    public static void main(String[] args) {
        int[] nums = new int[]{4,5,6,7,0,1,2};
//        System.out.println(new P33SearchInRotatedSortedArray().search(nums, 0));
        System.out.println(new P33SearchInRotatedSortedArray().search(new int[]{5,1,2,3,4}, 1));
        for (int i =0; i < nums.length; i++) {
            System.out.println(i + ":" + new P33SearchInRotatedSortedArray().search(nums, i));
        }
    }

    /**
     * 二分查找解法，mid点的左半边或者右半边肯定都是有序的
     * 时间复杂度O(logN)
     * 
     */
    public int search(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[0] <= nums[mid]) {
                if (nums[0] <= target && target < nums[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else {
                if (target <= nums[nums.length - 1] && target > nums[mid]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }
}
