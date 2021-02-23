package com.yoshino.leetcode.p651to700;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 数组的度
 *
 * @author wangxin
 * 2021/2/20 08:35
 * @since
 **/
public class P697FindShortestSubArray {

    public int findShortestSubArray(int[] nums) {
        Map<Integer, int[]> counter = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (counter.containsKey(nums[i])) {
                counter.get(nums[i])[0]++;
                counter.get(nums[i])[2] = i;
            } else {
                counter.put(nums[i], new int[]{1, i, i});
            }
        }

        AtomicInteger max = new AtomicInteger();
        AtomicInteger result = new AtomicInteger(Integer.MAX_VALUE);
        counter.forEach((num, arr) -> {
            if (arr[0] > max.get()) {
                result.set(arr[2] - arr[1] + 1);
            } else if (arr[0] == max.get()) {
                result.set(Math.min(arr[2] - arr[1] + 1, result.get()));
            }
            max.set(Math.max(arr[0], max.get()));
        });

        return result.get();
    }

    public static void main(String[] args) {
        new P697FindShortestSubArray().findShortestSubArray(new int[]{1,2,2,3,1});
    }
}
