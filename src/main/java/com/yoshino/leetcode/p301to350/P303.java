package com.yoshino.leetcode.p301to350;

public class P303 {
}
class NumArray {

    private int[] subResult;

    public NumArray(int[] nums) {
        subResult = new int[nums.length];
        subResult[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            subResult[i] = subResult[i - 1] + nums[i];
        }
    }

    public int sumRange(int i, int j) {
        return subResult[j] - (i == 0 ? 0 : subResult[i - 1]);
    }

    public static void main(String[] args) {
        NumArray numArray = new NumArray(new int[]{-2,0,3,-5,2,-1});
        numArray.sumRange(0, 2);
    }
}
