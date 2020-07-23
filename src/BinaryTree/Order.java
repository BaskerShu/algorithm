/*
 * 二叉树的各种排序方法
 *  DFS
 *  BFS
 *  分治
 */
package BinaryTree;

import java.lang.reflect.Array;
import java.util.ArrayList;

class Order {
    // 使用递归进行 前序遍历
    private static void preOrderWithRecursive(TreeNode root) {
        if (root == null) return;

        System.out.print(root.getVal() + " ");
        Order.preOrderWithRecursive(root.getLeft());
        Order.preOrderWithRecursive(root.getRight());
    }

    // 不使用递归进行 前序遍历
    private static void preOrderWithoutRecursive(TreeNode root) {
        if (root == null) return;

        TreeNode node = root;
        ArrayList<TreeNode> stack = new ArrayList<TreeNode>();
        while (node != null || stack.size() > 0) {
            while (node != null) {
                System.out.print(node.getVal() + " ");
                stack.add(node);
                node = node.getLeft();
            }

            node = stack.remove(stack.size() - 1);
            node = node.getRight();
        }
    }

    // 前序遍历（DFS）
    private static void preOrderWithDFS(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        dfsCalc(result, root);
        System.out.println(result);
    }

    private static void dfsCalc(ArrayList<Integer> result, TreeNode node) {
        if (node == null) return;

        result.add(node.getVal());
        dfsCalc(result, node.getLeft());
        dfsCalc(result, node.getRight());
    }

    // 前序遍历（分治法）
    private static void preOrderWithDivideAndConquer(TreeNode root) {
        ArrayList<Integer> result = divideAndConquer(root);

        System.out.println(result);
    }

    private static ArrayList<Integer> divideAndConquer(TreeNode node) {
        ArrayList<Integer> result = new ArrayList<>();
        if (node == null) return result;
        ArrayList<Integer> left = divideAndConquer(node.getLeft());
        ArrayList<Integer> right = divideAndConquer(node.getRight());
        result.add(node.getVal());
        result.addAll(left);
        result.addAll(right);

        return result;
    }
    // 使用用递归进行 中序遍历
    private static void midOrderWithRecursive(TreeNode root) {
        if (root == null) return;

        midOrderWithRecursive(root.getLeft());
        System.out.print(root.getVal() + " ");
        midOrderWithRecursive(root.getRight());
    }

    // 不使用递归进行 中序遍历
    private static void midOrderWithoutRecursive(TreeNode root) {
        ArrayList<TreeNode> stack = new ArrayList<>();
        TreeNode node = root;
        while(node != null || stack.size() > 0) {
            while (node != null) {
                stack.add(node);
                node = node.getLeft();
            }

            node = stack.remove(stack.size() - 1);
            System.out.print(node.getVal() + " ");
            node = node.getRight();
        }
    }

    // 不使用递归进行 后序遍历
    private static void postOrderWithoutRecursive(TreeNode root) {
        ArrayList<TreeNode> stack = new ArrayList<>();
        TreeNode node = root;
        TreeNode lastNode = null;

        while (node != null || stack.size() > 0) {
            while (node != null) {
                stack.add(node);
                node = node.getLeft();
            }

            node = stack.get(stack.size() - 1);
            if (node.getRight() == null || lastNode == node.getRight()) {
                stack.remove(node);
                System.out.print(node.getVal() + " ");
                lastNode = node;
                node = null;
            }
            else{
                node = node.getRight();
            }
        }
    }

    public ArrayList<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();

        if (root == null) return result;

        result.addAll(inorderTraversal(root.getLeft()));
        result.add(root.getVal());
        result.addAll(inorderTraversal(root.getLeft()));

        return result;
    }

    public static void main(String[] args) {
        int i = '2' - '0';
        System.out.println(i);
//        TreeNode root = TreeNode.fakeTree();
//        preOrderWithRecursive(root);
//        System.out.println();
//        preOrderWithoutRecursive(root);
//        System.out.println();
//        preOrderWithDFS(root);
//        preOrderWithDivideAndConquer(root);

//        midOrderWithRecursive(root);
//        System.out.println();
//        midOrderWithoutRecursive(root);

//        postOrderWithoutRecursive(root);
    }
}
