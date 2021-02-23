package com.yoshino.leetcode.p701to750;

import com.yoshino.leetcode.model.ListNode;

public class P725SplitLinkedListInParts {

    /**
     * 首先遍历链表，获取链表的长度，然后计算数组每个元素链的长度
     * 分割链表注意哟啊保证数组元素的最后节点应该是指向null的
     * 时间复杂度O(N)
     * 空间复杂度O(1)
     * @param root
     * @param k
     * @return
     */
    public ListNode[] splitListToParts(ListNode root, int k) {
        if (root == null) {
            return new ListNode[k];
        }
        ListNode front = new ListNode(-1);
        front.next = root;
        ListNode head = front;
        int count = 0;
        while (head.next != null) {
            count++;
            head = head.next;
        }
        ListNode[] res = new ListNode[k];
        int per = count / k;
        int limit = count % k;

        head = front.next;
        int turnCnt = 0;
        while (head != null) {
            int temp = per + (turnCnt < limit ? 1 : 0);
            res[turnCnt] = head;
            ListNode lastNode = head;
            for (int i = 0; i < temp; i++) {
                if (head != null) {
                    lastNode = head;
                    head = head.next;
                } else {
                    break;
                }
            }
            lastNode.next = null;
            turnCnt++;
        }
        return res;
    }

}
