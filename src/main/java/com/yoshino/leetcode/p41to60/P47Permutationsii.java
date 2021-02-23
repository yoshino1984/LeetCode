package com.yoshino.leetcode.p41to60;

import java.util.*;

public class P47Permutationsii {

    /**
     * 重复数字的序列，返回全排列
     * 解决：递归
     *
     * @param nums
     * @return
     */
    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        dfs(nums, new LinkedList<>(), new boolean[nums.length], res);
        return res;
    }

    private static void dfs(int[] nums, LinkedList<Integer> path, boolean[] used, List<List<Integer>> res) {
        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path));
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i] || (i > 0 && nums[i] == nums[i - 1] && !used[i - 1])) {
                continue;
            }

            used[i] = true;
            path.addLast(nums[i]);
            dfs(nums, path, used, res);
            used[i] = false;
            path.removeLast();
        }
    }


    public static void main(String[] args) {
        permuteUnique(new int[]{1,1,3}).forEach(System.out::println);
    }
}
