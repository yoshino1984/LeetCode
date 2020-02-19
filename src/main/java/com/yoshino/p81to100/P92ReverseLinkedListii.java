package com.yoshino.p81to100;

import com.yoshino.model.ListNode;

public class P92ReverseLinkedListii {

    /**
     * 总之就是链表遍历，需要记录反转起始点的前后信息
     * @param head
     * @param m
     * @param n
     * @return
     */
    public static ListNode reverseBetween(ListNode head, int m, int n) {
        if (m == n) {
            return head;
        }
        ListNode first = new ListNode(-1);
        first.next = head;
        for (int i = 1; i < m; i++) {
            first = first.next;
        }
        ListNode second = first;
        ListNode rear = second.next;
        ListNode areaRear = first.next;
        ListNode front = null;
        for (int i = m; i <= n; i++) {
            second = rear;
            rear = rear.next;
            second.next = front;
            front = second;
        }
        first.next = second;
        areaRear.next = rear;
        return first.val == -1 ? first.next : head;
    }

    public static void main(String[] args) {
        ListNode head = reverseBetween(ListNode.builder().val(1)
            .next(ListNode.builder().val(2)
                .next(ListNode.builder().val(3)
                    .next(ListNode.builder().val(4).next(
                        ListNode.builder().val(5).build()
                    ).build()).build()).build()).build(), 1, 4);

        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }

}
