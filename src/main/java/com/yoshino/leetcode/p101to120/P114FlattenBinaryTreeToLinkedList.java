package com.yoshino.leetcode.p101to120;

import com.yoshino.leetcode.model.TreeNode;

/**
 * 二叉树展开为链表
 **/
public class P114FlattenBinaryTreeToLinkedList {

    TreeNode lastNode;
    public void flatten(TreeNode root) {
        lastNode = new TreeNode(-1);
        dfs(root);
    }

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }

        TreeNode right = root.right;
        TreeNode left = root.left;
        lastNode.right = root;
        lastNode.left = null;
        lastNode = root;
        dfs(left);
        dfs(right);
    }
}


