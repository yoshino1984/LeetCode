package com.yoshino.p41to60;

import java.util.ArrayList;
import java.util.List;

public class P46Permutations {
    /**
     * 没有重复数字的序列，返回全排列
     * 解决：递归
     *
     * @param nums
     * @return
     */
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        if (nums.length == 0) {
            lists.add(new ArrayList<>());
        } else {
            permute(nums, 0, nums.length - 1, new ArrayList<>(), lists);
        }
        return lists;
    }

    private static void permute(int[] nums, int start, int end, List<Integer> items, List<List<Integer>> lists) {
        if (start == end) {
            items.add(nums[start]);
            lists.add(items);
            return;
        }
        for (int i = start; i <= end; i++) {
            swap(nums, start, i);
            List<Integer> tempItems = new ArrayList<>(items);
            tempItems.add(nums[start]);
            permute(nums, start + 1, end, tempItems, lists);
            swap(nums, start, i);
        }

    }

    private static void swap(int[] nums, int start, int end) {
        int temp = nums[start];
        nums[start] = nums[end];
        nums[end] = temp;
    }

    public static void main(String[] args) {
        List<List<Integer>> lists = permute(new int[]{1,2,3});
        lists.forEach(System.out::println);
    }
}
