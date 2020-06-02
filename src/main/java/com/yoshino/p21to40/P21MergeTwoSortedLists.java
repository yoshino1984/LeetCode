package com.yoshino.p21to40;

import com.yoshino.model.ListNode;

/**
 * 合并两个有序链表
 *
 * @author wangxin
 * 2020/5/30 20:57
 * @since
 **/
public class P21MergeTwoSortedLists {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode prevHead = new ListNode(0);
        ListNode cur = prevHead;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }

        cur.next = l1 != null ? l1 : l2;

        return prevHead.next;
    }

}
