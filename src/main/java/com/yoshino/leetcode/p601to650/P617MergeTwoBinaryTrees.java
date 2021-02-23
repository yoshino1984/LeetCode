package com.yoshino.leetcode.p601to650;

import com.yoshino.leetcode.model.TreeNode;

/**
 * 合并二叉树
 *
 * @author wangxin
 * 2020/9/23 22:35
 * @since
 **/
public class P617MergeTwoBinaryTrees {

    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        return preOrder(t1, t2);
    }

    private TreeNode preOrder(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return null;
        }

        TreeNode root = new TreeNode();
        if (t1 == null) {
            root = t2;
        } else if (t2 == null) {
            root = t1;
        } else {
            root.val = t1.val + t2.val;
            root.left = preOrder(t1.left, t2.left);
            root.right = preOrder(t1.right, t2.right);
        }

        return root;
    }
}
