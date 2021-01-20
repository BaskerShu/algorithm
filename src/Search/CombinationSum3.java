package Search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 216. 组合总和 III
 */
public class CombinationSum3 {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();

        combinationSum3(k, n, 1, curr, ans);
        return ans;
    }

    private void combinationSum3(int k, int n, int left, List<Integer> curr, List<List<Integer>> ans) {
        if (curr.size() == k) {
            if (n == 0) {
                ans.add(new ArrayList<>(curr));
            }
            return;
        }

        for (int i = left; i <= 9; i++) {
            if (n - i < 0) break;

            curr.add(i);
            combinationSum3(k, n - i, i+1, curr, ans);
            curr.remove(curr.size() - 1);
        }
    }

    public List<List<Integer>> combinationSum32(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        int[] curr = new int[k];

        dfs(k, curr, 1, 0, n, ans);

        return ans;
    }

    private void dfs(int k, int[] curr, int l, int index, int target, List<List<Integer>> ret) {
        if (k == index || target <= 0) {
            if (target == 0 && k == index) {
                System.out.println(Arrays.toString(curr));
                ret.add(Arrays.stream(curr).boxed().collect(Collectors.toList()));
            }
            return;
        }

        for (int i = l; i <= 9; i++) {
            curr[index] = i;
            dfs(k, curr, i+1, index + 1, target - i, ret);
        }
    }

    public static void main(String[] args) {
        var obj = new CombinationSum3();
        var ans = obj.combinationSum32(3, 7);

        System.out.println(ans);
    }
}
