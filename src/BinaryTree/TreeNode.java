package BinaryTree;

public class TreeNode {
    private int val = 0;
    private TreeNode left;
    private TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode getLeft() {
        return this.left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return this.right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    /**
     * 返回如下一个二叉树
     *           1
     *       2       3
     *   4     5
     */
    public static TreeNode fakeTree() {
        TreeNode node1 = new TreeNode(1);
        node1.setLeft(new TreeNode(2));
        node1.setRight(new TreeNode(3));
        node1.getLeft().setLeft(new TreeNode(4));
        node1.getLeft().setRight(new TreeNode(5));
        return node1;
    }
}
