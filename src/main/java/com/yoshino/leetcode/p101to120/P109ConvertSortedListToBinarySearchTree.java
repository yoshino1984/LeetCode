package com.yoshino.leetcode.p101to120;

import com.yoshino.leetcode.model.ListNode;
import com.yoshino.leetcode.model.TreeNode;

/**
 * 有序链表转换为二叉搜索树
 *
 **/
public class P109ConvertSortedListToBinarySearchTree {

    /**
     * 一次遍历，快慢指针寻找中位数做root节点，左边节点作为左子树，右边节点作为右子树，分治递归
     * 时间复杂度O(NlogN)
     * 空间复杂度O(N) 如果只计算返回答案之外的空间则为O(logN)
     */
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode slow = head, fast = head.next, prevTail = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            prevTail = slow;
            slow = slow.next;
        }

        TreeNode root = new TreeNode(slow.val);
        root.right = sortedListToBST(slow.next);
        if (prevTail != slow) {
            prevTail.next = null;
            root.left = sortedListToBST(head);
        }

        return root;
    }
}
