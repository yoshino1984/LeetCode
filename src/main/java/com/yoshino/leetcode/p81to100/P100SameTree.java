package com.yoshino.leetcode.p81to100;

import com.yoshino.leetcode.model.TreeNode;

/**
 * 相同的树
 **/
public class P100SameTree {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        return preDfs(p, q);
    }

    private boolean preDfs(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        } else if (p == null || q == null) {
            return false;
        }

        return p.val == q.val && preDfs(p.left, q.left) && preDfs(p.right, q.right);
    }
}
