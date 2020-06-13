package com.yoshino.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 刻意练习地方
 *
 * @author wangxin
 * 2020/6/11 20:51
 * @since
 **/
public class Solution {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        boolean[] visited = new boolean[nums.length];
        dfs(nums, new LinkedList<>(), visited, ans);
        return ans;
    }

    private void dfs(int[] nums, LinkedList<Integer> path, boolean[] visited, List<List<Integer>> ans) {
        if (nums.length == path.size()) {
            ans.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (visited[i] || (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1])) {
                continue;
            }
            visited[i] = true;
            path.addLast(nums[i]);
            dfs(nums, path, visited, ans);
            visited[i] = false;
            path.removeLast();
        }
    }
}
