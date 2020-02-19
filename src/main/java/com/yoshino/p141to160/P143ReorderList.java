package com.yoshino.p141to160;

import com.yoshino.model.ListNode;

import java.util.List;

public class P143ReorderList {

    /**
     * 1、使用快慢指针寻找链表中间点
     * 2、逆转后半段的链表
     * 3、然后从前后同时遍历链表，重拍链表
     * 时间复杂度O(N)
     * @param head
     */
    public static void reorderList(ListNode head) {
        if (head == null) {
            return;
        }
        ListNode fast = new ListNode(-1);
        fast.next = head;
        ListNode slow = fast;
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
            if (fast.next == null) {
                break;
            }
            fast = fast.next;
        }
        ListNode front = slow;
        ListNode rear = slow.next;
        front.next = null;
        while (rear != null) {
            slow = rear;
            rear = rear.next;
            slow.next = front;
            front = slow;
        }
        front = head;
        rear = slow;
        ListNode front2 = front.next;
        ListNode rear2 = rear.next;
        while (front2 != null && rear2 != null) {
            front.next = rear;
            rear.next = front2;
            front = front2;
            rear = rear2;
            front2 = front2.next;
            rear2 = rear2.next;
        }
        if (rear2 != null) {
            front.next = rear;
            rear.next = front2;
        }
    }

    public static void main(String[] args) {
        ListNode head = ListNode.builder().val(1)
            .next(ListNode.builder().val(2)
                .next(ListNode.builder().val(3)
                    .next(ListNode.builder().val(4)
                        .next(ListNode.builder().val(5).build())
                        .build()).build()).build()).build();
        reorderList(head);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }

}
