package com.yoshino.leetcode.p951to1000;

import com.yoshino.leetcode.model.TreeNode;

/**
 * 监控二叉树
 *
 * @author wangxin
 * 2020/9/22 23:22
 * @since
 **/
public class P968BinaryTreeCameras {

//    /**
//     * 贪婪解法
//     * 时间复杂度O(N)
//     */
//    int res = 0;
//    public int minCameraCover(TreeNode root) {
//        return (dfs(root) < 1 ? 1 : 0) + res;
//    }
//
//    private int dfs(TreeNode root) {
//        if (root == null) {
//            return 2;
//        }
//        int left = dfs(root.left), right = dfs(root.right);
//        if (left == 0 || right == 0) {
//            res++;
//            return 1;
//        }
//        return left == 1 || right == 1 ? 2 : 0;
//    }

    /**
     * dp解法
     */
    public int minCameraCover(TreeNode root) {
        return dfs(root)[1];
    }

    private int[] dfs(TreeNode root) {
        if (root == null) {
            return new int[]{Integer.MAX_VALUE / 2, 0, 0};
        }
        int[] left = dfs(root.left), right = dfs(root.right);
        int[] cur = new int[3];
        cur[0] = left[2] + right[2] + 1;
        cur[1] = Math.min(cur[0], Math.min(left[1] + right[0], left[0] + right[1]));
        cur[2] = Math.min(cur[0], left[1] + right[1]);
        return cur;
    }
}
