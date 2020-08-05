package BinaryTree;

import java.util.*;

/**
 * 230. 二叉搜索树中第K小的元素
 */
public class KthSmallest {

    // 递归
    private int kthSmallest = -1;
    private int level = -1;
    public int kthSmallest(TreeNode root, int k) {
        if (k == 0) return kthSmallest;

        level = k;
        dfs(root);
        return kthSmallest;
    }

    private int kthSmallest(TreeNode node) {
        if (node == null) return -1;

        int ans = kthSmallest(node.getLeft());
        if (level == 0) return ans;
        if (--level == 0) return node.getVal();
        return kthSmallest(node.getRight());
    }

    private void dfs(TreeNode node) {
        if (node == null) return;

        dfs(node);
        if (level == 1 || kthSmallest != -1) {
            kthSmallest = node.getVal();
            return;
        }
        level -= 1;
        dfs(node);

    }

    // 利用堆栈模拟递归
    public int kthSmallest2(TreeNode root, int k) {
        if (root == null) return -1;

        TreeNode node = root;
        List<TreeNode> stack = new ArrayList<>();

        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                stack.add(node);
                node = node.getLeft();
            }

            node = stack.remove(stack.size() - 1);
            if (k-- == 1) return node.getVal();
            node = node.getRight();
        }

        return -1;
    }

    // 分治
    public int kthSmallest3(TreeNode root, int k) {
        int c = treeCount(root.getLeft());
        if (k == c + 1) {
            return root.getVal();
        } else if (k < c + 1) {
            return kthSmallest(root.getLeft(), k);
        } else {
            return kthSmallest(root.getRight(), k - c - 1);
        }
    }

    private int treeCount(TreeNode node) {
        if (node == null) return 0;

        return treeCount(node.getLeft()) + 1 + treeCount(node.getRight());
    }
}
