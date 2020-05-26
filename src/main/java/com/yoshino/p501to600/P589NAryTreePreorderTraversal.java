package com.yoshino.p501to600;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * N叉树的前序遍历
 **/
public class P589NAryTreePreorderTraversal {

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
    public List<Integer> preorder1(Node root) {
        List<Integer> ans = new ArrayList<>();
        helper(root, ans);
        return ans;
    }

    private void helper(Node node, List<Integer> ans) {
        if (node == null) {
            return;
        }
        ans.add(node.val);
        if (node.children != null || node.children.size() > 0) {
            for (Node child : node.children) {
                helper(child, ans);
            }
        }
    }

    /**
     * LinkedList 双端队列的巧妙用法，简化了后序遍历的复杂性
     */
    public List<Integer> preorder2(Node root) {
        LinkedList<Integer> ans = new LinkedList<>();
        if (root == null) {
            return ans;
        }

        LinkedList<Node> stack = new LinkedList<>();
        stack.add(root);

        while (!stack.isEmpty()) {
            Node cur = stack.pollFirst();
            ans.addLast(cur.val);

            for (int i = cur.children.size() - 1; i >= 0; i--) {
                stack.addFirst(cur.children.get(i));
            }
        }

        return ans;
    }
}
