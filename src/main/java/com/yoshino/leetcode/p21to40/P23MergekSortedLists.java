package com.yoshino.leetcode.p21to40;

import com.yoshino.leetcode.model.ListNode;

import java.util.*;
import java.util.stream.Collectors;

public class P23MergekSortedLists {

    /**
     * 暴力破解
     */
    public ListNode mergeKLists1(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        List<ListNode> listNodes = new ArrayList<>();
        for (int i = 0; i < lists.length; i++) {
            ListNode listNode = lists[i];
            while (listNode != null) {
                listNodes.add(listNode);
                listNode = listNode.next;
            }
        }
        if (listNodes.size() == 0) {
            return null;
        }
        listNodes = listNodes.stream()
            .sorted(Comparator.comparingInt(s -> s.val))
            .collect(Collectors.toList());
        for (int i = 0; i < listNodes.size() - 1; i++) {
            listNodes.get(i).next = listNodes.get(i + 1);
        }
        return listNodes.get(0);
    }

    /** 使用优先队列*/
    public ListNode mergeKLists2(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        ListNode resultNode = new ListNode(0);
        ListNode curr = resultNode;
        PriorityQueue<ListNode> pq = new PriorityQueue<>(Comparator.comparingInt(s -> s.val));

        for (ListNode list : lists) {
            if (list == null) {
                continue;
            }
            pq.add(list);
        }

        while (!pq.isEmpty()) {
            ListNode next = pq.poll();
            curr.next = next;
            curr = next;
            if (next.next != null) {
                pq.add(next.next);
            }
        }

        return resultNode.next;
    }


    /** 使用优先队列 by xiaoyi*/
    public static ListNode myMergeKLists3(ListNode[] lists) {
        ListNode result = null;
        if (lists.length == 0) {
            return null;
        }
        if (lists.length == 1) {
            return lists[0];
        }
        // 使用优先级队列，k个队列顶端值的对比复杂度从O(k)降低为O(log(k))
        PriorityQueue<ListNode> pq = new PriorityQueue<>(Comparator.comparingInt(s -> s.val));

        for (ListNode node : lists) {
            if (node != null) {
                pq.add(node);
            }
        }

        ListNode iter = null;
        while (!pq.isEmpty()) {
            ListNode curNode = pq.poll();
            if (iter == null) {
                iter = curNode;
                result = iter;
            } else {
                iter.next = curNode;
                iter = iter.next;
            }
            while (curNode.next != null && (pq.isEmpty() || curNode.next.val < pq.peek().val)) {
                curNode = curNode.next;
                iter.next = curNode;
                iter = iter.next;
            }
            if (curNode.next != null) {
                pq.add(curNode.next);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        ListNode node1 = ListNode.builder()
            .val(1)
            .next(ListNode.builder().val(4)
                .next(ListNode.builder().val(5)
                    .next(null).build()).build()).build();
        ListNode node2 = ListNode.builder()
            .val(1)
            .next(ListNode.builder().val(3)
                .next(ListNode.builder().val(4)
                    .next(null).build()).build()).build();
        ListNode node3 = ListNode.builder()
            .val(2)
            .next(ListNode.builder().val(6)
                .next(ListNode.builder().val(7)
                    .next(null).build()).build()).build();
        ListNode.print(myMergeKLists4(Arrays.asList(node1, node2, node3).toArray(new ListNode[0])));
    }


    /** 使用分治思想 by xiaoyi*/
    public static ListNode myMergeKLists4(ListNode[] lists) {
        int len = lists.length;
        if (len == 0) {
            return null;
        }

        while (len > 1) {
            for (int i = 0; i < len / 2; i++) {
                lists[i] = mergeTwoList(lists[i], lists[len - i - 1]);
            }
            len = (len + 1) / 2;
        }
        return lists[0];
    }

    private static ListNode mergeTwoList(ListNode node1, ListNode node2) {
        ListNode res = new ListNode(-1);
        ListNode iter = res;
        while (node1 != null && node2 != null) {
            if (node1.val < node2.val) {
                iter.next = node1;
                iter = iter.next;
                node1 = node1.next;
            } else {
                iter.next = node2;
                iter = iter.next;
                node2 = node2.next;
            }
        }

        iter.next = node1 == null ? node2 : node1;

        return res.next;
    }
}
