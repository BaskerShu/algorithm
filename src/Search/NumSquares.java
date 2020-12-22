package Search;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 279. 完全平方数
 */
public class NumSquares {
    public int numSquares(int n) {
        if (n <= 1) return n;

        Queue<int[]> queue = new LinkedList<>();
        HashSet<Integer> cache = new HashSet<>();
        queue.add(new int[]{n, 0});
        while (!queue.isEmpty()) {
            int[] q = queue.poll();
            int q0 = q[0];
            int q1 = q[1];
            int maxSquare = (int) Math.sqrt(q0);

            for (int i = 1; i <= maxSquare; i++) {
                if (q0 - i * i == 0) {
                    return q1 + 1;
                }

                if (cache.contains(q0 - i * i)) {
                    continue;
                }
                cache.add(q0 - i * i);
                queue.add(new int[]{q0 - i * i, q1 + 1});
            }
        }
        return n;
    }

    public static void main(String[] args) {
        var obj = new NumSquares();
        int ans = obj.numSquares(12);

        System.out.println(ans);
    }
}
