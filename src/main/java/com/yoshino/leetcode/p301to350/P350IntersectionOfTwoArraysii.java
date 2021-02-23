package com.yoshino.leetcode.p301to350;

import java.util.ArrayList;
import java.util.Arrays;

public class P350IntersectionOfTwoArraysii {
    /**
     * 时间复杂度O(NlogN)
     * 采用排序然后处理的方式
     */
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        ArrayList<Integer> res = new ArrayList<>();
        for (int i1 = 0, i2 = 0; i1 < nums1.length && i2 < nums2.length;) {
            if (nums1[i1] == nums2[i2]) {
                res.add(nums1[i1]);
                i1++;
                i2++;
            } else if (nums1[i1] < nums2[i2]) {
                i1++;
            } else {
                i2++;
            }
        }
        int[] ans = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            ans[i] = res.get(i);
        }
        return ans;
    }

}
