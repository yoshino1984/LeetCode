package com.yoshino.leetcode.P801to900;

import java.util.List;

/**
 * 钥匙和房间
 **/
public class P841KeysAndRooms {

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] visited = new boolean[rooms.size()];
        dfs(visited, 0, rooms);

        for (int i = 0; i < visited.length; i++) {
            if (!visited[i]) {
                return false;
            }
        }
        return true;
    }

    private void dfs(boolean[] visited, int index, List<List<Integer>> rooms) {
        if (visited[index]) {
            return;
        }

        visited[index] = true;
        for (Integer next : rooms.get(index)) {
            dfs(visited, next, rooms);
        }
    }
}
