package BinaryTree;

import java.util.ArrayList;

/**
 * 99. 恢复二叉搜索树
 */
public class RecoverTree {

    public void recoverTree(TreeNode root) {
        if (root == null) return;

        TreeNode node1 = null;
        TreeNode node2 = null;
        ArrayList<TreeNode> stack = new ArrayList<>();
        TreeNode node = root;
        TreeNode preNode = null;

        while (!stack.isEmpty() || node != null) {
            while (node != null) {
                stack.add(node);
                node = node.getLeft();
            }

            node = stack.remove(stack.size() - 1);
            if (preNode != null && preNode.getVal() > node.getVal()) {
                if (node1 == null) {
                    node1 = preNode;
                    node2 = node;
                } else {
                    node2 = node;
                    break;
                }
            }
            preNode = node;
            node = node.getRight();
        }

        int val = node2.getVal();
        node2.setVal(node1.getVal());
        node1.setVal(val);
    }

    public static void main(String[] args) {
        var obj = new RecoverTree();
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        node3.setLeft(node1);
        node3.setRight(node4);
        node4.setLeft(node2);

        obj.recoverTree(node3);
    }
}
