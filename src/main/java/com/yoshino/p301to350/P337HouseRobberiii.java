package com.yoshino.p301to350;

import com.yoshino.model.TreeNode;

/**
 * 打家劫舍iii
 * @since
 **/
public class P337HouseRobberiii {

    public int rob(TreeNode root) {
        int[] rootStatus = dfs(root);
        return Math.max(rootStatus[0], rootStatus[1]);
    }

    private int[] dfs(TreeNode root) {
        if (root == null) {
            return new int[]{0, 0};
        }

        int[] l = dfs(root.left);
        int[] r = dfs(root.right);
        int selected = root.val + l[1] + r[1];
        int unSelected = Math.max(r[0], r[1]) + Math.max(l[0], l[1]);
        return new int[]{selected, unSelected};
    }

}
