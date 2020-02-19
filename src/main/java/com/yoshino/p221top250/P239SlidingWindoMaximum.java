package com.yoshino.p221top250;

import com.alibaba.fastjson.JSON;

public class P239SlidingWindoMaximum {

    /**
     * 时间复杂度O(N)
     * @param nums
     * @param k
     * @return
     */
    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0 || k == 0) {
            return new int[]{};
        }
        int[] resNums = new int[nums.length - k + 1];

        // 窗口最大值下标
        int maxIndex = -1;
        int kEndIndex;
        for (int kStartIndex = 0; kStartIndex < nums.length - k + 1; kStartIndex++) {
            kEndIndex = kStartIndex + k - 1;
            if (kStartIndex > maxIndex) {
                maxIndex = findMax(nums, kStartIndex, kEndIndex);
            }
            if (nums[kEndIndex] > nums[maxIndex]) {
                maxIndex = kEndIndex;
            }
            resNums[kStartIndex] = nums[maxIndex];
        }
        return resNums;
    }

    private static int findMax(int[] nums, int start, int end) {
        int maxIndex = start;
        for (int i = start + 1; i <= end; i++) {
            if (nums[maxIndex] <= nums[i]) {
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    public static void main(String[] args) {
        System.out.println(JSON.toJSONString(maxSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7}, 4)));
        System.out.println(JSON.toJSONString(maxSlidingWindow(new int[]{9,10,9,-7,-4,-8,2,-6}, 5)));
    }


}
