package Search;

/**
 * 79. 单词搜索
 */
public class WordSearch {

    public boolean exist(char[][] board, String word) {
        int nr = board.length;
        int nc = board[0].length;

        boolean signal = false;
        for (int r = 0; r < nr; r++) {
            for (int c = 0; c < nc; c++) {
                if (board[r][c] != word.charAt(0)) {
                    continue;
                }
                signal = dfs(board, nr, nc, word, 0, 0, 0);
                if (signal) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, int nr, int nc, String word, int r, int c, int l) {
        int[][] directions = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
        if (l == word.length()) {
            return true;
        }

        for (int[] direction : directions) {
            int newR = r + direction[0];
            int newC = c + direction[1];

            boolean signal = false;
            if (newR >=0 && newC >= 0 && newR < nr && newC < nc && board[newR][newC] == word.charAt(l+1)) {
                signal = dfs(board, nr, nc, word, newR, newC, l+1);
            }

            if (signal) {
                return true;
            }
        }

        return false;
    }
}
