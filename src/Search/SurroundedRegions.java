package Search;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 130. 被围绕的区域
 */
public class SurroundedRegions {
    // BFS
    public void solve(char[][] board) {
        int nr = board.length;
        int nc = board[0].length;

        int[] rs = {0, nr - 1};
        int[] cs = {0, nc - 1};

        // 修改第一行和最后一行的数据
        for (int r : rs) {
            for (int c = 0; c < nc; c++) {
                if (board[r][c] != 'O') {
                    continue;
                }
                bfs(board, nr, nc, r, c);
//                dfs(board, nr, nc, r, c);
            }
        }

        // 修改第一列和最后一列的数据
        for (int c : cs) {
            for (int r = 0; r < nr; r++) {
                if (board[r][c] != 'O') {
                     continue;
                }
                bfs(board, nr, nc, r, c);
                // dfs(board, nr, nc, r, c);
            }
        }

        // 将所有的 # 都替换为 0，所有的0都替换成 X
        for (int r = 0; r < nr; r++) {
            for (int c = 0; c < nc; c++) {
                if (board[r][c] == '#') {
                    board[r][c] = 'O';
                } else if (board[r][c] == 'O') {
                    board[r][c] = 'X';
                }
            }
        }
    }

    private void bfs(char[][] board, int nr, int nc, int r, int c) {
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{r, c});
        board[r][c] = '#';
        while (!queue.isEmpty()) {
            int[] node = queue.poll();
            for (int[] direction : directions) {
                int newR = node[0] + direction[0];
                int newC = node[1] + direction[1];
                if (newR >= 0 && newR < nr && newC >=0 && newC < nc && board[newR][newC] == 'O') {
                    board[newR][newC] = '#';
                    queue.add(new int[]{newR, newC});
                }
            }
        }
    }

    private void dfs(char[][] board, int nr, int nc, int r, int c) {
        if (r < 0 || r >= nr || c < 0 || c >= nc || board[r][c] != 'O') {
            return;
        }

        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        board[r][c] = '#';
        for (int[] direction : directions) {
            dfs(board, nr, nc, r + direction[0], c + direction[1]);
        }
    }

    // 并查积
    public void solve2(char[][] board) {
        int nr = board.length;
        if (nr == 0) return;
        int nc = board[0].length;
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        UF uf = new UF(nr*nc+1);
        int dummy = nr * nc;

        for (int i = 0; i < nr; i++) {
            for (int j = 0; j < nc; j++) {
                if (board[i][j] != 'O') {
                    continue;
                }

                if (i == 0 || j == 0 || i == nr - 1 || j == nc - 1) {
                    uf.union(i * nc + j, dummy);
                } else {
                    for (int[] direction : directions) {
                        int newR = i + direction[0];
                        int newC = j + direction[1];
                        if (newR > 0 && newR < nr - 1 && newC > 0 && newC < nc - 1 && board[newR][newC] == 'O') {
                            uf.union(i * nc + j, newR * nc + newC);
                        }
                    }
                }
            }
        }

        for (int i = 0; i < nr; i++) {
            for (int j = 0; j < nc; j++) {
                if (uf.isConnected(i * nc + j, dummy)) {
                    // 和dummyNode 在一个连通区域的,那么就是O；
                    board[i][j] = 'O';
                } else {
                    board[i][j] = 'X';
                }
            }
        }
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
            size[i] = 1;
            parent[i] = i;
        }
    }

    public void union(int q, int p) {
        int rootP = find(p);
        int rootQ = find(q);
        if (rootP != rootQ) {
            return;
        }

        if (size[rootQ] > size[rootP]) {
            parent[rootP] = rootQ;
            size[rootQ] += size[rootP];
        } else {
            parent[rootQ] = rootP;
            size[rootP] += size[rootP];
        }
        count--;
    }

    public int find(int p) {
        if (parent[p] != p) {
            parent[p] = parent[parent[p]];
            return find(parent[p]);
        }
        return p;
    }

    boolean isConnected(int node1, int node2) {
        return find(node1) == find(node2);
    }

    public int getCount() {
        return count;
    }
}
