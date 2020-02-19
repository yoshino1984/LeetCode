package com.yoshino.p61to80;

import com.yoshino.model.ListNode;

public class P61RotateList {

    /**
     * 首先做一次扫描，求得链表的长度n，并且对k求余，使得k小于n，
     * 其次，使用双指针法，求得旋转点，进行旋转炒作
     * @param head
     * @param k
     * @return
     */
    public static ListNode rotateRight(ListNode head, int k) {
        if (head == null || k <= 0) {
            return head;
        }
        ListNode second = new ListNode(-1);
        second.next = head;
        ListNode first = second;
        int count = 0;
        for (int i = 0; i < k; i++) {
            if (second.next != null) {
                second = second.next;
                count++;
            }
        }
        // 对k进行处理，避免超过一次扫描
        k = k <= count ? k : k % count;
        second = first;
        // 寻找旋转点
        for (int i = 0; i < k; i++) {
            if (second.next != null) {
                second = second.next;
            } else {
                second = head;
            }
        }
        if (second.next == null) {
            return head;
        }
        while (second.next != null) {
            second = second.next;
            first = first.next;
        }
        second.next = head;
        ListNode res = first.next;
        first.next = null;
        return res;
    }

    public static void main(String[] args) {
        System.out.println(rotateRight(ListNode.builder().val(1)
            .next(ListNode.builder().val(2)
                .next(ListNode.builder().val(4)
                    .next(ListNode.builder().val(5).build()).build()).build()).build(), 12).val);
    }
}
