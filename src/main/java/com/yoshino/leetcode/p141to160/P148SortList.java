package com.yoshino.leetcode.p141to160;

import com.yoshino.leetcode.model.ListNode;

/**
 * 排序链表
 * 递归调用方式：时间复杂度 O(NlogN) 空间复杂度O(logN)(计算递归调用栈的话)
 * 直接自底向上合并方式：时间复杂度O(NlogN) 空间复杂度O(1)
 *
 * @author wangxin
 * 2020/5/5 07:27
 * @since
 **/
public class P148SortList {

    /**
     * 递归调用方式
     * @param head
     * @return
     */
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode mid = findMiddleNode(head);
        ListNode temp = mid.next;
        mid.next = null;
        ListNode left = sortList(head);
        ListNode right = sortList(temp);
        return merge(left, right);
    }

    private ListNode findMiddleNode(ListNode head) {
        ListNode fast = head.next, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    private ListNode merge(ListNode left, ListNode right) {
        ListNode ret = new ListNode(0);
        ListNode cur = ret;
        while (left != null && right != null) {
            if (left.val <= right.val) {
                cur.next = left;
                left = left.next;
            } else {
                cur.next = right;
                right = right.next;
            }
            cur = cur.next;
        }
        cur.next = left != null ? left : right;
        return ret.next;
    }

    /**
     * 合并的方式 因为没有使用栈帧，时间复杂度O(NlogN)空间复杂度降低为O(1)
     * （但是编码很复杂，容易出错）
     * @param head
     * @return
     */
    public ListNode sortList2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode ret = new ListNode(0);
        ret.next = head;
        int len = 0;
        while (head != null) {
            len++;
            head = head.next;
        }

        int i = 0;
        while (true) {
            long interval = (long) Math.pow(2, i);
            if (interval >= len) {
                break;
            }
            sortList3(ret, interval);
            i++;
        }

        return ret.next;
    }

    private void sortList3(ListNode ret, long interval) {
        ListNode firstHead = null;
        ListNode firstTail = null;
        ListNode secondHead = null;
        ListNode secondTail = null;

        ListNode curNode = new ListNode();
        curNode.next = ret.next;
        ListNode lastTail = ret;

        while (curNode.next != null) {
            firstHead = curNode.next;
            for (int i = 0; i < interval - 1; i++) {
                if (curNode.next == null) {
                    break;
                } else {
                    curNode.next = curNode.next.next;
                }
            }
            firstTail = curNode.next;
            if (curNode.next == null || curNode.next.next == null) {
                break;
            } else {
                curNode.next = curNode.next.next;
                firstTail.next = null;
            }

            secondHead = curNode.next;
            for (int i = 0; i < interval - 1; i++) {
                if (curNode.next == null) {
                    break;
                } else {
                    curNode.next = curNode.next.next;
                }
            }

            if (curNode.next == null || curNode.next.next == null) {
                ListNode head = merge(firstHead, secondHead);
                lastTail.next = head;
                break;
            } else {
                secondTail = curNode.next;
                curNode.next = curNode.next.next;
                secondTail.next = null;
                ListNode head = merge(firstHead, secondHead);
                lastTail.next = head;
                lastTail = firstTail.val <= secondTail.val ? secondTail : firstTail;
                lastTail.next = curNode.next;
            }
        }
    }

    public static void main(String[] args) {
        ListNode node4 = new ListNode(4);
        ListNode node2 = new ListNode(2);
        node4.next = node2;
        ListNode node1 = new ListNode(1);
        node2.next = node1;
        ListNode node3 = new ListNode(3);
        node1.next = node3;

        new P148SortList().sortList2(node4);
    }

}
