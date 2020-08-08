package TwoPointers;

import java.util.Arrays;

/**
 * 455. 分发饼干
 */
public class FindContentChildren {
    public int findContentChildren(int[] g, int[] s) {
        int gNum = g.length;
        int sNum = s.length;
        if (gNum == 0 || sNum == 0) return 0;

        Arrays.sort(g);
        Arrays.sort(s);
        int i = 0;
        int j = 0;
        while (i < gNum && j < sNum) {
            if (g[i] <= s[j++]) {
                i++;
            }
        }

        return i;
    }
}
