package Search;

import javax.xml.stream.FactoryConfigurationError;
import java.util.*;

/**
 * 46. 全排列
 */
public class Permute {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        List<Integer> curr = new LinkedList<>();

        dfs(nums, curr, ret);

        return ret;
    }

    private void dfs(int[] nums, List<Integer> curr, List<List<Integer>> ret) {
        boolean signal = true;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == Integer.MAX_VALUE) {
                continue;
            }

            signal = false;
            curr.add(nums[i]);
            nums[i] = Integer.MAX_VALUE;
            dfs(nums, curr, ret);
            nums[i] = curr.remove(curr.size() - 1);
        }

        if (signal) {
            ret.add(new LinkedList<>(curr));
        }
    }

    public List<List<Integer>> permuteOfBfs(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        Queue<PermutationPair> pairs = new LinkedList<>();
        pairs.add(new PermutationPair(new LinkedList<>(), new int[nums.length]));

        while (!pairs.isEmpty()) {
            PermutationPair pair = pairs.poll();

            if (pair.curr.size() == nums.length) {
                ret.add(pair.curr);
                continue;
            }

            for (int i = 0; i < nums.length; i++) {
                if (pair.hasVisited[i] == 1) {
                    continue;
                }

                int[] newHasVisited = Arrays.copyOf(pair.hasVisited, nums.length);;
                newHasVisited[i] = 1;
                LinkedList<Integer> newCurr = new LinkedList<>(pair.curr);
                newCurr.add(nums[i]);
                pairs.add(new PermutationPair(newCurr, newHasVisited));
            }
        }

        return ret;
    }
}

class PermutationPair{
    LinkedList<Integer> curr;
    int[] hasVisited;

    public PermutationPair(LinkedList<Integer> c, int[] h) {
        curr = c;
        hasVisited = h;
    }
}
