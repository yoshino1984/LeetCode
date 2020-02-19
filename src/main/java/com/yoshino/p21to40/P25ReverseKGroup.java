package com.yoshino.p21to40;

import com.yoshino.model.ListNode;

public class P25ReverseKGroup {

    public ListNode reverseKGroup(ListNode head, int k) {
        if (k <= 1 || head == null || head.next == null) {
            return head;
        }
        ListNode listNode = new ListNode(0);
        listNode.next = head;
        ListNode pre = listNode;
        ListNode end = listNode;
        while (end.next != null) {
            for (int i = 0; i < k && end.next != null; i++) {
                end = end.next;
            }
            ListNode start = pre.next;
            ListNode next = end.next;
            end.next = null;

            pre.next = reverse(start);

            start.next = next;
            pre = start;
            end = pre;
        }
        return listNode.next;

    }

    private ListNode reverse(ListNode head) {
        ListNode pre = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        return pre;
    }
}
