package BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 429. N叉树的层序遍历
 */
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}

public class LevelOrder {

    // 广度搜索
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        List<Node> queue = new LinkedList<>();
        Node dummyNode = new Node(-1);
        queue.add(root);
        queue.add(dummyNode);
        ans.add(new ArrayList<>());

        while (!queue.isEmpty()) {
            Node node = queue.remove(0);
            if (node.equals(dummyNode)) {
                if (queue.isEmpty()) {
                    continue;
                }
                ans.add(new ArrayList<>());
                queue.add(dummyNode);
            } else {
                ans.get(ans.size() - 1).add(node.val);
                if (node.children != null) {
                    queue.addAll(node.children);
                }
            }
        }

        return ans;
    }

    // 广度搜索2
    public List<List<Integer>> levelOrder2(Node root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) return ans;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                if (node == null) continue;
                level.add(node.val);
                queue.addAll(node.children);
            }
            ans.add(level);
        }
        return ans;
    }

    // 深度搜索
    public List<List<Integer>> levelOrder3(Node root) {
        List<List<Integer>> ans = new ArrayList<>();
        dfs(root, 0, ans);

        return ans;
    }

    public void dfs(Node node, int level, List<List<Integer>> ans) {
        if (node == null) {
            return;
        }

        if (ans.size() <= level) {
            ans.add(new ArrayList<>());
        }
        ans.get(level).add(node.val);
        for (Node n : node.children) {
            dfs(n, level+1, ans);
        }
    }

    public static void main(String[] args) {
        Node node = new Node(1);

        Node node3 = new Node(3);
        Node node2 = new Node(2);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);

        node3.children = new ArrayList<>();
        node3.children.add(node5);
        node3.children.add(node6);

        node.children = new ArrayList<>();
        node.children.add(node3);
        node.children.add(node2);
        node.children.add(node4);

        var obj = new LevelOrder();
        var ans = obj.levelOrder(node);
        System.out.println(ans);
    }
}
