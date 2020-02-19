package com.yoshino.p301to350;

import com.alibaba.fastjson.JSON;

import java.util.Arrays;

public class P324WiggleSortii {

    /**
     * 首先是进行分区，然后采用倒序遍历分区组合的方法
     * 时间复杂度O(N)
     * 空间复杂度O(N) 可以采用完美洗牌算法优化到O(1)的程度
     * @param nums
     */
    public static void wiggleSort(int[] nums) {
        if (nums.length < 2) {
            return;
        }
        quickSelect(nums, 0, nums.length, nums.length / 2);
        int i = 0, j = 0, z = nums.length - 1;
        int midr = nums.length / 2;
        int midrVal = nums[midr];
        while (j < z) {
            if (nums[j] > midrVal) {
                swap(nums, z--, j);
            } else if (nums[j] < midrVal) {
                swap(nums, i++, j++);
            } else {
                j++;
            }
        }
        if (nums.length % 2 == 1) {
            midr++;
        }
        int[] nums2 = Arrays.copyOf(nums, nums.length);
        for (int ii = 0; ii < nums.length; ii = ii + 2) {
            // midr计数还有点问题
            nums[ii] = nums2[midr - ii / 2 - 1];
        }
        for (int ii = 1; ii < nums.length; ii = ii + 2) {
            nums[ii] = nums2[nums.length - ii / 2 - 1];
        }
    }

    private static void quickSelect(int[] nums, int begin, int end, int n) {
        int t = nums[end - 1];
        int i = begin, j = begin;
        while(j < end){
            if(nums[j] <= t){
                swap(nums, i++, j++);
            }
            else{
                ++j;
            }
        }
        if(i - 1 > n){
            quickSelect(nums, begin, i - 1, n);
        }
        else if(i <= n){
            quickSelect(nums, i, end, n);
        }
    }

    private static void swap(int[] nums, int i, int i1) {
        int temp = nums[i];
        nums[i] = nums[i1];
        nums[i1] = temp;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {6, 5, 1, 1, 6, 4};
//        int[] nums = new int[] {4,5,5,6};
        wiggleSort(nums);
//        quickSelect(nums, 0, nums.length, 2);
        System.out.println(JSON.toJSONString(nums));
    }
}