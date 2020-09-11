package BinaryTree;

/**
 * 100. 相同的树
 */
public class IsSameTree {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null) return false;
        if (q == null) return false;
        if (p.getVal() != q.getVal()) return false;

        return isSameTree(p.getLeft(), p.getLeft()) && isSameTree(p.getRight(), p.getRight());
    }
}
