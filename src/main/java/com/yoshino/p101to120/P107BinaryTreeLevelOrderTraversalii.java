package com.yoshino.p101to120;

import com.yoshino.model.TreeNode;

import java.util.*;

/**
 * 二叉树的层次遍历
 *
 * @author wangxin
 * 2020/9/6 20:01
 * @since
 **/
public class P107BinaryTreeLevelOrderTraversalii {

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        LinkedList<List<Integer>> ans = new LinkedList<>();
        if (root == null) {
            return ans;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                level.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            ans.addFirst(level);
        }

        return ans;
    }
}
