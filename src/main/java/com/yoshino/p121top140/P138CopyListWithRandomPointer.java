package com.yoshino.p121top140;

import com.yoshino.model.Node;

import java.util.HashMap;
import java.util.Map;

public class P138CopyListWithRandomPointer {

    /**
     * 使用hashMap的方式存储信息，进行两次遍历
     * 时间复杂度O(N)
     * 空间复杂度O(N)
     * @param head
     * @return
     */
    public Node copyRandomList(Node head) {
        Node curOld = head;
        Map<Node, Node> copyMap = new HashMap<>();
        Node newHead = new Node(-1);
        Node curNew = newHead;
        while (curOld != null) {
            curNew.next = new Node(curOld.val);
            curNew = curNew.next;
            copyMap.put(curOld, curNew);
            curOld = curOld.next;
        }

        while (head != null) {
            Node newNode = copyMap.get(head);
            newNode.random = copyMap.get(head.random);
            head = head.next;
        }

        return newHead.next;
    }

}
