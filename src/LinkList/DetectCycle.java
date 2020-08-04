package LinkList;

import java.util.HashSet;

/**
 * 142. 环形链表 II （求入环的第一个节点）
 */
public class DetectCycle {
    // 快慢指针
    public ListNode detectCycle1(ListNode head) {
        if (head == null || head.next == null) return null;

        ListNode slow = head;
        ListNode quick = head;

        while (quick != null && quick.next != null) {
            slow = slow.next;
            quick = quick.next.next;

            if (!slow.equals(quick)) {
                continue;
            }

            ListNode ptr1 = head;
            ListNode ptr2 = slow;

            while (ptr1 != ptr2) {
                ptr1 = ptr1.next;
                ptr2 = ptr2.next;
            }
            return ptr1;
        }
        return null;
    }

    // HashMap
    public ListNode detectCycle2(ListNode head) {
        ListNode node = head;
        HashSet<ListNode> nodes = new HashSet<>();

        while(node != null) {
            if (nodes.contains(node)) {
                return node;
            } else {
                nodes.add(node);
                node = node.next;
            }
        }

        return null;
    }
}
