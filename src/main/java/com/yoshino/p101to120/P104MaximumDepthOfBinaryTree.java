package com.yoshino.p101to120;

import com.yoshino.model.TreeNode;

public class P104MaximumDepthOfBinaryTree {

    static int maxDepth = 0;
    public int maxDepth(TreeNode root) {
        maxDepth = 0;
        maxDepthIter(root, 0);
        return maxDepth;
    }

    private static void maxDepthIter(TreeNode root, int curDepth) {
        if (root == null) {
            maxDepth = Math.max(curDepth, maxDepth);
            return;
        }
        curDepth++;
        maxDepthIter(root.left, curDepth);
        maxDepthIter(root.right, curDepth);
    }
}
