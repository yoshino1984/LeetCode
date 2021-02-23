package com.yoshino.leetcode.p141to160;

public class P152MaximumProductSubarray {

    /**
     * 对于第i个数为止的
     * dpMax[i] = max(nums[i], max(nums[i]*dpMin[i-1], nums[i]*dpMax[i-1]))
     * dpMin[i] = min(nums[i], min(nums[i]*dpMin[i-1], nums[i]*dpMax[i-1]))
     * @param nums
     * @return
     */
    public static int maxProduct(int[] nums) {
        int max = nums[0];
        int[] dpMax = new int[nums.length];
        dpMax[0] = nums[0];
        int[] dpMin = new int[nums.length];
        dpMin[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            dpMax[i] = Math.max(nums[i], Math.max(nums[i]*dpMin[i-1], nums[i]*dpMax[i-1]));
            dpMin[i] = Math.min(nums[i], Math.min(nums[i]*dpMin[i-1], nums[i]*dpMax[i-1]));
            max = Math.max(dpMax[i], max);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(maxProduct(new int[]{2,3,-2,4}));
        System.out.println(maxProduct(new int[]{-2,0,-1}));
        System.out.println(maxProduct(new int[]{-2,0,-1,1, -2}));
        System.out.println(maxProduct(new int[]{0}));
    }

}
