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

    // morris 遍历
    public List<Integer> inorderTraversal3(TreeNode root) {
        List<Integer> ans = new ArrayList<>();

        TreeNode node = root;
        TreeNode predcessor = null;
        while (node != null) {
            if (node.getLeft() == null) {
                ans.add(node.getVal());
                node = node.getRight();
            } else {
                predcessor = node.getLeft();
                while (predcessor.getRight() != null && predcessor.getRight() != node) {
                    predcessor = predcessor.getRight();
                }

                if (predcessor.getRight() == null) {
                    node = node.getLeft();
                    predcessor.setRight(node);
                } else {
                    ans.add(node.getVal());
                    predcessor.setRight(null);
                    node = node.getRight();
                }
            }
        }

        return ans;
    }
}
