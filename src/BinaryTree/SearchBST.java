package BinaryTree;

import java.util.ArrayList;

// 700. 二叉搜索树中的搜索
public class SearchBST {

    // 递归
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) return null;

        if (root.getVal() > val){
            return searchBST(root.getLeft(), val);
        } else if (root.getVal() < val) {
            return searchBST(root.getRight(), val);
        } else {
            return root;
        }
    }

    // 中序遍历
    public TreeNode searchBST2(TreeNode root, int val) {
        if (root == null) return null;

        ArrayList<TreeNode> stack = new ArrayList<>();
        TreeNode node = root;
        while (node != null || stack.size() > 0) {
            while (node != null) {
                stack.add(node);
                node = node.getLeft();
            }

            TreeNode n = stack.remove(stack.size() - 1);
            if (n.getVal() == val) {
                return n;
            } else if (n.getVal() < val) {
                node = n.getRight();
            } else {
                return null;
            }
        }

        return null;
    }

    // 迭代
    public TreeNode searchBST3(TreeNode root, int val) {
        while (root != null && root.getVal() != val) {
            root = root.getVal() > val ? root.getLeft() : root.getRight();
        }

        return root;
    }
}
