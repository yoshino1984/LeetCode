package com.yoshino.p21to40;

/**
 * 搜索插入位置
 **/
public class P35SearchInsertPosition {

    public int searchInsert(int[] nums, int target) {
        if (nums.length == 0 || target <= nums[0]) {
            return 0;
        }

        int low = 0, high = nums.length - 1;

        while (low < high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return nums[low] < target ? low + 1 : low;
    }

    public static void main(String[] args) {
        new P35SearchInsertPosition().searchInsert(new int[]{1,3,5,6}, 5);
    }
}
