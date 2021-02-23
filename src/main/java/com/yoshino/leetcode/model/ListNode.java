package com.yoshino.leetcode.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ListNode {
    public Integer val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
    }

    public static void print(ListNode node) {
        System.out.println(node.val);
        while (node.next != null) {
            node = node.next;
            System.out.println(node.val);
        }
    }
}
