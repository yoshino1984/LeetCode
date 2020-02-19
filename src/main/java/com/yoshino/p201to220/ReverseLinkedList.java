package com.yoshino.p201to220;

import com.yoshino.model.ListNode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode next = head.next;
        head.next = null;
        ListNode tempNode = null;
        while (next != null) {
            tempNode = next.next;
            next.next = head;
            head = next;
            next = tempNode;
        }
        return head;
    }


}
