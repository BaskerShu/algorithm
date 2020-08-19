package BinaryTree;

import java.util.*;

/**
 * 145. 二叉树的后序遍历
 * 590. N叉树的后续遍历
 */
public class PostOrderTraversal {

    // 二叉树-递归
    public List<Integer> postOrderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        postOrderTraversal(root, ans);

        return ans;
    }

    private void postOrderTraversal(TreeNode root, List<Integer> ans) {
        if (root == null) return;

        postOrderTraversal(root.getLeft(), ans);
        postOrderTraversal(root.getRight(), ans);
        ans.add(root.getVal());
    }

    // 二叉树-迭代
    public List<Integer> postOrderTraversal2(TreeNode root) {
        List<Integer> ans = new ArrayList<>();

        if (root == null) return ans;

        List<TreeNode> stack = new ArrayList<>();
        TreeNode node = root;
        TreeNode listNode = null;

        while (stack.size() > 0 || node != null) {
            while (node != null) {
                stack.add(node);
                node = node.getLeft();
            }

            node = stack.get(stack.size() - 1);
            if (node.getRight() == null || node.getRight() == listNode) {
                stack.remove(node);
                ans.add(node.getVal());
                listNode = node;
                node = null;
            } else {
                node = node.getRight();
            }
        }

        return ans;
    }

    // N叉树-递归
    public List<Integer> postorder(Node root) {
        List<Integer> ans = new ArrayList<>();
        if (root==null) return ans;

        postOrder(root, ans);
        return ans;
    }

    private void postOrder(Node node, List<Integer> ans) {
        if (node == null) return;

        for (Node n : node.children) {
            postOrder(n, ans);
        }
        ans.add(node.val);
    }

    // N叉数-迭代
    public List<Integer> postorder2(Node root) {
        List<Integer> ans = new LinkedList<>();
        if (root == null) return ans;

        Stack<Node> stack = new Stack<>();
        stack.add(root);
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            ans.add(0, node.val);

            stack.addAll(node.children);
        }

        return ans;
    }
}
