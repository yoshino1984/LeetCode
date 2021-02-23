package com.yoshino.leetcode.p161to180;

import java.util.Arrays;

public class P179LargestNumber {

    /**
     * 需要进行一次排序，主要是排序的规则需要设计
     * 时间复杂度O(NlogN)
     * @param nums
     * @return
     */
    public String largestNumber(int[] nums) {
        String[] numStrs = Arrays.stream(nums).mapToObj(String::valueOf).toArray(String[]::new);
        Arrays.sort(numStrs, (o1, o2) -> {
            String a = o1 + o2;
            String b = o2 + o1;
            return b.compareTo(a);
        });
        String res = String.join("", numStrs);
        return res.startsWith("0") ? "0" : res;
    }

    public static void main(String[] args) {
        System.out.println(new P179LargestNumber().largestNumber(new int[] {10, 2}));
        System.out.println(new P179LargestNumber().largestNumber(new int[] {3,30,34,5,9}));
        System.out.println(new P179LargestNumber().largestNumber(new int[] {0, 0}));
        System.out.println(new P179LargestNumber().largestNumber(new int[] {0, 0}));
    }
}
