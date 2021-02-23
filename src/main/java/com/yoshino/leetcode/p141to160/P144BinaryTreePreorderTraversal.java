package com.yoshino.leetcode.p141to160;

import com.yoshino.leetcode.model.TreeNode;

import java.util.*;

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
        List<Integer> ans = new ArrayList<>();
        LinkedList<TreeNode> deque = new LinkedList<>();
        if (root != null) {
            deque.add(root);
        }

        while (!deque.isEmpty()) {
            TreeNode cur = deque.pollFirst();
            ans.add(cur.val);
            if (Objects.nonNull(cur.right)) {
                deque.addFirst(cur.right);
            }
            if (Objects.nonNull(cur.left)) {
                deque.addFirst(cur.left);
            }
        }

        return ans;
    }
}
