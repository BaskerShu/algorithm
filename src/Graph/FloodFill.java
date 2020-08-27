package Graph;

import java.util.ArrayList;
import java.util.List;

/**
 * 733. 图像渲染
 */
public class FloodFill {

    // dfs
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image == null || image.length == 0) return null;

        int r = image.length;
        int c = image[0].length;
        int oldColor = image[sr][sc];
        floodFill(image, r, c, newColor, oldColor, sr, sc);

        return image;
    }

    private void floodFill(int[][] image, int r, int c, int newColor, int oldColor, int sr, int sc) {
        if(sr < 0 || sc < 0 || sr >= r || sc >= c || image[sr][sc] != oldColor) return;

        image[sr][sc] = newColor;

        floodFill(image, r, c, newColor, oldColor, sr - 1, sc);
        floodFill(image, r, c, newColor, oldColor, sr + 1, sc);
        floodFill(image, r, c, newColor, oldColor, sr, sc - 1);
        floodFill(image, r, c, newColor, oldColor, sr, sc + 1);
    }


    // bfs
    public int[][] floodFill2(int[][] image, int sr, int sc, int newColor) {
        if (image == null || image.length == 0) return null;
        if (image[sr][sc] == newColor) return image;

        int nr = image.length;
        List<Integer> queue = new ArrayList<>();
        int nc = image[0].length;
        queue.add(sr * nr + sc);
        while (!queue.isEmpty()) {
            Integer id = queue.remove(queue.size() - 1);
            int r = id / nr;
            int c = id % nr;

            if (r < 0 || c < 0 || r >= nr || c >= nc || image[r][c] != image[sr][sc]) continue;
            image[r][c] = newColor;
            queue.add((r - 1) * nr + c);
            queue.add((r + 1) * nr + c);
            queue.add(r * nr + c + 1);
            queue.add(r * nr + c - 1);
        }
        return image;
    }
}
