package com.yoshino.p101to120;

import com.yoshino.model.TreeNode;

/**
 * 将有序数组转换为二叉搜索树
 **/
public class P108ConvertSortedArrayToBinarySearchTree {

    public TreeNode sortedArrayToBST(int[] nums) {
        return genTree(nums, 0, nums.length - 1);
    }

    private TreeNode genTree(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }

        int mid = start + (end - start) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = genTree(nums, start, mid - 1);
        root.right = genTree(nums,mid + 1, end);

        return root;
    }
}
