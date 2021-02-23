package com.yoshino.leetcode.p21to40;

import java.util.*;

/**
 * 组合总和ii
 **/
public class P40CombinationSumii {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(0, target, new LinkedList<>(), candidates, ans);
        return new ArrayList<>(ans);
    }

    private void dfs(int index, int target, LinkedList<Integer> path, int[] candidates, List<List<Integer>> ans) {
        if (target == 0) {
            ans.add(new ArrayList<>(path));
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            if (target - candidates[i] < 0) {
                break;
            }
            if (i != index && candidates[i] == candidates[i - 1]) {
                continue;
            }
            path.addLast(candidates[i]);
            dfs(i + 1, target - candidates[i], path, candidates, ans);
            path.removeLast();
        }
    }

    public static void main(String[] args) {
        new P40CombinationSumii().combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8);
    }
}
