package com.yoshino.leetcode.p1201to1300;

import com.yoshino.leetcode.model.TreeNode;

import java.util.HashSet;
import java.util.Set;

/**
 * 查找两棵二叉搜索树之和
 *
 * @author wangxin
 * 2020/5/8 00:35
 * @since
 **/
public class P1214TwoSumBsts {
    
    public boolean twoSumBSTs(TreeNode root1, TreeNode root2, int target) {
        if (root1 == null || root2 == null) {
            return false;
        }
        Set<Integer> valSet1 = new HashSet<>();
        inOrder(root1, valSet1);
        return findTargetInOrder(root2, target, valSet1);
    }

    private boolean findTargetInOrder(TreeNode root2, int target, Set<Integer> valSet1) {
        if (root2 == null) {
            return false;
        }
        return findTargetInOrder(root2.left, target, valSet1)
            || valSet1.contains(target - root2.val)
            || findTargetInOrder(root2.right, target, valSet1);
    }

    private void inOrder(TreeNode node, Set<Integer> valSet) {
        if (node == null) {
            return;
        }

        inOrder(node.left, valSet);
        valSet.add(node.val);
        inOrder(node.right, valSet);
    }

}
