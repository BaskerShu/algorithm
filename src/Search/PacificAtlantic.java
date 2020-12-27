package Search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 417. 太平洋大西洋水流问题
 */
public class PacificAtlantic {

    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        List<List<Integer>> ret = new ArrayList<>();
        if (matrix == null || matrix.length == 0) {
            return ret;
        }

        int nr = matrix.length;
        int nc = matrix[0].length;
        int[][] canReachA = new int[nc][nr];
        int[][] canReachP = new int[nc][nr];
        for (int i = 0 ; i < nr; i++) {
            dfs(nr, nc, matrix, i, 0, canReachA);
            dfs(nr, nc, matrix, i, nc - 1, canReachP);
        }
        for (int i = 0; i < nc; i++) {
            dfs(nr, nc, matrix, 0, i, canReachA);
            dfs(nr, nc, matrix, nr - 1, i, canReachP);
        }

        for (int r = 0 ; r < nr; r++) {
            for (int c = 0; c < nc; c++) {
                if (canReachA[r][c] == 1 && canReachP[r][c] == 1) {
                    List<Integer> element = Arrays.asList(r, c);
                    ret.add(element);
                }
            }
        }
        return ret;
    }

    private void dfs(int nr, int nc, int[][] matrix, int r, int c, int[][] canReach) {
        if (r < 0 || c < 0 || r >= nr || c >= nc || canReach[r][c] == 1) {
            return;
        }

        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        canReach[r][c] = 1;
        for (int[] direction : directions) {
            int newR = r + direction[0];
            int newC = c + direction[1];
            if (newR >= 0 && newR < nr && newC >= 0 && newR < nc && matrix[r][c] < matrix[newR][newC]) {
                dfs(nr, nc, matrix, newR, newC, canReach);
            }
        }
    }
}
