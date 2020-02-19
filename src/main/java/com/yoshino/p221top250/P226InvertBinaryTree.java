package com.yoshino.p221top250;


import com.yoshino.model.TreeNode;

public class P226InvertBinaryTree {

    public static TreeNode invertTree(TreeNode root) {
        invertChildTree(root);
        return root;
    }

    private static void invertChildTree(TreeNode root) {
        if (root == null) {
            return;
        }
        invertTree(root.left);
        invertTree(root.right);
        TreeNode tmpNode = root.left;
        root.left = root.right;
        root.right = tmpNode;
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.builder().val(4)
            .left(TreeNode.builder().val(2)
                .left(new TreeNode(1))
                .right(new TreeNode(3))
            .build())
            .right(TreeNode.builder().val(7)
                .left(new TreeNode(6))
                .right(new TreeNode(9))
                .build())
            .build();
        System.out.println(invertTree(root));
    }
}
