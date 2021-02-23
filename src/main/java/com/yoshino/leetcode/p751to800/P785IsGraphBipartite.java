package com.yoshino.leetcode.p751to800;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 判断二分图
 **/
public class P785IsGraphBipartite {

    public boolean isBipartite(int[][] graph) {
        int uncolored = 0;
        int red = 1;
        int green = 2;
        int[] color = new int[graph.length];

        for (int i = 0; i < graph.length; i++) {
            if (color[i] == uncolored) {
                Queue<Integer> queue = new LinkedList<>();
                queue.offer(i);
                color[i] = red;
                while (!queue.isEmpty()) {
                    int node = queue.poll();
                    int nextC = color[node] == red ? green : red;
                    for (int neighbor : graph[node]) {
                        if (color[neighbor] == uncolored) {
                            queue.offer(neighbor);
                            color[neighbor] = nextC;
                        } else if (color[neighbor] != nextC) {
                            return false;
                        }
                    }
                }
            }
        }

        return true;
    }


}
