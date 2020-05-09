package com.yoshino.p901to950;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;

public class P912SortAnArray {

    public static List<Integer> sortArray(int[] nums) {
        heapsort(nums);
        List<Integer> res = new ArrayList<>(nums.length);
        for (int num : nums) {
            res.add(num);
        }
        return res;
    }

    /**
     * 堆排序： 时间复杂度O(NlogN) 空间复杂度为O(1)
     * 最坏时间复杂度O(NlogN)，
     *
     * @param nums
     */
    public static void heapsort(int[] nums) {
        // 建堆
        heapify(nums);

        // 排序
        for (int i = 0; i < nums.length - 1; i++) {
            swap(nums, nums.length - 1 - i, 0);
            int maxSortIndex = nums.length - 2 - i;
            int curIndex = 0;
            while (true) {
                int maxValIndexOfSub = maxValIndex(nums, curIndex, maxSortIndex);
                if (maxValIndexOfSub == curIndex) {
                    break;
                }
                swap(nums, curIndex, maxValIndexOfSub);
                curIndex = maxValIndexOfSub;
            }
        }
    }

    /**
     * 建堆1：从前往后建立
     * @param nums
     */
    private static void heapify(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            int curIndex = i;
            while ((curIndex - 1) / 2 >= 0 && nums[(curIndex - 1) / 2] < nums[curIndex]) {
                swap(nums, (curIndex - 1) / 2, curIndex);
                curIndex = (curIndex - 1) / 2;
            }
        }
    }

    /**
     *  交换两个元素
     * @param nums
     * @param i
     * @param j
     */
    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    /**
     * 查找当前元素和左右子树间最大的那个值的下标
     * @param nums
     * @param curIndex
     * @param maxSortIndex
     * @return
     */
    private static int maxValIndex(int[] nums, int curIndex, int maxSortIndex) {
        int maxIndex = curIndex;
        int left = curIndex * 2 + 1;
        int right = curIndex * 2 + 2;
        if (left <= maxSortIndex && nums[left] > nums[curIndex]) {
            maxIndex = left;
        }
        if (right <= maxSortIndex && nums[right] > nums[maxIndex]) {
            maxIndex = right;
        }
        return maxIndex;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{7, 5, 19, 8, 4, 1, 20, 13, 16};
        heapsort(nums);
        System.out.println(JSON.toJSONString(nums));
    }
}
