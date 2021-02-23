package com.yoshino.leetcode.p1to20;

import java.util.Arrays;

public class P16_3SuMClosest {

    /**
     * 首先排序，然后使用在第一个数确定的情况下，使用双指针法一次遍历剩余数字，找出最接近的组合 然后对比
     * 时间复杂度：O(N^2)
     * @param nums
     * @param target
     * @return
     */
    public static int threeSumClosest(int[] nums, int target) {
        if (nums.length < 3) {
            return 0;
        }
        Arrays.sort(nums);
        int size = nums.length;
        int closestSum = Integer.MAX_VALUE;
        int closestDiff = Integer.MAX_VALUE;
        int first;
        for (int i = 0; i < size; i++) {
            first = nums[i];
            int low = i + 1;
            int high = size - 1;
            int sum;
            int diff;
            while (low < high) {
                sum = nums[low] + nums[high] + first;
                diff = Math.abs(sum - target);
                if (diff < closestDiff) {
                    closestSum = sum;
                    closestDiff = diff;
                }
                if (sum < target) {
                    low ++;
                } else if (sum > target) {
                    high--;
                } else {
                    break;
                }
            }
            if (closestDiff == 0) {
                break;
            }
        }
        return closestSum;
    }

    public static void main(String[] args) {
        System.out.println(threeSumClosest(new int[] {-1,2,1,-4}, 1));
        System.out.println(threeSumClosest(new int[] {-1,2,1,-4}, 5));
    }


}
