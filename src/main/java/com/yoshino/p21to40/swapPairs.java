package com.yoshino.p21to40;

import com.yoshino.model.ListNode;

public class swapPairs {

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pre = null;
        ListNode next = null;
        ListNode returnNode = head.next;
        while (head != null && head.next != null) {
            if (pre != null) {
                pre.next = head.next;
            }
            pre = head;
            head = head.next;
            next = head.next;

            pre.next = next;
            head.next = pre;

            head = next;
        }
        return returnNode;
    }
}
