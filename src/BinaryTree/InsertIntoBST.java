package BinaryTree;


import java.util.ArrayList;
import java.util.List;

public class InsertIntoBST {

    // 中序遍历
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);

        ArrayList<TreeNode> stack = new ArrayList<>();
        TreeNode node = root;
        boolean insertSignal = false;

        while ((!insertSignal) && (!stack.isEmpty() || node != null)) {
            while (node != null) {
                stack.add(node);
                node = node.getLeft();
            }

            node = stack.remove(stack.size() - 1);
            if (node.getVal() > val) {
                insertSignal = true;
                TreeNode n = new TreeNode(val);
                n.setLeft(node.getLeft());
                node.setLeft(n);
            }
            node = node.getRight();
        }

        if (!insertSignal) {
            TreeNode n = new TreeNode(val);
            n.setLeft(root);
            return n;
        }

        return root;
    }

    // 递归
    public TreeNode insertIntoBST2(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);

        if (root.getVal() > val) {
            root.setLeft(insertIntoBST2(root.getLeft(), val));
        } else {
            root.setRight(insertIntoBST2(root.getRight(), val));
        }

        return root;
    }

    // 迭代
    public TreeNode insertIntoBST3(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);

        TreeNode node = root;
        TreeNode pre = null;
        while(node != null) {
            pre = node;
            if (node.getVal() > val) {
                node = node.getLeft();
            } else {
                node = node.getRight();
            }
        }

        if (pre.getVal() > val) {
            pre.setLeft(new TreeNode(val));
        } else {
            pre.setRight(new TreeNode(val));
        }

        return root;
    }
}
