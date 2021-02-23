package com.yoshino.leetcode.p501to600;

import com.yoshino.leetcode.model.TreeNode;

import java.util.HashSet;
import java.util.Set;

/**
 * 二叉搜索树中的众数
 * @author wangxin
 * 2020/9/24 20:29
 * @since
 **/
public class P501FindModeInBinarySearchTree {

    int[] last;
    Set<Integer> ans;
    public int[] findMode(TreeNode root) {
        last = new int[3];
        ans = new HashSet<>();
        dfs(root);
        return ans.stream().mapToInt(Integer::intValue).toArray();
    }

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.left);
        last[1] = last[0] == root.val ? last[1] + 1 : 1;
        last[0] = root.val;
        if (last[1] == last[2]) {
            ans.add(root.val);
        } else if (last[1] > last[2]) {
            last[2] = last[1];
            ans.clear();
            ans.add(root.val);
        }
        dfs(root.right);
    }
}
