package com.yoshino.leetcode.p21to40;

import com.alibaba.fastjson.JSON;

public class P31NextPermutation {

    /**
     * 字典序主要是从右边开始寻找降序的起点的前一个数a，然后找比数a大的一个数b，两者进行交换，然后反转整个降序序列
     * @param nums
     */
    public void nextPermutation2(int[] nums) {
        int i = nums.length - 2;
        for (; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                break;
            }
        }
        if (i < 0) {
            reverse(nums, 0, nums.length - 1);
            return;
        }

        for (int j = nums.length - 1; j >= 0; j--) {
            if (nums[i] < nums[j]) {
                swap(nums, i, j);
                reverse(nums, i + 1, nums.length - 1);
                return;
            }
        }
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    /**
     * 首先遍历，找到nums[i] < nums[i + 1] 的两个数字，表示可以找到下一个字典序
     * 将nums[i] 与 i之后的某个大于i的最小数与nums[i]做交换，然后对nums[i]之后的数组做升序排列
     * 由于nums[i]之后的数组本身就是降序的，因此只要颠倒nums[i]之后部分的数组即可
     * @param nums
     */
    public static void nextPermutation(int[] nums) {
        if (nums.length <= 1) {
            return;
        }
        int len = nums.length;

        int start = len - 1;
        for (; start > 0; start--) {
            if (nums[start] > nums[start - 1]) {
                int j = len - 1;
                while (j >= 0 && nums[j] <= nums[start - 1]) {
                    j--;
                }
                swap(nums, start - 1, j);
                break;
            }
        }
        reverse(nums, start);
    }


    private static void reverse(int[] nums, int start) {
        int i = start, j = nums.length - 1;
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
//        int[] nums = new int[]{1,2,3,5,6,6,5,4,3};
        int[] nums = new int[]{1,2,3,4,5,6,7,6,5,4,3,2};
//        int[] nums = new int[]{1,2,3};
//        int[] nums = new int[]{1,3,2};
        nextPermutation(nums);
        System.out.println(JSON.toJSONString(nums));
    }
}
