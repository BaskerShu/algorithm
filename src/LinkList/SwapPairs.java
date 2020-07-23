package LinkList;

// 24. 两两交换链表中的节点
public class SwapPairs {
    public static ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode l1 = head;
        ListNode l2 = head.next;

        l1.next = swapPairs(l2.next);
        l2.next = l1;

        return l2;
    }

    public static ListNode swapPairs2(ListNode head) {
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;

        ListNode preNode = dummyNode;
        while (head != null && head.next != null) {
            ListNode l1 = head;
            ListNode l2 = head.next;

            preNode.next = l2;
            l1.next = l2.next;
            l2.next = l1;

            preNode = l1;
            head = l1.next;
        }

        return dummyNode.next;
    }

    public static ListNode swap(ListNode head) {
        if (head == null) return head;
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;

        ListNode preNode = dummyNode;
        ListNode node = head;
        while (node != null) {
            ListNode next = node.next;
            node.next = preNode;

            preNode = node;
            node = next;
        }
        head.next = null;
        return preNode;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;

        var node = swap(l1);
    }
}
