package com.yoshino.leetcode.p101to120;

import com.yoshino.leetcode.model.Node;

/**
 * 填充每个节点的下一个右侧节点指针II
 **/
public class P117PopulatingNextRightPointersInEachNodeii {

    Node last = null;
    Node nextStart = null;
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }

        Node start = root;
        while (start != null) {
            last = null;
            nextStart = null;
            for (Node p = start; p != null ; p = p.next) {
                if (p.left != null) {
                    handle(p.left);
                }
                if (p.right != null) {
                    handle(p.right);
                }
            }
            start = nextStart;
        }
        return root;
    }

    private void handle(Node p) {
        if (last != null) {
            last.next = p;
        }
        if (nextStart == null) {
            nextStart = p;
        }
        last = p;
    }
}
