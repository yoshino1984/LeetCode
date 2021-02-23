package com.yoshino.leetcode.p101to120;

import com.yoshino.leetcode.model.ListNode;
import com.yoshino.leetcode.model.TreeNode;

import java.util.*;

/**
 * 二叉树的层序遍历
 **/
public class P102BinaryTreeLevelOrderTraversal {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
//        dfs(0, root, ans);
        bfs(root, ans);
        return ans;
    }

    /**
     * 广度优先遍历
     * @param root
     * @param ans
     */
    private void bfs(TreeNode root, List<List<Integer>> ans) {
        if (root == null) {
            return;
        }

        Deque<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.pollFirst();
                level.add(node.val);
                if (Objects.nonNull(node.left)) {
                    queue.addLast(node.left);
                }
                if (Objects.nonNull(node.right)) {
                    queue.addLast(node.right);
                }
            }
            ans.add(level);
        }
    }

    /**
     * 深度优先遍历
     * 时间复杂度O(N) N为节点个数
     * 空间复杂度O(N)
     * @param level
     * @param node
     * @param ans
     */
    private void dfs(int level, TreeNode node, List<List<Integer>> ans) {
        if (Objects.isNull(node)) {
            return;
        }

        if (level == ans.size()) {
            List<Integer> levelList = new ArrayList<>();
            levelList.add(node.val);
            ans.add(level, levelList);
        } else {
            ans.get(level).add(node.val);
        }

        dfs(level + 1, node.left, ans);
        dfs(level + 1, node.right, ans);
    }

}
