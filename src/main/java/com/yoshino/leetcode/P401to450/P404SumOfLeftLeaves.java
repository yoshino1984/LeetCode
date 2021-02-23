package com.yoshino.leetcode.P401to450;

import com.yoshino.leetcode.model.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 左叶子之和
 *
 * @author wangxin
 * 2020/9/19 19:41
 * @since
 **/
public class P404SumOfLeftLeaves {


    public int sumOfLeftLeaves(TreeNode root) {
        return root == null ? 0 : dfs(root);
    }

    private int dfs(TreeNode node) {
        int ans = 0;
        if (node.left != null) {
            ans += isLeafNode(node.left) ? node.left.val : dfs(node.left);
        }
        if (node.right != null) {
            ans += dfs(node.right);
        }
        return ans;
    }

    private boolean isLeafNode(TreeNode node) {
        return node.left == null && node.right == null;
    }

    /**
     * bfs
     */
    public int sumOfLeftLeaves2(TreeNode root) {
        int ans = 0;
        if (root == null) {
            return ans;
        }
        Queue<TreeNode> leftQueue = new ArrayDeque<>();
        Queue<TreeNode> rightQueue = new ArrayDeque<>();
        rightQueue.offer(root);
        while (!leftQueue.isEmpty() || !rightQueue.isEmpty()) {
            int leftSize = leftQueue.size();
            int rightSize = rightQueue.size();
            for (int i = 0; i < leftSize; i++) {
                TreeNode node = leftQueue.poll();
                if (node.right == null && node.left == null) {
                    ans += node.val;
                } else {
                    if (node.right != null) {
                        rightQueue.offer(node.right);
                    }
                    if (node.left != null) {
                        leftQueue.offer(node.left);
                    }
                }
            }

            for (int i = 0; i < rightSize; i++) {
                TreeNode node = rightQueue.poll();
                if (node.right != null) {
                    rightQueue.offer(node.right);
                }
                if (node.left != null) {
                    leftQueue.offer(node.left);
                }
            }
        }
        return ans;
    }
}
