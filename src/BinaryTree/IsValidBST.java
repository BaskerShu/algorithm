package BinaryTree;

/**
 * 验证二叉搜索数
 */

public class IsValidBST {

    // 分治/递归
    public boolean solution(TreeNode root) {
        return isValidBST(root, null, null);
    }

    private Boolean isValidBST(TreeNode node, Integer min, Integer max) {
        if (node == null) return true;

        boolean result = true;
        int v = node.getVal();
        if (min != null) result = v > min;
        if (max != null) result = result && v < max;

        return result && isValidBST(node.getLeft(), min, v) && isValidBST(node.getRight(), v, max);
    }

    // 中序遍历
    private TreeNode pre;
    public boolean solution2(TreeNode root) {
        return inOrder(root);
    }

    public boolean inOrder(TreeNode root) {
        if (root == null) return true;

        if (!inOrder(root.getLeft())) return false;
        if (pre != null && pre.getVal() >= root.getVal()) return false;
        pre = root;
        return inOrder(root.getRight());
    }
}
