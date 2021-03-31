package com.yoshino.leetcode.p81to100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author wangxin
 * 2021/4/1 03:20
 * @since
 **/
public class P90 {

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        dfs(nums, 0, true, new LinkedList<>(), result);

        return result;
    }

    private void dfs(int[] nums, int index, boolean lastAdd, LinkedList<Integer> path, List<List<Integer>> result) {
        if (index == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }

        if (lastAdd || (nums[index] != nums[index - 1])) {
            path.addLast(nums[index]);
            dfs(nums, index + 1, true, path, result);
            path.removeLast();
        }
        dfs(nums, index + 1, false, path, result);
    }
}
