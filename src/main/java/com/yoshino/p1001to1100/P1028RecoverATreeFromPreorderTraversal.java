package com.yoshino.p1001to1100;

import com.yoshino.model.Solution;
import com.yoshino.model.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 从先序遍历还原二叉树
 *
 * @author wangxin
 * 2020/6/18 21:04
 * @since
 **/
public class P1028RecoverATreeFromPreorderTraversal {

    /**
     * 迭代解法
     * 时间复杂度O(N) 字符串的长度
     * @param S
     * @return
     */
    public TreeNode recoverFromPreorder(String S) {
        int count = 0;
        StringBuilder num = new StringBuilder();
        List<TreeNode> levelList = new ArrayList<>();
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == '-') {
                if (S.charAt(i - 1) != '-') {
                    addNodeToTree(count, num, levelList);
                    count = 0;
                    num = new StringBuilder();
                }
                count++;
            } else {
                num.append(S.charAt(i));
            }
        }
        // 处理最后一个数
        addNodeToTree(count, num, levelList);
        return levelList.get(0);
    }

    private void addNodeToTree(int count, StringBuilder num, List<TreeNode> levelList) {
        TreeNode cur = new TreeNode(Integer.parseInt(num.toString()));
        levelList.add(count, cur);
        if (count > 0) {
            if (levelList.get(count - 1).left == null ) {
                levelList.get(count - 1).left = cur;
            } else {
                levelList.get(count - 1).right = cur;
            }
        }
    }

    public static void main(String[] args) {
        new P1028RecoverATreeFromPreorderTraversal().recoverFromPreorder("1-2--3--4-5--6--7");
    }
}
