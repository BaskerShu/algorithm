package BinaryTree;

import java.util.ArrayList;
import java.util.List;

public class InorderTraversal {
    // 递归
    public List<Integer> inorderTraversal1(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null) return result;

        result.addAll(inorderTraversal1(root.getLeft()));
        result.add(root.getVal());
        result.addAll(inorderTraversal1(root.getLeft()));
        return result;
    }

    // 非递归
    public List<Integer> inorderTraversal2(TreeNode root) {
        ArrayList<TreeNode> stack = new ArrayList<>();
        ArrayList<Integer> result = new ArrayList<>();
        TreeNode node = root;

        while (stack.size() > 0 || node != null) {
            while (node != null) {
                stack.add(node);
                node = node.getLeft();
            }

            node = stack.remove(stack.size() - 1);
            result.add(node.getVal());
            node = node.getRight();
        }

        return result;
    }
}
