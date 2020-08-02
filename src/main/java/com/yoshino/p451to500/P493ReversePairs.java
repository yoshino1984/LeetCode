package com.yoshino.p451to500;

/**
 * 翻转对
 **/
public class P493ReversePairs {

    public int reversePairs(int[] nums) {
        return mergeSort(nums, 0, nums.length - 1);
    }
    private int mergeSort(int[] nums, int start, int end) {
        if (start >= end) {
            return 0;
        }

        int mid = start + (end - start) / 2;
        int count = mergeSort(nums, start, mid);
        count += mergeSort(nums, mid + 1, end);
        count += mergeWithCount(nums, start, mid, end);
        return count;
    }

    private int mergeWithCount(int[] nums, int start, int mid, int end) {
        int l = start;
        int count = 0;
        for (int r = mid + 1; r <= end; r++) {
            while (l <= mid && (long)nums[l] <= (long)nums[r] * 2) {
                l++;
            }
            count += mid - l + 1;
        }

        merge(nums, start, mid, end);
        return count;
    }

    private void merge(int[] nums, int start, int mid, int end) {
        int[] cache = new int[end - start + 1];
        int index = 0, index1 = start, index2 = mid + 1;
        while (index1 <= mid && index2 <= end) {
            cache[index++] = nums[index1] <= nums[index2] ? nums[index1++] : nums[index2++];
        }
        System.arraycopy(nums, index1 <= mid ? index1 : index2, cache, index, cache.length - index);
        System.arraycopy(cache, 0, nums, start, cache.length);
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,3,2,3,1};
        System.out.println(new P493ReversePairs().reversePairs(nums));;
    }
}
