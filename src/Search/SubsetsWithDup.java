package Search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * 90. 子集 II
 */
public class SubsetsWithDup {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums == null || nums.length == 0) return ans;

        Arrays.sort(nums);
        List<Integer> curr = new ArrayList<>();
        for (int i = 0; i <= nums.length; i++) {
            dfs(nums, i, 0, curr, ans);
        }

        return ans;
    }

    private void dfs(int[] nums, int len, int start, List<Integer> curr, List<List<Integer>> ans) {
        if (curr.size() == len) {
            ans.add(new ArrayList<>(curr));
            return;
        }

        for (int i = start; i < nums.length; i++) {
            if (i>start && nums[i-1] == nums[i]) continue;
            curr.add(nums[i]);
            dfs(nums, len, i+1, curr, ans);
            curr.remove(curr.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 2};
        var obj = new SubsetsWithDup();
        var ans = obj.subsetsWithDup(nums);
        System.out.println(ans.toString());
    }
}
