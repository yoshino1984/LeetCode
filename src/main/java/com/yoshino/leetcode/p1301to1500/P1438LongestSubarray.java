package com.yoshino.leetcode.p1301to1500;

import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author wangxin
 * 2021/2/21 12:05
 * @since
 **/
public class P1438LongestSubarray {

    public int longestSubarray(int[] nums, int limit) {
        int result = 0;
        TreeMap<Integer, AtomicInteger> valueCountMap = new TreeMap<>();
        for (int left = 0, right = 0; right < nums.length; right++) {
            valueCountMap.computeIfAbsent(nums[right], k -> new AtomicInteger()).incrementAndGet();
            if (valueCountMap.lastKey() - valueCountMap.firstKey() <= limit) {
                result = Math.max(result, right - left + 1);
            } else {
                while (valueCountMap.lastKey() - valueCountMap.firstKey() > limit) {
                    int key = nums[left++];
                    int count = valueCountMap.get(key).decrementAndGet();
                    if (count == 0) {
                        valueCountMap.remove(key);
                    }
                }
            }
        }

        return result;
    }
}
