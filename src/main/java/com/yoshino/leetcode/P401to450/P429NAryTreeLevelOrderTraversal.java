package com.yoshino.leetcode.P401to450;

import java.util.*;

/**
 * N叉树层序遍历
 **/
public class P429NAryTreeLevelOrderTraversal {
    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    /**
     * 基于队列的方式
     * 时间复杂度O(N)
     * 空间复杂度O(N)
     */
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }

        LinkedList<Node> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node cur = queue.pollFirst();
                level.add(cur.val);
                queue.addAll(cur.children);
            }
            ans.add(level);
        }

        return ans;
    }


    public List<List<Integer>> levelOrder3(Node root) {
        List<List<Integer>> ans = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        if (Objects.nonNull(root)) {
            queue.add(root);
        }

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                Node cur = queue.poll();
                level.add(cur.val);
                if (Objects.nonNull(cur.children)) {
                    queue.addAll(cur.children);
                }
            }
            ans.add(level);
        }

        return ans;
    }
}
