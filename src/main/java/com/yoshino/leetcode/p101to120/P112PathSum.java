package com.yoshino.leetcode.p101to120;

import com.yoshino.leetcode.model.TreeNode;

public class P112PathSum {

    /**
     * 使用深度优先遍历的方式（相较于广度优先遍历，可能提前直接得出结果）
     * O(N)，最坏情况下需要遍历所有叶子节点才能确定
     *
     * @param root
     * @param sum
     * @return
     */
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        return hasPathSumIter(root, sum, 0);
    }

    private boolean hasPathSumIter(TreeNode root, int sum, int currSum) {
        currSum += root.val;
        if (root.left == null && root.right == null) {
            return currSum == sum;
        }
        boolean result = false;
        if (root.left != null) {
            result = hasPathSumIter(root.left, sum, currSum);
        }
        if (result) {
            return true;
        }
        if (root.right != null) {
            result = hasPathSumIter(root.right, sum, currSum);
        }
        return result;
    }

}
