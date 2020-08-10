package BinaryTree;

import java.util.ArrayList;
import java.util.List;

/**
 * 144. 二叉树前序遍历
 * 589. N叉树前序遍历
 */
public class PreOrderTraversal {

    /* 二叉树 */
    // 递归
    public List<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> ans = new ArrayList<>();
        rec(root, ans);

        return ans;
    }

    private void rec(TreeNode node, List<Integer> ans) {
        if (node == null) return;

        ans.add(node.getVal());
        rec(node.getLeft(), ans);
        rec(node.getRight(), ans);
    }

    // 循环
    public List<Integer> preorderTraversal1(TreeNode root) {
        ArrayList<Integer> ans = new ArrayList<>();
        if (root == null) return ans;
        ArrayList<TreeNode> stack = new ArrayList<>();
        TreeNode node = root;
        while (stack.size() > 0 || node != null) {
            while (node != null) {
                ans.add(node.getVal());
                stack.add(node);
                node = node.getLeft();
            }

            node = stack.remove(stack.size() - 1);
            node = node.getRight();
        }

        return ans;
    }

    // 模拟递归
    public List<Integer> preOrderTraversal2(TreeNode root) {
        ArrayList<Integer> ans = new ArrayList<>();
        if (root == null) return ans;

        ArrayList<TreeNode> stack = new ArrayList<>();
        stack.add(root);
        while(!stack.isEmpty()) {
            TreeNode node = stack.remove(stack.size() - 1);
            ans.add(node.getVal());

            if (node.getRight() != null) stack.add(node.getRight());
            if (node.getLeft() != null) stack.add(node.getLeft());
        }

        return ans;
    }

    // 迭代
    public List<Integer> preOrderTraversal3(TreeNode root) {
        List<TreeNode> stack = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        if (root == null) return ans;

        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.remove(stack.size() - 1);
            ans.add(0, node.getVal());
            if (node.getLeft() != null) stack.add(node.getLeft());
            if (node.getRight() != null) stack.add(node.getRight());
        }

        return ans;
    }

    /* N叉树 */
    // 递归
    public List<Integer> preOrder(Node root) {
        List<Integer> ans = new ArrayList<>();
        dfs(ans, root);
        return ans;
    }

    public void dfs(List<Integer> ans, Node node) {
        if (node == null) return;

        ans.add(node.val);
        for (Node n : node.children) {
            dfs(ans, n);
        }
    }

    // 模拟递归
    public List<Integer> preOrder1(Node root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) return ans;

        List<Node> stack = new ArrayList<>();
        stack.add(root);
        while (!stack.isEmpty()) {
            Node node = stack.remove(stack.size() - 1);
            ans.add(node.val);
            List<Node> children = node.children;

            for (int i = children.size() - 1; i >=0; i--) {
                if (children.get(i) == null) continue;
                stack.add(children.get(i));
            }
        }

        return ans;
    }

}
