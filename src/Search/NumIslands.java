package Search;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
200. 岛屿数量
 */

public class NumIslands {

    // DFS
    public int numIslands(char[][] grid) {
        int islands = 0;
        int nr = grid.length;
        if (nr == 0) return islands;
        int nc = grid[0].length;

        for (int r = 0; r < nr; r ++) {
            for (int c = 0; c < nc; c++) {
                if (grid[r][c] == '1') {
                    islands++;
                    dfs(grid, r, c, nr, nc);
                }
            }
        }

        return islands;
    }

    private void dfs(char[][] grid, int r, int c, int nr, int nc) {
        if (r < 0 || c < 0 || r >= nr || c >= nc || grid[r][c] == '0') return;

        grid[r][c] = '0';
        dfs(grid, r-1, c, nr, nc);
        dfs(grid, r, c-1, nr, nc);
        dfs(grid, r, c+1, nr, nc);
        dfs(grid, r+1, c, nr, nc);
    }

    // BFS
    public int numIslands2(char[][] grid) {
        int islands = 0;
        int nr = grid.length;
        if (nr == 0) return islands;
        int nc = grid[0].length;

        for (int r = 0; r < nr; r++){
            for (int c = 0 ; c < nc; c++) {
                if (grid[r][c] == '0') {
                    continue;
                }
                islands++;
                List<Integer> queue = new ArrayList<>();
                queue.add(r * (nc+1) + c);
                while (!queue.isEmpty()) {
                    int id = queue.remove(queue.size() - 1);
                    int row = id / (nc+1);
                    int col = id % (nc+1);

                    if (row < 0 || col < 0 || row >= nr || col >= nc || grid[row][col] == '0') {
                        continue;
                    }
                    grid[row][col] = '0';
                    queue.add((row + 1) * (nc + 1) + col);
                    queue.add((row - 1) * (nc + 1) + col);
                    queue.add(row * (nc + 1) + (col - 1));
                    queue.add(row * (nc + 1) + (col + 1));
                }
            }
        }
        return islands;
    }

    public int numIsland3(char[][] grid) {
        int rLen = grid.length;
        int cLen = grid[0].length;
        int num = 0;
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        for (int r = 0; r < rLen; r++) {
            for (int c = 0; c < cLen; c++) {
                if (grid[r][c] == '0') {
                    continue;
                }

                Queue<int[]> queue = new LinkedList<>();
                queue.add(new int[]{r, c});
                grid[r][c] = 0;
                num += 1;
                while (!queue.isEmpty()) {
                    int[] node = queue.poll();
                    int nodeR = node[0];
                    int nodeC = node[1];

                    for (int[] direction : directions) {
                        int newR = nodeR + direction[0];
                        int newC = nodeC + direction[1];
                        if (newR >= 0 && newR < rLen && newC >= 0 && newC < cLen && grid[newR][newC] == '1') {
                            queue.add(new int[]{newR, newC});
                            grid[newR][newC] = '0';
                        }
                    }
                }

            }
        }
        return num;
     }

    public static void main(String[] args) {
        char[][] land = {
                {'1','1','1','1','0'},
                {'1','1','0','1','0'},
                {'1','1','0','0','0'},
                {'0','0','0','0','0'}
        };

        NumIslands obj = new NumIslands();
        int ans = obj.numIsland3(land);
        System.out.println(ans);
    }
}
