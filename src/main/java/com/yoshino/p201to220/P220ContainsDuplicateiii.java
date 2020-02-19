package com.yoshino.p201to220;

import java.util.HashMap;
import java.util.Map;

public class P220ContainsDuplicateiii {

    /**
     * 使用桶排序的思想，只用一个固定窗口内的元素放入本桶和相邻桶的可能性
     * 时间复杂度O(N)
     * 空间复杂度O(k)
     * @param nums
     * @param k
     * @param t
     * @return
     */
    public static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (t < 0) {
            return false;
        }
        Map<Long, Long> bucket = new HashMap<>(k * 2);
        long w = (long)t + 1;
        for (int i = 0; i < nums.length; i++) {
            long m = getId(nums[i], w);
            if (bucket.containsKey(m)) {
                return true;
            }
            if (bucket.containsKey(m - 1) && Math.abs(nums[i] - bucket.get(m - 1)) < w) {
                return true;
            }
            if (bucket.containsKey(m + 1) && Math.abs(nums[i] - bucket.get(m + 1)) < w) {
                return true;
            }
            bucket.put(m, (long) nums[i]);
            if (i >= k) {
                bucket.remove(getId(nums[i - k], w));
            }
        }
        return false;
    }

    private static long getId(long x, long w) {
        // 负数时特殊处理
        return x < 0 ? (x + 1) / w - 1 : x / w;
    }

    public static void main(String[] args) {
        System.out.println(containsNearbyAlmostDuplicate(new int[]{1,2,3,1}, 3, 0));
        System.out.println(containsNearbyAlmostDuplicate(new int[]{1, 0, 1, 1}, 1, 2));
        System.out.println(containsNearbyAlmostDuplicate(new int[]{1, 5, 9, 1, 5, 9}, 2, 3));
    }
}
