package Search;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 39. 组合总和
public class CombinationSum {

    // DFS(可以使用重复数据)
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        ArrayDeque<Integer> curr = new ArrayDeque<>();

        Arrays.sort(candidates);
        combinationSum(candidates, target, 0, curr, ans);
        return ans;
    }

    public void combinationSum(int[] candidates, int target, int begin,
                               ArrayDeque<Integer> curr, List<List<Integer>> ans) {
        if (target == 0) {
            ans.add(new ArrayList<>(curr));
            return;
        }

        for (int i = begin; i < candidates.length; i++) {
            if (target - candidates[i] < 0) {
                break;
            }

            curr.addLast(candidates[i]);
            combinationSum(candidates, target - candidates[i], i, curr, ans);
            curr.removeLast();
        }
    }

    // DFS(不可以使用重复数据)
    public void combinationSum2(int[] candidates, int target, int begin,
                                ArrayDeque<Integer> curr, List<List<Integer>> ans) {
        if (target == 0) {
            ans.add(new ArrayList<>(curr));
            return;
        }

        for (int i = begin; i < candidates.length; i++) {
            if (target - candidates[i] < 0) {
                break;
            }

            curr.addLast(candidates[i]);
            combinationSum2(candidates, target - candidates[i], i + 1, curr, ans);
            curr.removeLast();
        }
    }
}
