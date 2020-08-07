package Search;

import java.util.ArrayList;
import java.util.List;

/**
 * 78. 子集
 */
public class Subsets {
    // DFS
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        ans.add(new ArrayList<>(curr));
        dfs(ans, curr, nums, 0);
        return ans;
    }

    private void dfs(List<List<Integer>> ans, List<Integer> curr, int[] nums, int l) {
        if (curr.size() == nums.length || l >= nums.length) {
            return;
        }

        for (int i = l; i < nums.length; i++) {
            curr.add(nums[i]);
            ans.add(new ArrayList<>(curr));
            dfs(ans, curr, nums, i+1);
            curr.remove(curr.size() - 1);
        }
    }

    // 递归
    public List<List<Integer>> subsets1(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(new ArrayList<>());

        for (int num : nums) {
            List<List<Integer>> newSubSets = new ArrayList<>();
            for (var cur : ans) {
                newSubSets.add(new ArrayList<>(cur){{add(num);}});
            }
            ans.addAll(newSubSets);
        }

        return ans;
    }

    // DFS2
    public List<List<Integer>> subsets2(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums == null) return ans;

        List<Integer> cur = new ArrayList<>();
        for (int i = 0; i <= nums.length; i++) {
            dfs2(nums, i, 0, cur, ans);
        }
        return ans;
    }

    private void dfs2(int[] nums, int len, int start, List<Integer> cur, List<List<Integer>> ans) {
        if (cur.size() == len) {
            ans.add(new ArrayList<>(cur));
            return;
        }

        for (int i = start ; i < nums.length; i++) {
            cur.add(nums[i]);
            dfs2(nums, len, i+1, cur, ans);
            cur.remove(cur.size() - 1);
        }
    }

    // 二进制排序
    public List<List<Integer>> subsets3(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums == null) return ans;

        int numsLen = nums.length;
        for (int i = 0; i < 1 << numsLen; i++) {
            List<Integer> cur = new ArrayList<>();

            for (int j = 0; j < numsLen; j++) {
                if ((i & 1 << j) != 0) {
                    cur.add(nums[j]);
                }
            }
            ans.add(new ArrayList<>(cur));
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        var obj = new Subsets();
        var ans = obj.subsets1(nums);
        System.out.println(ans.toString());
    }
}
