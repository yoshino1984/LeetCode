package com.yoshino.leetcode.p201to220;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 数组中的第K个最大元素
 * @author wangxin
 * 2020/5/9 14:32
 * @since
 **/
public class P215KthLargestElementInAnArray {

    /**
     * 排序方式 时间复杂度O(NlogN)
     */
    public int findKthLargest1(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }

    /**
     * 小顶堆的方式
     */
    public int findKthLargest2(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(k);
        for (int n : nums) {
            queue.add(n);
            if (queue.size() > k) {
                queue.poll();
            }
        }
        return queue.peek();
    }

    /**
     * 快速选择 （分而治之的思想）
     * 时间复杂度O(N)
     */
    public int findKthLargest3(int[] nums, int k) {
        return quickSelect(nums, 0, nums.length - 1, nums.length - k);
    }

    private int quickSelect(int[] nums, int left, int right, int k) {
        if (left == right) {
            return nums[left];
        }
        int pivotIndex = left + (right - left) / 2;
        pivotIndex = partition(nums, left, right, pivotIndex);
        if (pivotIndex == k) {
            return nums[pivotIndex];
        } else if (pivotIndex < k) {
            return quickSelect(nums, pivotIndex + 1, right, k);
        } else {
            return quickSelect(nums, left, pivotIndex - 1, k);
        }
    }

    private int partition(int[] nums, int left, int right, int pivotIndex) {
        int pivot = nums[pivotIndex];
        swap(nums, pivotIndex, right);
        int minIndex = left;

        for (int i = left; i <= right; i++) {
            if (nums[i] < pivot) {
                swap(nums, i , minIndex);
                minIndex++;
            }
        }
        swap(nums, right, minIndex);

        return minIndex;
    }

    public void swap(int[] nums, int a, int b) {
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }


    public static void main(String[] args) {
        new P215KthLargestElementInAnArray().findKthLargest3(new int[] {3,2,1,5,6,4}, 2);
    }

}
