package com.yoshino.leetcode.p251to300;

import java.util.Arrays;

/**
 *
 **/
class P287FindTheDuplicateNumber {

    public int findDuplicate(int[] nums) {
        int n = nums.length - 1;
        int left = 1, right = n;
        while (left < right) {
            int mid = (left + right) >>> 1;

            long cnt = Arrays.stream(nums).filter(num -> num <= mid).count();

            if (cnt > mid) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

}
