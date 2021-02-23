package com.yoshino.leetcode.p141to160;

import com.yoshino.leetcode.model.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * 二叉树的后序遍历
 *
 * @author wangxin
 * 2020/9/29 20:05
 * @since
 **/
public class P145BinaryTreePostorderTraversal {

    public List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<Integer> ans = new LinkedList<>();
        if (root == null) {
            return ans;
        }
        LinkedList<TreeNode> deque = new LinkedList<>();
        deque.offer(root);
        while (!deque.isEmpty()) {
            TreeNode node = deque.pollLast();
            ans.addFirst(node.val);
            if (node.left != null) {
                deque.offerLast(node.left);
            }
            if (node.right != null) {
                deque.offerLast(node.right);
            }
        }

        return ans;
    }

}
