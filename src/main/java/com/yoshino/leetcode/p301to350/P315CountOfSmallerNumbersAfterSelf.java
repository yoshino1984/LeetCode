package com.yoshino.leetcode.p301to350;

import com.alibaba.fastjson.JSON;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 计算右侧小于当前元素的个数
 *
 * @author wangxin
 * 2020/5/11 22:53
 * @since
 **/
public class P315CountOfSmallerNumbersAfterSelf {

    /**
     * 时间复杂度O(N^2)
     */
    public static List<Integer> countSmaller1(int[] nums) {
        int[] ret = new int[nums.length];
        for (int i = nums.length - 2; i >= 0; i--) {
            int cur = i;
            while (cur < nums.length - 1 && nums[cur] > nums[cur + 1]) {
                swap(nums, cur, cur + 1);
                cur++;
            }
            ret[i] = cur - i;
        }
        return Arrays.stream(ret).boxed().collect(Collectors.toList());
    }

    private static void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }

    /**
     * 使用归并排序的思想
     */
    private int[] ret;
    public List<Integer> countSmaller(int[] nums) {
        ret = new int[nums.length];
        int[][] numPairs = new int[nums.length][2];
        for (int i = 0; i < nums.length; i++) {
            numPairs[i][0] = nums[i];
            numPairs[i][1] = i;
        }

        mergeSort(numPairs, 0, nums.length - 1);
        return Arrays.stream(ret).boxed().collect(Collectors.toList());
    }

    private void mergeSort(int[][] numPairs, int low, int high) {
        if (low >= high) {
            return;
        }
        int mid = (low + high) / 2;
        mergeSort(numPairs, low, mid);
        mergeSort(numPairs, mid + 1, high);
        merge(numPairs, low, mid, high);
    }

    private void merge(int[][] numPairs, int low, int mid, int high) {
        int i1 = low, i2 = mid + 1, curIndex = 0;
        int[][] temp = new int[high - low + 1][2];
        while (i1 <= mid && i2 <= high) {
            if (numPairs[i1][0] > numPairs[i2][0]) {
                ret[numPairs[i1][1]] += (high - i2 + 1);
                temp[curIndex++] = numPairs[i1++];
            } else {
                temp[curIndex++] = numPairs[i2++];
            }
        }

        while (i1 <= mid) {
            temp[curIndex++] = numPairs[i1++];
        }

        while (i2 <= high) {
            temp[curIndex++] = numPairs[i2++];
        }

        if (high - low + 1 >= 0) {
            System.arraycopy(temp, 0, numPairs, low, high - low + 1);
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[] {5,2,6,1,2,6,1,2,6,1,2,6,1,2,6,1,2,6,1,2,6,1,2,6,1,16,8,15,0,7,13,0,6,11,0,5,9,0,4,7,0,3,5,0,2,3,0,1,1,0,5,2,6,1,2,6,1,2,6,1,2,6,1,2,6,1,2,6,1,2,6,1,2,6,1,16,8,15,0,7,13,0,6,11,0,5,9,0,4,7,0,3,5,0,2,3,0,1,1,0,5,2,6,1,2,6,1,2,6,1,2,6,1,2,6,1,2,6,1,2,6,1,2,6,1,16,8,15,0,7,13,0,6,11,0,5,9,0,4,7,0,3,5,0,2,3,0,1,1,0,5,2,6,1,2,6,1,2,6,1,2,6,1,2,6,1,2,6,1,2,6,1,2,6,1,16,8,15,0,7,13,0,6,11,0,5,9,0,4,7,0,3,5,0,2,3,0,1,1,0,5,2,6,1,2,6,1,2,6,1,2,6,1,2,6,1,2,6,1,2,6,1,2,6,1,16,8,15,0,7,13,0,6,11,0,5,9,0,4,7,0,3,5,0,2,3,0,1,1,0,5,2,6,1,2,6,1,2,6,1,2,6,1,2,6,1,2,6,1,2,6,1,2,6,1,16,8,15,0,7,13,0,6,11,0,5,9,0,4,7,0,3,5,0,2,3,0,1,1,0,5,2,6,1,2,6,1,2,6,1,2,6,1,2,6,1,2,6,1,2,6,1,2,6,1,16,8,15,0,7,13,0,6,11,0,5,9,0,4,7,0,3,5,0,2,3,0,1,1,0};
        List<Integer> ret = new P315CountOfSmallerNumbersAfterSelf().countSmaller(nums);
        System.out.println(JSON.toJSONString(ret));
    }

}
