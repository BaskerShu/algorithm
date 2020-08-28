package DivideAndConquer;

import java.util.ArrayList;
import java.util.List;

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
            curr.add(i);
            combinationSum3(k, n - i, i+1, curr, ans);
            curr.remove(curr.size() - 1);
        }
    }

    public static void main(String[] args) {
        var obj = new CombinationSum3();
        var ans = obj.combinationSum3(3, 7);

        System.out.println(ans);
    }
}
