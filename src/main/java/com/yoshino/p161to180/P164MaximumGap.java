package com.yoshino.p161to180;

import java.util.Arrays;

public class P164MaximumGap {

    /**
     * 使用桶排序的思想，遍历获取最大和最小值，计算每个桶的间距，创建桶，遍历每个元素，进行桶排序，每个桶只计算最大最小值，计算最大间距
     * 时间复杂度O(N)
     * 空间复杂度O(N)
     * @param nums
     * @return
     */
    public int maximumGap(int[] nums) {
        if (nums.length < 2) {
            return 0;
        }
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(nums[i], max);
            min = Math.min(nums[i], min);
        }

        int bucketGap = (max - min) / nums.length + 1;
        int[][] bucket = new int[nums.length][2];
        for (int i = 0; i < bucket.length; i++) {
            bucket[i] = new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE};
        }
        for (int i = 0; i < nums.length; i++) {
            int index = (nums[i] - min) / bucketGap;
            bucket[index][0] = Math.min(bucket[index][0], nums[i]);
            bucket[index][1] = Math.max(bucket[index][1], nums[i]);
        }
        int maxGap = bucket[0][1] - bucket[0][0];

        int lastIndex = 0;
        for (int i = 1; i < bucket.length; i++) {
            if (bucket[i][0] != Integer.MAX_VALUE) {
                maxGap = Math.max(Math.max(maxGap, bucket[i][1] - bucket[i][0]), bucket[i][0] - bucket[lastIndex][1]);
                lastIndex = i;
            }
        }
        return maxGap;
    }

    public static void main(String[] args) {
        System.out.println(new P164MaximumGap().maximumGap(new int[]{3,6,9,1, 12,21,32,81,43,12,34,54,65,67}));
        System.out.println(new P164MaximumGap().maximumGap(new int[]{10}));
    }

}
