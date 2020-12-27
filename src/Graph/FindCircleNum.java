package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 547. 朋友圈
 */
public class FindCircleNum {

    // DFS
    public int findCircleNum(int[][] M) {
        if (M == null || M.length == 0) return 0;

        int nr = M.length;
        int[] visited = new int[nr];
        int circleNum = 0;
        for (int i = 0; i < nr; i++) {
            if (visited[i] == 1) {
                continue;
            }
            circleNum++;
            dfs(M, visited, nr, i);
        }

        return circleNum;
    }

    private void dfs(int[][] M, int[] visited, int nr, int c) {

        for (int i = 0; i < nr; i++) {
            if (M[c][i] == 0 || visited[i] == 1) {
                continue;
            }
            visited[i] = 1;
            dfs(M, visited, nr, i);
        }
    }

    // BFS
    public int findCircleNum1(int[][] M) {
        if (M == null || M.length == 0) return 0;

        int nr = M.length;
        int circleNum = 0;
        int[] visited = new int[nr];
        for (int i = 0; i < nr; i++) {
            if (visited[i] == 1) {
                continue;
            }

            circleNum++;
            ArrayList<Integer> queue = new ArrayList<>();
            queue.add(i);
            while (!queue.isEmpty()) {
                int n = queue.remove(0);
                for (int j = 0; j < nr; j++) {
                    if (M[n][j] == 0 || visited[j] == 1) {
                        continue;
                    }
                    visited[j] = 1;
                    queue.add(j);
                }
            }
        }

        return circleNum;
    }

    // 并查集
    public int findCircleNum2(int[][] M) {
        if (M == null || M.length == 0) return 0;

        int nr = M.length;
        var uf = new UF(nr);
        for (int i = 0; i < nr; i++) {
            for (int j = 0; j <= i; j++) {
                if (M[i][j] == 1) {
                    uf.union(i, j);
                }
            }
        }

        return uf.count;
    }

    // DFS
    public int findCircleNum3(int[][] M) {
        int nr = M.length;

        int num = 0;
        int[] people = new int[nr];
        for (int i = 0; i < nr; i++) {
            if (people[i] == 1) {
                continue;
            }

            Queue<Integer> queue = new LinkedList<>();
            queue.add(i);
            people[i] = 1;
            num++;
            while (!queue.isEmpty()) {
                int p = queue.poll();
                for (int j = 0 ; j < nr; j++) {
                    if (M[p][j] == 1 && people[j] == 0) {
                        people[j] = 1;
                        queue.add(j);
                    }
                }
            }
        }
        return num;
    }
}

class UF {
    int count;
    int[] parent;
    int[] size;

    public UF(int n) {
        count = n;
        parent = new int[n];
        size = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    public void union(int q, int p) {
        int rootP = find(p);
        int rootQ = find(q);
        if (rootP == rootQ)
            return;

        if (size[rootP] > size[rootQ]) {
            parent[rootQ] = rootP;
            size[rootP] += size[rootQ];
        } else {
            parent[rootP] = rootQ;
            size[rootQ] += size[rootP];
        }
        count--;
    }

    public int find(int p) {
        while (parent[p] != p) {
            p = parent[p];
        }
        return p;
    }

    public int getCount() {
        return count;
    }
}
