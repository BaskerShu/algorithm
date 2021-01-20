package DP;

/**
 * 64. 最小路径和
 */
public class MinPathSum {
    public int minPathSum(int[][] grid) {
        return recur(grid.length - 1, grid[0].length - 1, grid);
    }

    private int recur(int row, int column, int[][] grid) {
        if (row < 0 || column < 0) {
            return 0;
        }

        int min = 0;
        int val1 = recur(row - 1, column, grid);
        int val2 = recur(row, column - 1, grid);
        if (row > 0 && column > 0) {
            min = Math.min(val1 + grid[row][column], val2 + grid[row][column]);
        } else if (row == 0) {
            min = val2 + grid[row][column];
        } else {
            min = val1 + grid[row][column];
        }

        return min;
    }

    public int minPathSum2(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];

        int rNum = grid.length - 1;
        int cNum = grid[0].length - 1;

        for (int r = rNum; r >= 0; r--) {
            for (int c = cNum; c >= 0; c--) {
                if (r == rNum && c != cNum) {
                    dp[r][c] = grid[r][c+1];
                } else if (r != rNum && c == cNum) {
                    dp[r][c] = grid[r+1][c];
                } else if (r != rNum && c != cNum) {
                    dp[r][c] = Math.min(dp[r+1][c], dp[r][c+1]);
                }

                dp[r][c] = dp[r][c] + grid[r][c];
            }
        }
        return dp[0][0];
    }
}
