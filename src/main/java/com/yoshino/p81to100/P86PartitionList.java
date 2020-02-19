package com.yoshino.p81to100;

import com.yoshino.model.ListNode;

public class P86PartitionList {


    public static ListNode partition(ListNode head, int x) {
        ListNode less = new ListNode(-1);
        ListNode big = new ListNode((-1));
        ListNode curLess = less;
        ListNode curBig = big;
        while (head != null) {
            if (head.val < x) {
                curLess.next = head;
                curLess = curLess.next;
            } else {
                curBig.next = head;
                curBig = curBig.next;
            }
            head = head.next;
        }
        curBig.next = null;
        curLess.next = big.next;
        return less.next;
    }

    public static void main(String[] args) {
        ListNode head = ListNode.builder().val(1).next(
            ListNode.builder().val(4).next(
                ListNode.builder().val(3).next(
                    ListNode.builder().val(2).next(
                        ListNode.builder().val(5).next(
                            ListNode.builder().val(2).build()
                        ).build()
                    ).build()
                ).build()
            ).build()
        ).build();
        partition(head, 3);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }

    }

}
