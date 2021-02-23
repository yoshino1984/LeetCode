package com.yoshino.leetcode.p81to100;

import com.yoshino.leetcode.model.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 不同的二叉搜索树ii
 **/
public class P95UniqueBinarySearchTreesii {

    public List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return new ArrayList<>();
        }

        return generateTrees(1, n);
    }

    private List<TreeNode> generateTrees(int start, int end) {
        List<TreeNode> allTrees = new ArrayList<>();
        if (start > end) {
            allTrees.add(null);
            return allTrees;
        }

        for (int i = start; i <= end; i++) {
            List<TreeNode> leftTrees = generateTrees(start, i - 1);
            List<TreeNode> rightTrees = generateTrees(i + 1, end);

            for (TreeNode left : leftTrees) {
                for (TreeNode right : rightTrees) {
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    allTrees.add(root);
                }
            }
        }

        return allTrees;
    }
}
