package BinaryTree;

// 530. 二叉搜索树的最小绝对差
public class GetMinimumDifference {

    private TreeNode pre;
    public int getMinimumDifference(TreeNode root) {
        return getMinimumDifference1(root, Integer.MAX_VALUE);
    }

    public int getMinimumDifference1(TreeNode root, int min) {
        if (root == null) return min;

        int minL = getMinimumDifference1(root.getLeft(), min);
        if (pre != null) {
            min = Math.min(minL, root.getVal() - pre.getVal());
        }
        pre = root;
        return getMinimumDifference1(root.getRight(), min);
    }

}
