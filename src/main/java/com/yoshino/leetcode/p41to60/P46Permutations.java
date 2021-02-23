package com.yoshino.leetcode.p41to60;

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
        List<List<Integer>> res = new ArrayList<>();
        permute(nums, new ArrayList<>(), new boolean[nums.length], res);
        return res;
    }

    private static void permute(int[] nums, List<Integer> path, boolean[] used, List<List<Integer>> res) {
        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path));
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            used[i] = true;
            path.add(nums[i]);
            permute(nums, path, used, res);
            used[i] = false;
            path.remove(path.size() - 1);
        }
    }


    public static void main(String[] args) {
        List<List<Integer>> lists = permute(new int[]{1,2,3});
        lists.forEach(System.out::println);
    }
}
