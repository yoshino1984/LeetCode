package com.yoshino.p251to300;

import com.yoshino.model.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树的所有路径
 **/
public class P257BinaryTreePaths {

    /**
     * 前序遍历
     * 时间复杂度O(N) N指节点数
     * 空间复杂度O(logN)
     */
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        dfs(root, "", ans);
        return new ArrayList<>(ans);
    }

    private void dfs(TreeNode root, String path, List<String> ans) {
        path += "->" + root.val;
        if (root.left == null && root.right == null) {
            ans.add(path.substring(2));
        }
        if (root.left != null) {
            dfs(root.left, path, ans);
        }
        if (root.right != null) {
            dfs(root.right, path, ans);
        }
    }

}
