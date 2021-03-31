package com.yoshino.leetcode.p81to100;

import com.yoshino.leetcode.model.ListNode;

public class P83 {

    public ListNode deleteDuplicates(ListNode head) {
        if (head != null) {
            ListNode cur = head;
            while (cur.next != null) {
                if (cur.val == cur.next.val) {
                    cur.next = cur.next.next;
                } else {
                    cur = cur.next;
                }
            }
        }
        return head;
    }
}
