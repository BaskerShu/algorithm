package Graph;

/**
 * 695. 岛屿的最大面积
 */
public class MaxAreaOfIsland {

    public int maxAreaOfIsland(int[][] grid) {
        if (grid.length == 0) return 0;

        int nr = grid.length;
        int nc = grid[0].length;
        int maxArea = 0;

        for (int i = 0; i < nr; i++) {
            for (int j = 0; j < nc; j++) {
                if (grid[i][j] == 0) {
                    continue;
                }

                int area = areaOfIsland(grid, nr, nc, i, j);
                maxArea = Math.max(area, maxArea);
            }
        }
        return maxArea;
    }

    private int areaOfIsland(int[][] grid, int nr, int nc, int r, int c) {
        if (r < 0 || c < 0 || r >= nr || c >= nc || grid[r][c] == 0) {
            return 0;
        }

        grid[r][c] = 0;
        int area1 = areaOfIsland(grid, nr, nc, r-1, c);
        int area2 = areaOfIsland(grid, nr, nc, r+1, c);
        int area3 = areaOfIsland(grid, nr, nc, r, c-1);
        int area4 = areaOfIsland(grid, nr, nc, r, c+1);

        return area1 + area2 + area3 + area4 + 1;
    }
}
