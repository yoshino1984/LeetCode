package com.yoshino.p451to500;

import java.util.*;

/**
 * 递增子序列
 **/
public class P491IncreasingSubsequences {

    /**
     * 枚举（深度优先遍历）加剪枝
     * 时间复杂度O(N)
     * @param nums
     * @return
     */
    public List<List<Integer>> findSubsequences(int[] nums) {
        List<Integer> temp = new ArrayList<>();
        Set<List<Integer>> ans = new LinkedHashSet<>();
        dfs(0, Integer.MIN_VALUE, nums, temp, ans);
        return new ArrayList<>(ans);
    }

    private void dfs(int i, int last, int[] nums, List<Integer> temp, Set<List<Integer>> ans) {
        if (i == nums.length) {
            if (temp.size() >= 2) {
                ans.add(new ArrayList<>(temp));
            }
            return;
        }

        if (nums[i] >= last) {
            temp.add(nums[i]);
            dfs(i + 1, nums[i], nums, temp, ans);
            temp.remove(temp.size() - 1);
        }

        if (nums[i] != last) {
            dfs(i + 1, last, nums, temp, ans);
        }
    }


    public static void main(String[] args) {
        new P491IncreasingSubsequences().findSubsequences(new int[]{4, 6, 7, 7});
    }
}
