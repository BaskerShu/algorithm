package Search;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * 47. 全排列 II
 */
public class PermuteUnique {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        List<Integer> curr = new LinkedList<>();
        int[] hasVisited = new int[nums.length];

        dfs(nums, hasVisited, curr, ret);

        return ret;
    }

    private void dfs(int[] nums, int[] hasVisited, List<Integer> curr, List<List<Integer>> ret) {
        if (curr.size() == nums.length) {
            ret.add(new LinkedList<>(curr));
            return;
        }

        HashSet<Integer> recurNums = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (hasVisited[i] == 1 || recurNums.contains(nums[i])) {
                continue;
            }

            // 递归
            recurNums.add(nums[i]);
            hasVisited[i] = 1;
            curr.add(nums[i]);
            dfs(nums, hasVisited, curr, ret);
            curr.remove(nums.length - 1);
            hasVisited[i] = 0;
        }
    }
}
