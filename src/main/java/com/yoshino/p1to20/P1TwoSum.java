package com.yoshino.p1to20;

import java.util.HashMap;
import java.util.Map;

public class P1TwoSum {
    public int[] twoSum(int[] nums, int target) {
        int size= (int)(nums.length/0.75 + 1);
        Map<Integer, Integer> map = new HashMap<>(size);
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    public static void main(String[] args) {
        new P1TwoSum().twoSum(new int[]{2,7}, 9);
    }
}
