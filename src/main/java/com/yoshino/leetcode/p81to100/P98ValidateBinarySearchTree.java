package com.yoshino.leetcode.p81to100;

import com.yoshino.leetcode.model.TreeNode;

public class P98ValidateBinarySearchTree {

    /**
     * 使用中遍历的方式，对二叉搜索树进行遍历，应该是有序的（由小到大）
     * 时间复杂度O(N)
     *
     * @param root
     * @return
     */
    public static boolean isValidBST(TreeNode root) {
        minVal = Long.MIN_VALUE;
        return validBSTIter(root);
    }

    private static long minVal = Long.MIN_VALUE;

    private static boolean validBSTIter(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (!validBSTIter(root.left)) {
            return false;
        }
        if (minVal < root.val) {
            minVal = root.val;
        } else {
            return false;
        }
        if (!validBSTIter(root.right)) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(minVal);
        System.out.println(minVal < Integer.MIN_VALUE);
        System.out.println(isValidBST(new TreeNode(-2147483648)));
    }
}
