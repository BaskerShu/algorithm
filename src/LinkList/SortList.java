package LinkList;

/**
 * 148. 排序链表
 */
public class SortList {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode fast = head.next;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode mid = slow.next;
        slow.next = null;
        ListNode right = sortList(mid);
        ListNode left = sortList(head);
        ListNode dummy = new ListNode(-1);
        ListNode n = dummy;


        while (left != null && right != null) {
            ListNode temp;
            if (left.val <= right.val) {
                temp = left;
                left = left.next;
            } else {
                temp = right;
                right = right.next;
            }
            n.next = temp;
            n.next.next = null;
        }

        if (left != null) {
            n.next = left;
        }

        if (right != null) {
            n.next = right;
        }

        return dummy.next;
    }
}
