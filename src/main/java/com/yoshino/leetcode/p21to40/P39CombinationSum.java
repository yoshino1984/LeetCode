package com.yoshino.leetcode.p21to40;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 组合总和
 *
 * @author wangxin
 * 2020/9/9 23:36
 * @since
 **/
public class P39CombinationSum {


    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        dfs(0, new LinkedList<>(), candidates, target, ans);
        return ans;
    }

    private void dfs(int index, LinkedList<Integer> path, int[] candidates, int target,
                     List<List<Integer>> ans) {
        if (0 == target) {
            ans.add(new ArrayList<>(path));
            return;
        } else if (target < 0 || index == candidates.length) {
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            path.addLast(candidates[i]);
            dfs(i, path, candidates, target - candidates[i], ans);
            path.removeLast();
        }
    }
}
