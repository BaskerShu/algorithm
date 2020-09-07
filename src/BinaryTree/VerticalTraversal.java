package BinaryTree;

import java.util.*;

/**
 * 987. 二叉树的垂序遍历
 */
public class VerticalTraversal {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Location> seen = new ArrayList<>();

        dfs(root, 0, 0, seen);
        Collections.sort(seen);

        ans.add(new ArrayList<>());
        int prev = seen.get(0).x;
        for (var location : seen) {
            if (location.x != prev) {
                ans.add(new ArrayList<>());
                prev = location.x;
            }
            ans.get(ans.size() - 1).add(location.val);
        }
        return ans;
    }

    private void dfs(TreeNode node, int x, int y, List<Location> seen) {
        if (node == null) return;

        seen.add(new Location(x, y, node.getVal()));
        dfs(node.getLeft(), x - 1, y + 1, seen);
        dfs(node.getRight(), x + 1, y + 1, seen);
    }
}

class Location implements Comparable<Location> {
    int x;
    int y;
    int val;

    public Location(int x, int y, int val) {
        this.x = x;
        this.y = y;
        this.val = val;
    }

    @Override
    public int compareTo(Location that) {
        if (this.x != that.x) {
            return Integer.compare(this.x, that.x);
        } else if (this.y != that.y) {
            return Integer.compare(this.y, that.y);
        } else {
            return Integer.compare(this.val, that.val);
        }
    }
}
