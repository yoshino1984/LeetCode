package com.yoshino.p501to600;

/**
 * 朋友圈
 **/
public class P547FriendCircles {

    public int findCircleNum(int[][] M) {
        UnionFind unionFind = new UnionFind(M.length);
        for (int i = 0; i < M.length; i++) {
            for (int j = 0; j <= i; j++) {
                if (M[i][j] == 1) {
                    unionFind.union(i, j);
                }
            }
        }

        return unionFind.count;
    }

    class UnionFind {
        private int count;
        private int[] parent;

        public UnionFind(int n) {
            count = n;
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        public int find(int q) {
            while (q != parent[q]) {
                parent[q] = parent[parent[q]];
                q = parent[q];
            }
            return q;
        }

        public void union(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);
            if (rootP != rootQ) {
                count--;
                parent[rootP] = rootQ;
            }
        }
    }

    public static void main(String[] args) {
        new P547FriendCircles().findCircleNum(new int[][] {{1,1,0}, {1,1,0}, {0,0,1}});
    }
}
