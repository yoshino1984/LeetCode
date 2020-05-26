package com.yoshino.p1to20;

import java.util.HashMap;
import java.util.Map;

public class P1TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numIndexMap = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            Integer otherIndex = numIndexMap.get(target - nums[i]);
            if (otherIndex != null) {
                return new int[] {otherIndex, i};
            } else {
                numIndexMap.put(nums[i], i);
            }
        }
        throw new IllegalArgumentException("no two sum solution");
    }

    public static void main(String[] args) {
        new P1TwoSum().twoSum(new int[]{2,7}, 9);
    }
}
