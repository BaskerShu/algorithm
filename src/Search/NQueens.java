package Search;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

// 51. N 皇后
public class NQueens {

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ret = new LinkedList<>();
        char[][] curr = new char[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(curr[i], '.');
        }
        int[] cols = new int[n];
        int[] diag1 = new int[n * 2 - 1];
        int[] diag2 = new int[n * 2 - 1];

        dfs(n, 0, cols, diag1, diag2, curr, ret);

        return ret;
    }

    private boolean canPut(int n, int r, int c, int[] cols, int[] diag1, int[] diag2) {
        return cols[c] != 1 && diag1[r + c] != 1 && diag2[r - c + n - 1] != 1;
    }

    private void updateBoard(int n, int r, int c, int flag, int[] cols, int[] diag1, int[] diag2, char[][] curr) {
        cols[c] = flag;
        diag1[r + c] = flag;
        diag2[r - c + n - 1] = flag;
        curr[r][c] = flag == 1 ? 'Q' : '.';
    }

    private void dfs(int n, int r, int[] cols, int[] diag1, int[] diag2,
                     char[][] curr, List<List<String>> ret) {
        if (r == n) {
            List<String> sl = new LinkedList<>();
            for (char[] row : curr) {
                String s = new String(row);
                sl.add(s);
            }
            ret.add(sl);
            return;
        }

        for (int c = 0; c < n; c++) {
            if (!canPut(n, r, c, cols, diag1, diag2)) {
                continue;
            }

            updateBoard(n, r, c, 1, cols, diag1, diag2, curr);
            dfs(n, r, cols, diag1, diag2, curr, ret);
            updateBoard(n, r, c, 0, cols, diag1, diag2, curr);
        }
    }
}
