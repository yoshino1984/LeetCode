package com.yoshino.leetcode.p601to650;

import com.yoshino.leetcode.model.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 二叉树的平均值
 **/
public class P637AverageOfLevelsInBinaryTree {

    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> ans = new ArrayList<>();
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            double sum = 0, cnt = 0;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                cnt++;
                sum += node.val;
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            ans.add(sum / cnt);
        }
        return ans;
    }
}
