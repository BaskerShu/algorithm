package LinkList;

// 206. 反转链表
public class ReverseList {

    // 迭代
    public ListNode reverseList(ListNode head) {
        if (head == null) return null;

        ListNode pre = null;
        ListNode node = head;

        while (node != null) {
            ListNode next = node.next;
            node.next = pre;
            pre = node;
            node = next;
        }
        return pre;
    }

    // 递归
    public ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode ans = reverseList2(head);
        head.next.next = head;
        head.next = null;

        return ans;
    }
}
