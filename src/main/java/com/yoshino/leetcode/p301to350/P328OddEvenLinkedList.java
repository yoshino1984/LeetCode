package com.yoshino.leetcode.p301to350;

import com.yoshino.leetcode.model.ListNode;

public class P328OddEvenLinkedList {

    /**
     * 使用双指针代表奇偶节点，一次遍历（注意偶数节点的尾节点的指向）
     * 时间复杂度O(N) 空间复杂度O(1)
     * @param head
     * @return
     */
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode oddNode = head;
        ListNode evenNode = oddNode.next;
        ListNode evenHead = evenNode;
        while (evenNode.next != null) {
            oddNode.next = evenNode.next;
            oddNode = oddNode.next;
            if (oddNode.next == null) {
                evenNode.next = null;
                break;
            } else {
                evenNode.next = oddNode.next;
                evenNode = evenNode.next;
            }
        }
        oddNode.next = evenHead;
        return head;
    }



}
