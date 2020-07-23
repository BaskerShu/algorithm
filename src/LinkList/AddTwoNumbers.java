package LinkList;

public class AddTwoNumbers {
    // 使用递归
    public ListNode solution(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) return null;

        return sum(l1, l2, 0);
    }

    // 使用非递归
    public ListNode solution2(ListNode l1, ListNode l2) {
        ListNode dummyNode = new ListNode(-1);
        ListNode cursor = dummyNode;

        int carry = 0;
        while (l1 != null || l2 != null || carry != 0) {
            if (l1 != null) {
                carry += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                carry += l2.val;
                l2 = l2.next;
            }

            cursor.next = new ListNode(carry % 10);
            cursor = cursor.next;
            carry = carry / 10;
        }
        return dummyNode.next;
    }

    private ListNode sum(ListNode l1, ListNode l2, int initialize) {
        if (l1 == null && l2 == null && initialize == 0) return null;

        int l1Val = l1 != null ? l1.val : 0;
        int l2Val = l2 != null ? l2.val : 0;
        ListNode l1Next = l1 != null ? l1.next : l1;
        ListNode l2Next = l2 != null ? l2.next : l2;
        int sum = l1Val + l2Val + initialize;
        initialize = sum >= 10 ? 1 : 0;
        int val = (initialize == 1) ? (sum - 10) : sum;
        ListNode node = new ListNode(val);
        node.next = sum(l1Next, l2Next, initialize);

        return node;
    }
}
