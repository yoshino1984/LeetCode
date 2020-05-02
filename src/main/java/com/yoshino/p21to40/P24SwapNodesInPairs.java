package com.yoshino.p21to40;

import com.yoshino.model.ListNode;

/**
 * @author wangxin
 * 2020/4/6 09:58
 * @since
 **/
public class P24SwapNodesInPairs {

    public ListNode swapPairs(ListNode head) {
        ListNode pre = new ListNode(-1);
        pre.next = head;
        ListNode temp = pre;
        while (temp.next != null && temp.next.next != null) {
            ListNode first = temp.next;
            ListNode second = temp.next.next;
            first.next = second.next;
            second.next = first;
            temp.next = second;
            temp = first;
        }
        return pre.next;
    }
}
