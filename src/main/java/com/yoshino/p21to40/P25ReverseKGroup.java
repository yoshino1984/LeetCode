package com.yoshino.p21to40;

import com.yoshino.model.ListNode;

public class P25ReverseKGroup {

    public ListNode reverseKGroup1(ListNode head, int k) {
        if (k <= 1 || head == null || head.next == null) {
            return head;
        }
        ListNode listNode = new ListNode(0);
        listNode.next = head;
        ListNode pre = listNode;
        ListNode end = listNode;
        while (end.next != null) {
            for (int i = 0; i < k; i++) {
                if (end.next == null) {
                    return listNode.next;
                }
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

//    public ListNode reverseKGroup(ListNode head, int k) {
//        if (head == null) {
//            return null;
//        }
//        ListNode cur = head;
//        for (int i = 0; i < k - 1; i++) {
//            cur = cur.next;
//            if (cur == null) {
//                return head;
//            }
//        }
//
//        ListNode next = reverseKGroup(cur.next, k);
//        cur.next = null;
//        reverse(head);
//        head.next = next;
//        return cur;
//    }
//
//    private ListNode reverse(ListNode head) {
//        ListNode prev = null;
//        ListNode cur = head;
//        while (cur != null) {
//            ListNode next = cur.next;
//            cur.next = prev;
//            prev = cur;
//            cur = next;
//        }
//        return prev;
//    }


}
