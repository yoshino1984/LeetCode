package com.yoshino.leetcode.p21to40;

import com.alibaba.fastjson.JSON;

public class P34FindFirstAndLastPositionOfElementInSortedArray {

    /**
     * 使用二分查找元素的第一个位置和最后一个位置
     * @param nums
     * @param target
     * @return
     */
    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) {
            return new int[]{-1, -1};
        }
        int first = findPositionOfElementInSortedArray(nums, target, 0, nums.length - 1, true);
        if (first == -1) {
            return new int[]{-1, -1};
        }
        int second = findPositionOfElementInSortedArray(nums, target, 0, nums.length - 1, false);

        return new int[]{first, second};
    }


    private int findPositionOfElementInSortedArray(int[] nums, int target, int low, int high, boolean isFirst) {
        if (low > high) {
            return -1;
        }
        int mid = (low + high) / 2;

        boolean isMatch = (nums[mid] == target) && (isFirst ? (mid == 0 || nums[mid - 1] != target) : (mid == nums.length - 1 || nums[mid + 1] != target));
        if (isMatch) {
            return mid;
        } else if (nums[mid] < target) {
            low = mid + 1;
        } else if (nums[mid] == target) {
            if (isFirst) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        } else {
            high = mid - 1;
        }
        return findPositionOfElementInSortedArray(nums, target, low, high, isFirst);
    }

    public static void main(String[] args) {
        P34FindFirstAndLastPositionOfElementInSortedArray obj = new P34FindFirstAndLastPositionOfElementInSortedArray();
        System.out.println(JSON.toJSONString(obj.searchRange(new int[]{5,7,7,8,8,10}, 8)));
        System.out.println(JSON.toJSONString(obj.searchRange(new int[]{5,7,7,8,8,10}, 6)));
        System.out.println(JSON.toJSONString(obj.searchRange(new int[]{5,7,7,8,8,10}, 6)));
    }

}
