package com.yoshino.leetcode.p81to100;

import com.yoshino.leetcode.model.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 恢复二叉搜索树
 **/
public class P99RecoverBinarySearchTree {

    public void recoverTree(TreeNode root) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode first = null, second = null, prev = null;

        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();

            if (prev != null && root.val < prev.val) {
                second = root;
                if (first == null) {
                    first = prev;
                } else {
                    break;
                }
            }
            prev = root;
            root = root.right;
        }

        swap(first, second);
    }

    private void swap(TreeNode x, TreeNode y) {
        int temp = x.val;
        x.val = y.val;
        y.val = temp;
    }
}
