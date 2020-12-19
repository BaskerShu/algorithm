package Search;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 1091. 二进制矩阵中的最短路径
 */
public class ShortestPathBinaryMatrix {

    public int shortestPathBinaryMatrix(int[][] grid) {
        dfs(grid, 0, 0, 0);
        return ans;
    }

    // 深度优先，超出了时间限制
    int ans = -1;
    public void dfs(int[][] grid, int r, int c, int step) {
        if (r >= grid.length || c >= grid[0].length || grid[r][c] == 1) return;
        if (step >= ans) return;
        if (r == grid.length - 1 && c == grid[0].length - 1) {
            ans = step;
            return;
        }

        grid[r][c] = 1;
        dfs(grid, r - 1, c - 1, step + 1);
        dfs(grid, r - 1, c, step + 1);
        dfs(grid, r - 1, c + 1, step + 1);
        dfs(grid, r, c - 1, step + 1);
        dfs(grid, r, c + 1, step + 1);
        dfs(grid, r + 1, c - 1, step + 1);
        dfs(grid, r + 1, c, step + 1);
        dfs(grid, r + 1, c + 1, step + 1);
        grid[r][c] = 0;
    }

    // dfs
    public int shortestPathBinaryMatrixDFS(int[][] grid) {
        int[][] directions = {{0, 1}, {0, -1}, {1, -1}, {1, 0}, {1, 1}, {-1, -1}, {-1, 0}, {-1, 1}};

        int rLen = grid.length, cLen = grid[0].length;
        int r = 0, c = 0;

        if (grid[0][0] != 0 || grid[rLen - 1][cLen - 1] != 0) return -1;
        grid[0][0] = 1;
        Queue<int[]> queue = new LinkedList<int[]>();
        queue.add(new int[]{r, c});

        while (!queue.isEmpty()) {
            int[] node = queue.poll();
            r = node[0];
            c = node[1];

            if (c == cLen - 1 && r == rLen -1) return grid[r][c];

            for (int[] direction : directions) {
                int newR = r + direction[0];
                int newC = c + direction[1];
                if (newR >= 0 && newR < rLen && newC >= 0 && newC < cLen && grid[newR][newC] == 0) {
                    queue.add(new int[]{newR, newC});
                    grid[newR][newC] = grid[r][c] + 1;
                }
            }
        }
        return -1;
    }
}
