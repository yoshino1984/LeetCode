package com.yoshino.p141to160;

import com.yoshino.model.ListNode;

import java.util.HashSet;
import java.util.Set;

public class P142LinkedListCycleII {
    public ListNode detectCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        while (head != null) {
            if (set.contains(head)) {
                return head;
            }
            set.add(head);
            head = head.next;
        }
        return null;
    }

    public ListNode detectCycle2(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                ListNode ptr1 = head;
                while (ptr1 != slow) {
                    ptr1 = ptr1.next;
                    slow = slow.next;
                }
                return ptr1;
            }
        }
        return null;
    }
}
