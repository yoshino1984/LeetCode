package com.yoshino.p121top140;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 克隆图
 **/
public class P133CloneGraph {
    Map<Integer, Node> nodeMap;
    public Node cloneGraph(Node node) {
        nodeMap = new HashMap<>();
        return cloneGraphDfs(node);
    }

    private Node cloneGraphDfs(Node oldNode) {
        if (oldNode == null) {
            return oldNode;
        }

        if (!nodeMap.containsKey(oldNode.val)) {
            Node node = new Node(oldNode.val);
            nodeMap.put(oldNode.val, node);
            ArrayList<Node> neighbors = new ArrayList<>();
            for (Node neighbor : oldNode.neighbors) {
                neighbors.add(cloneGraphDfs(neighbor));
            }
            node.neighbors = neighbors;
        }

        return nodeMap.get(oldNode.val);
    }

}


class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
