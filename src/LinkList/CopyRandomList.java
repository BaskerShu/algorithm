package LinkList;

import java.util.ArrayList;
import java.util.HashMap;

// 138. 复制带随机指针的链表
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

public class CopyRandomList {

    // BFS
    public Node copyRandomList(Node head) {
        if (head == null) return null;

        ArrayList<Node> queue = new ArrayList<>();
        HashMap<Node, Node> visited = new HashMap<>();

        Node cloneNode = new Node(head.val);
        visited.put(head, cloneNode);
        queue.add(head);

        while (queue.size() > 0) {
            Node node = queue.remove(0);

            if (node.next != null) {
                if (!visited.containsKey(node.next)) {
                    queue.add(node.next);
                    visited.put(node.next, new Node(node.next.val));
                }
                visited.get(node).next = visited.get(node.next);
            }

            if (node.random != null) {
                if (!visited.containsKey(node.random)) {
                    queue.add(node.random);
                    visited.put(node.random, new Node(node.random.val));
                }
                visited.get(node).random = visited.get(node.random);
            }
        }

        return visited.get(head);
    }

    // DFS
    private HashMap<Node, Node> visited = new HashMap<>();
    public Node copyRandomList2(Node head) {
        if (head == null) return null;

        if (visited.containsKey(head)) {
            return visited.get(head);
        }

        Node cloneNode = new Node(head.val);
        visited.put(head, cloneNode);
        cloneNode.random = copyRandomList(head.random);
        cloneNode.next = copyRandomList(head.next);

        return cloneNode;
    }

    // 迭代
    public Node copyRandomList3(Node head) {
        if (head == null) {
            return null;
        }

        // Creating a new weaved list of original and copied nodes.
        Node ptr = head;
        while (ptr != null) {

            // Cloned node
            Node newNode = new Node(ptr.val);

            // Inserting the cloned node just next to the original node.
            // If A->B->C is the original linked list,
            // Linked list after weaving cloned nodes would be A->A'->B->B'->C->C'
            newNode.next = ptr.next;
            ptr.next = newNode;
            ptr = newNode.next;
        }

        ptr = head;

        // Now link the random pointers of the new nodes created.
        // Iterate the newly created list and use the original nodes' random pointers,
        // to assign references to random pointers for cloned nodes.
        while (ptr != null) {
            ptr.next.random = (ptr.random != null) ? ptr.random.next : null;
            ptr = ptr.next.next;
        }

        // Unweave the linked list to get back the original linked list and the cloned list.
        // i.e. A->A'->B->B'->C->C' would be broken to A->B->C and A'->B'->C'
        Node ptr_old_list = head; // A->B->C
        Node ptr_new_list = head.next; // A'->B'->C'
        Node head_old = head.next;
        while (ptr_old_list != null) {
            ptr_old_list.next = ptr_old_list.next.next;
            ptr_new_list.next = (ptr_new_list.next != null) ? ptr_new_list.next.next : null;
            ptr_old_list = ptr_old_list.next;
            ptr_new_list = ptr_new_list.next;
        }
        return head_old;
    }
}
