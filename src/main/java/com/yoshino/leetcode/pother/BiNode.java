package com.yoshino.leetcode.pother;

import com.yoshino.leetcode.model.Node;
import com.yoshino.leetcode.model.TreeNode;

import java.util.Objects;

/**
 * 17.12. BiNode
 *
 **/
public class BiNode {

    public TreeNode convertBiNode(TreeNode root) {
        return Objects.isNull(root) ? null : inOrder(root);
    }

    private TreeNode inOrder(TreeNode node) {
        if (node == null) {
            return null;
        }

        TreeNode subRoot = inOrder(node.left);
        if (subRoot == null) {
            subRoot = node;
        } else {
            TreeNode cur = subRoot;
            while (cur.right != null) {
                cur = cur.right;
            }
            cur.right = node;
        }
        // 左侧节点置为null（否则结果不正确 会有环）
        node.left = null;
        node.right = inOrder(node.right);
        return subRoot;
    }
}
