package com.yoshino.p301to350;

import java.util.*;

/**
 * 重新安排行程
 **/
public class P332ReconstructItinerary {

    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, PriorityQueue<String>> fromToMap = new HashMap<>();
        for (List<String> ticket : tickets) {
            fromToMap.computeIfAbsent(ticket.get(0), key -> new PriorityQueue<>()).offer(ticket.get(1));
        }

        LinkedList<String> ans = new LinkedList<>();
        ans.addLast("JFK");
        dfs(fromToMap, ans, tickets.size());
        return ans;
    }

    private boolean dfs(Map<String, PriorityQueue<String>> fromToMap, LinkedList<String> ans, int size) {
        if (size == 0) {
            return true;
        }

        if (fromToMap.containsKey(ans.getLast())) {
            Queue<String> toQueue = fromToMap.get(ans.getLast());
            PriorityQueue<String> newQueue = new PriorityQueue<>(toQueue);
            while (!newQueue.isEmpty()) {
                String to = newQueue.poll();
                toQueue.remove(to);
                ans.addLast(to);
                if (dfs(fromToMap, ans, size - 1)) {
                    return true;
                }
                ans.removeLast();
                toQueue.offer(to);
            }
            fromToMap.put(ans.getLast(), newQueue);
        }
        return false;
    }
}
