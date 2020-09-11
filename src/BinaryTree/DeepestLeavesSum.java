package BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 1302. 层数最深叶子节点的和
 */
public class DeepestLeavesSum {
    // 层序遍历
    public int deepestLeavesSum(TreeNode root) {
        if (root == null) return 0;

        Queue<TreeNode> queue = new LinkedList<>();
        int sum = 0;
        ArrayList<Integer> deepestLeaves = new ArrayList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            deepestLeaves = new ArrayList<>();
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                deepestLeaves.add(node.getVal());
                if (node.getLeft() != null) {
                    queue.add(node.getLeft());
                }
                if (node.getRight() != null) {
                    queue.add(node.getRight());
                }
            }
        }

        for (int leaf : deepestLeaves) {
            sum += leaf;
        }
        return sum;
    }

    // 深度遍历
    private int sum = 0;
    private int maxDepth = 0;
    public int deepestLeavesSum2(TreeNode root) {
        if (root == null) return 0;

        dfs(root, 0);
        return sum;
    }

    private void dfs(TreeNode node, int depth) {
        if (node == null) return;

        if (depth == maxDepth) {
            sum += node.getVal();
        } else if (depth > maxDepth) {
            maxDepth = depth;
            sum = node.getVal();
        }
        dfs(node.getRight(), depth + 1);
        dfs(node.getLeft(), depth + 1);
    }

    // 广度遍历
    public int deepestLeavesSum3(TreeNode root) {
        int sum = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            sum = 0;

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node == null) continue;
                sum += node.getVal();

                if (node.getLeft() != null) {
                    queue.add(node.getLeft());
                }
                if (node.getRight() != null) {
                    queue.add(node.getRight());
                }
            }
        }
        return sum;
    }
}
