package com.yoshino.leetcode.p101to120;

import com.yoshino.leetcode.model.TreeNode;

import java.util.*;

/**
 * 路径总和ii
 *
 * @author wangxin
 * 2020/9/26 02:12
 * @since
 **/
public class P113PathSumii {

    List<List<Integer>> ans;
    LinkedList<Integer> path;
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        ans = new ArrayList<>();
        path = new LinkedList<>();
        dfs(root, sum);
        return ans;
    }

    private void dfs(TreeNode root, int sum) {
        if (root == null) {
            return;
        }

        sum -= root.val;
        path.addLast(root.val);
        if (root.left == null && root.right == null && sum == 0) {
            ans.add(new ArrayList<>(path));
        }

        dfs(root.left, sum);
        dfs(root.right, sum);
        path.removeLast();
    }
}
