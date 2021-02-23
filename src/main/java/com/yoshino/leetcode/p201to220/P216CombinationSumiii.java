package com.yoshino.leetcode.p201to220;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 组合总和3
 *
 * @author wangxin
 * 2020/9/11 22:13
 * @since
 **/
public class P216CombinationSumiii {

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        dfs(1, n, k, new LinkedList<Integer>(), ans);
        return ans;
    }

    private void dfs(int num, int target, int k, LinkedList<Integer> path, List<List<Integer>> ans) {
        if (target == 0) {
            if (path.size() == k) {
                ans.add(new ArrayList<>(path));
            }
            return;
        }
        if (target < 0 || num > 9) {
            return;
        }
        path.addLast(num);
        dfs(num + 1, target - num, k, path, ans);
        path.removeLast();
        dfs(num + 1, target, k, path, ans);
    }
}
