package com.yoshino.leetcode.p501to600;

import java.util.*;

/**
 * N叉树的后序遍历
 **/
public class P590NAryTreePostorderTraversal {

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
    };

    /**
     * 递归方式
     * 时间复杂度O(N)
     * 空间复杂度O(N) 要存储返回结果
     */
    public List<Integer> postorder1(Node root) {
        List<Integer> ans = new ArrayList<>();
        helper(root, ans);
        return ans;
    }

    private void helper(Node node, List<Integer> ans) {
        if (node == null) {
            return;
        }
        if (Objects.nonNull(node.children) && !node.children.isEmpty()) {
            for (Node child : node.children) {
                helper(child, ans);
            }
        }
        ans.add(node.val);
    }

    /**
     * LinkedList 双端队列的巧妙用法，简化了后序遍历的复杂性
     */
    public List<Integer> postorder2(Node root) {
        LinkedList<Integer> ans = new LinkedList<>();
        if (root == null) {
            return ans;
        }
        LinkedList<Node> stack = new LinkedList<>();
        stack.add(root);

        while (!stack.isEmpty()) {
            Node cur = stack.pollLast();
            ans.addFirst(cur.val);
            for (Node child : cur.children) {
                if (Objects.nonNull(child)) {
                    stack.addLast(child);
                }
            }
        }

        return ans;
    }
}
