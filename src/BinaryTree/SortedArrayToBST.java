package BinaryTree;

/**
 * 108. 将有序数组转换为二叉搜索树
 */
public class SortedArrayToBST {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) return null;

        return sortedArrayToBST(nums, 0, nums.length);
    }

    private TreeNode sortedArrayToBST(int[] nums, int l, int r) {
        if (l >= r) return null;
        if (l == r - 1) return new TreeNode(nums[l]);

        int mid = l + (r - l) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.setLeft(sortedArrayToBST(nums, l, mid));
        node.setRight(sortedArrayToBST(nums, mid+1, r));

        return node;
    }

    public static void main(String[] args) {
        var obj = new SortedArrayToBST();
        int[] nums = {-10,-3,0,5,9};
        TreeNode ans = obj.sortedArrayToBST(nums);

        System.out.println(ans);
    }
}
