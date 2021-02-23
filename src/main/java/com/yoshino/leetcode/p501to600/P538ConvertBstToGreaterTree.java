package com.yoshino.leetcode.p501to600;

import com.yoshino.leetcode.model.TreeNode;

/**
 * 把二叉搜索树转换为累加树
 *
 * @author wangxin
 * 2020/9/21 23:20
 * @since
 **/
public class P538ConvertBstToGreaterTree {

    int sum;

    public TreeNode convertBST(TreeNode root) {
        sum = 0;
        if (root != null) {
            convertBST(root.right);
            sum += root.val;
            root.val = sum;
            convertBST(root.left);
        }
        return root;
    }
}
