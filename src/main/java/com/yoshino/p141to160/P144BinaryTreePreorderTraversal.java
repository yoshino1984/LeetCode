package com.yoshino.p141to160;

import com.yoshino.model.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 前序遍历
 * @since
 **/
public class P144BinaryTreePreorderTraversal {

    public List<Integer> preorderTraversal1(TreeNode root) {
        List<Integer> retList = new ArrayList<>();
        helper(root, retList);
        return retList;
    }

    private void helper(TreeNode node, List<Integer> retList) {
        if (node == null) {
            return;
        }
        retList.add(node.val);
        helper(node.left, retList);
        helper(node.right, retList);
    }

    public List<Integer> preorderTraversal2(TreeNode root) {
        List<Integer> retList = new ArrayList<>();
        if (root == null) {
            return retList;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);

        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            retList.add(cur.val);
            if (cur.right != null) {
                stack.push(cur.right);
            }
            if (cur.left != null) {
                stack.push(cur.left);
            }
        }

        return retList;
    }
}
