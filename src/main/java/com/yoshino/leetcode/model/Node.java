package com.yoshino.leetcode.model;

import lombok.experimental.SuperBuilder;

import java.util.List;

@SuperBuilder
public class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
    public List<Node> children;
    public Node random;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }

}
