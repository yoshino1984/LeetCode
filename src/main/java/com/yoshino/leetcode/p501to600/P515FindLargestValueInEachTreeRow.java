package com.yoshino.leetcode.p501to600;

import com.yoshino.leetcode.model.TreeNode;

import java.util.*;

/**
 * 在每个树行中找最大值
 *
 * @author wangxin
 * 2020/6/11 22:51
 * @since
 **/
public class P515FindLargestValueInEachTreeRow {

    /**
     * bfs
     * @param root
     * @return
     */
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
//        bfs(root, ans);
        dfs(root, ans, 1);
        return ans;
    }

    /**
     * 深度优先dfs
     * @param node
     * @param ans
     * @param level
     */
    private void dfs(TreeNode node, List<Integer> ans, int level) {
        if (Objects.isNull(node)) {
            return;
        }
        if (level > ans.size()) {
            ans.add(node.val);
        } else {
            ans.set(level - 1, Math.max(ans.get(level - 1), node.val));
        }

        dfs(node.left, ans, level + 1);
        dfs(node.right, ans, level + 1);
    }

    /**
     * 广度优先bfs
     * @param root
     * @param ans
     */
    private void bfs(TreeNode root, List<Integer> ans) {
        if (Objects.isNull(root)) {
            return;
        }

        Deque<TreeNode> queue = new LinkedList<>();
        queue.addLast(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            int max = queue.peek().val;
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.pollFirst();
                max = Math.max(max, cur.val);
                if (Objects.nonNull(cur.left)) {
                    queue.addLast(cur.left);
                }
                if (Objects.nonNull(cur.right)) {
                    queue.addLast(cur.right);
                }
            }
            ans.add(max);
        }
    }
}
