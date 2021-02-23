package com.yoshino.leetcode.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

/**
 * Definition for a binary tree node.
 */
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int x) {
        val = x;
    }
}
