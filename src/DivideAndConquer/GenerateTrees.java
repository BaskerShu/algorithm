package DivideAndConquer;

import java.util.ArrayList;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

/**
 * 95. 不同的二叉搜索树 II
 */
public class GenerateTrees {

    public List<TreeNode> generateTrees(int n) {
        if (n < 1) return null;
        return generateTrees(1, n);
    }

    private List<TreeNode> generateTrees(int start, int end) {
        List<TreeNode> ans = new ArrayList<>();

        if (start > end) {
            ans.add(null);
        }

        for (int i = start; i <= end; i++) {
            List<TreeNode> lNodes = generateTrees(start, i-1);
            List<TreeNode> rNodes = generateTrees(i+1, end);

            for (TreeNode lNode : lNodes) {
                for (TreeNode rNode : rNodes) {
                    TreeNode n = new TreeNode(i);
                    n.left = lNode;
                    n.right = rNode;
                    ans.add(n);
                }
            }
        }
        return ans;
    }
}
