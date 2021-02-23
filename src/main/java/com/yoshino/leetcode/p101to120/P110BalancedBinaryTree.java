package com.yoshino.leetcode.p101to120;

import com.yoshino.leetcode.model.TreeNode;

/**
 * 是否平衡二叉树
 **/
public class P110BalancedBinaryTree {

    public boolean isBalanced(TreeNode root) {
        isBalance = true;
        dfs(root);
        return isBalance;
    }
    boolean isBalance;

    private int dfs(TreeNode root) {
        if (!isBalance || root == null) {
            return 0;
        }

        int left = dfs(root.left);
        int right = dfs(root.right);

        if (Math.abs(left - right) > 1) {
            isBalance = false;
        }

        return Math.max(left, right) + 1;
    }
}
