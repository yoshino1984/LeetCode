package com.yoshino.p651to700;

import com.yoshino.model.TreeNode;

/**
 * 最长同值路径
 * 递归解法，时间复杂度O(N)-节点个数
 * @author wangxin
 * 2020/5/3 16:33
 * @since
 **/
public class P689LongestUnivaluePath {

    private int longest;

    public int longestUnivaluePath(TreeNode root) {
        longest = 0;
        findSinglePath(root);
        return longest;
    }

    private int findSinglePath(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return 0;
        }
        int right = 0;
        int left = 0;
        if (root.left != null) {
            if (root.val == root.left.val) {
                left = 1 + findSinglePath(root.left);
            } else {
                findSinglePath(root.left);
            }
        }
        if (root.right != null) {
            if (root.val == root.right.val) {
                right = 1 + findSinglePath(root.right);
            } else {
                findSinglePath(root.right);
            }
        }
        longest = Math.max(longest, left + right);
        return Math.max(right, left);
    }

    public static void main(String[] args) {
        TreeNode node11 = new TreeNode(1);
        TreeNode node21 = new TreeNode(4);
        TreeNode node22 = new TreeNode(5);
        node11.left = node21;
        node11.right = node22;
        TreeNode node31 = new TreeNode(4);
        TreeNode node32 = new TreeNode(4);
        TreeNode node33 = new TreeNode(5);
        node21.left = node31;
        node21.right = node32;
        node22.left = node33;
        new P689LongestUnivaluePath().longestUnivaluePath(node11);

        int[] nums2 = new int[]{1,2};
        arrayTest(nums2);
        System.out.println(nums2[0]);
    }


    static void arrayTest(int[] nums) {
        nums[0]++;
    }


}
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
