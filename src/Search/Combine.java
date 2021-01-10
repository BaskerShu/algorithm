package Search;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 77. 组合
 */
public class Combine {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        ArrayDeque<Integer> curr = new ArrayDeque<>();
        int start = 1;
        combine(n, k, start, curr, ans);
        return ans;
    }

    private void combine(int n, int k, int start, ArrayDeque<Integer> curr, List<List<Integer>> ans) {

        if (curr.size() == k) {
            ans.add(new ArrayList<>(curr));
            return;
        }

        if (curr.size() + n - start + 1 < k) {
            return;
        }

        for (int i = start; i <= n; i++) {
            curr.addLast(i);
            combine(n, k, i+1, curr, ans);
            curr.removeLast();
        }
    }

    public List<List<Integer>> combine2(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            curr.add(0);
        }
        int i = 0;
        while (i >= 0) {
            System.out.print(curr);
            curr.set(i, curr.get(i) + 1);
            if (curr.get(i) > n){
                i--;
            } else if (i == k - 1) {
                ans.add(new ArrayList<>(curr));
            } else {
                i++;
                curr.set(i, curr.get(i - 1));
            }
        }
        System.out.println();
        return ans;
    }

    public static void main(String[] args) {
        var c = new Combine();
        var ans = c.combine2(4, 2);
        System.out.println(ans);
    }
}
