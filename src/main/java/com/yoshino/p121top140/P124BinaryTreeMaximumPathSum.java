package com.yoshino.p121top140;

import com.yoshino.model.TreeNode;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 二叉树中的最大路径和
 *
 * @author wangxin
 * 2020/6/21 09:29
 * @since
 **/
public class P124BinaryTreeMaximumPathSum {

    /**
     * dfs 解法 最大路径和分为三种情况，对于每个根节点分开处理
     * 时间复杂度O(N)
     * 空间复杂度O(N) 栈的深度最坏情况下是单链表的树
     * @param root
     * @return
     */
    public int maxPathSum(TreeNode root) {
        ans = Integer.MIN_VALUE;
        dfs(root);
        return ans;
    }

    private int ans;

    private int dfs(TreeNode root) {
        if (Objects.isNull(root)) {
            return 0;
        }

        int left = dfs(root.left);
        int right = dfs(root.right);
        // 处理最大值为不包含当前节点父节点的情况
        int curMaxPath = left + right + root.val;
        ans = Math.max(ans, curMaxPath);
        // 处理最大值包含父节点的情况
        return Math.max(0, root.val + Math.max(left, right));
    }


}
