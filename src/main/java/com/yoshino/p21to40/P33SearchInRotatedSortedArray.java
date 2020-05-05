package com.yoshino.p21to40;

/**
 * 搜索旋转排序数组
 * 二分查找，时间复杂度O(logN)
 * 需要配合画图分析清楚当点落在左半边或者右半边的情况下，low和high的趋向性
 *
 * @author wangxin
 * 2020/5/5 23:05
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

    public int search(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        } else if (nums[0] == target) {
            return 0;
        }
        return search(nums, 0, nums.length - 1, target);
    }

    private int search(int[] nums, int low, int high, int target) {
        if (low > high) {
            return -1;
        }
        int mid = low + ((high - low) >> 1);
        if (nums[mid] == target) {
            return mid;
        }
        if (target > nums[0]) {
            // target可能在左半区
            if (nums[mid] > target) {
                high = mid - 1;
            } else {
                if (nums[mid] < nums[0]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
        } else {
            // target可能在右半区
            if (nums[mid] < target) {
                low = mid + 1;
            } else {
                if (nums[mid] < nums[0]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
        }

        return search(nums, low, high, target);
    }
}
