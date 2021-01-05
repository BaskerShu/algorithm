package Search;

import java.util.*;

/**
 * 257. 二叉树的所有路径
 */
public class BinaryTreePaths {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ret = new ArrayList<>();
        List<String> curr = new ArrayList<>();
        dfs(root, curr, ret);
        return ret;
    }

    public void dfs(TreeNode node, List<String> curr, List<String> ret) {
        if (node == null) {
            return;
        }

        curr.add(String.valueOf(node.val));
        if (node.left == null && node.right == null) {
            ret.add(String.join("->", curr));
        } else {
            dfs(node.left, curr, ret);
            dfs(node.right, curr, ret);
        }
        curr.remove(curr.size() - 1);
    }

    public List<String> binaryTreePathsWithBFS(TreeNode root) {
        List<String> ret = new ArrayList<>();
        if (root == null) {
            return ret;
        }

        Queue<NodePair> pairs = new LinkedList<>();
        pairs.add(new NodePair(root, String.valueOf(root.val)));
        while (!pairs.isEmpty()) {
            NodePair curr = pairs.poll();

            if (curr.node.left == null && curr.node.right == null) {
                ret.add(curr.path);
            }

            if (curr.node.left != null) {
                pairs.add(new NodePair(curr.node.left, curr.path + "->" + curr.node.left.val));
            }
            if (curr.node.right != null) {
                pairs.add(new NodePair(curr.node.right, curr.path + "->" + curr.node.right.val));
            }
        }

        return ret;
    }
}

class NodePair {
    TreeNode node;
    String path;

    NodePair(TreeNode n, String p) {
        node = n;
        path = p;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) {
        val = x;
    }
}
