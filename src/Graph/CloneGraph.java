package Graph;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * 拷贝图
 */

public class CloneGraph {

    // DFS 深度优先
    private HashMap<Node, Node> visited = new HashMap<>();
    public Node cloneGraph1(Node node) {
        if (node == null) {
            return node;
        }

        if (visited.containsKey(node)) {
            return visited.get(node);
        }

        Node cloneNode = new Node(node.val);
        visited.put(node, cloneNode);

        for (Node n : node.neighbors) {
            cloneNode.neighbors.add(cloneGraph1(n));
        }

        return cloneNode;
    }

    // BFS 广度优先
    public Node cloneGraph2(Node node) {
        if (node == null) {
            return null;
        }

        LinkedList<Node> queue = new LinkedList<>();
        HashMap<Node, Node> visited = new HashMap<>();

        Node cloneNode = new Node(node.val);
        queue.add(node);
        visited.put(node, cloneNode);

        while (queue.size() > 0) {
            node = queue.remove();
            for (Node n : node.neighbors) {
                if (!visited.containsKey(n)) {
                    visited.put(n, new Node(n.val));
                    queue.add(n);
                }
                visited.get(node).neighbors.add(visited.get(n));
            }
        }

        return visited.get(node);
    }
}
