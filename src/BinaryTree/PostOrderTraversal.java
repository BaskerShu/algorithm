package BinaryTree;

import java.util.ArrayList;
import java.util.List;

// 145. 二叉树的后序遍历
public class PostOrderTraversal {

    // 递归
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

    // 迭代
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
}
