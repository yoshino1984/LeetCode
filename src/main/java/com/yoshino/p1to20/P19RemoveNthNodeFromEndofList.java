package com.yoshino.p1to20;

import com.yoshino.model.ListNode;

public class P19RemoveNthNodeFromEndofList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return null;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode slow = dummy;
        ListNode fast = dummy;
        int count = 0;
        while (count < n) {
            if (fast.next == null) {
                return dummy.next;
            }
            fast = fast.next;
            count++;
        }
        while (true) {
            if (fast.next == null) {
                slow.next = slow.next.next;
                return dummy.next;
            }
            fast = fast.next;
            slow = slow.next;
        }
    }
}
