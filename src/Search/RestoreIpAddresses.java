package Search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 93. 复原IP地址
 */
public class RestoreIpAddresses {
    public List<String> restoreIpAddresses(String s) {
        List<String> ans = new ArrayList<>();
        int[] curr = new int[4];
        if (s.length() < 4) return ans;

        dfs(s, 0, 0, curr, ans);
        return ans;
    }

    private void dfs(String s, int l, int curr_loc, int[] curr, List<String> ans) {
        if (curr_loc == curr.length) {
            if (l == s.length()) {
                ans.add(Arrays.stream(curr)
                        .mapToObj(String::valueOf)
                        .collect(Collectors.joining(" - ")));
            }
            return;
        }

        for (int i = 1; i <= 3; i++) {
            if (l + i > s.length()) continue;

            int t = Integer.parseInt(s.substring(l, l + i));
            if (t > 255) break;
            curr[curr_loc] = t;
            curr_loc++;
            dfs(s, l + i, curr_loc, curr, ans);
            curr_loc--;

            if (t == 0) {
                break;
            }
        }
    }
}
