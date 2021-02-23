package com.yoshino.leetcode.p21to40;

import com.yoshino.leetcode.model.ListNode;

/**
 * @author wangxin
 * 2020/4/6 09:58
 * @since
 **/
public class P24SwapNodesInPairs {

    public ListNode swapPairs(ListNode head) {
        ListNode prev = new ListNode(-1);
        prev.next = head;
        ListNode cur = prev;
        while (cur.next != null && cur.next.next != null) {
            ListNode first = cur.next;
            ListNode second = cur.next.next;

            first.next = second.next;
            second.next = first;
            cur.next = second;
            cur = first;
        }
        return prev.next;
    }
}
