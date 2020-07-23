package LinkList;

import java.util.HashSet;

// 141. 环形链表
public class HasCycle {

    // 快慢指针
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;
        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != null && fast.next != null) {
            if (slow.val == fast.val) return true;

            slow = slow.next;
            fast = fast.next.next;
        }

        return false;
    }

    // hashmap
    public boolean hasCycle2(ListNode head) {
        if (head == null) return false;

        ListNode node = head;
        HashSet<ListNode> nodes = new HashSet<>();
        while (node.next != null) {
            if (nodes.contains(node)){
                return true;
            } else {
                nodes.add(node);
                node = node.next;
            }
        }

        return false;
    }

}
