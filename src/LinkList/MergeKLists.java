package LinkList;

/**
 * 23. 合并K个排序链表
 */
public class MergeKLists {

    public ListNode mergeKLists(ListNode[] lists) {
        ListNode dummy = new ListNode(-1);
        ListNode node = dummy;

        while (true) {
            int min = -1;

            for (int i = 0; i < lists.length; i++) {
                if (lists[i] == null) continue;

                if (min == -1 || lists[min].val > lists[i].val) {
                    min = i;
                }
            }
            if (min == -1) {
                break;
            } else {
                node.next = lists[min];
                node = lists[min];
                lists[min] = node.next;
                node.next = null;
            }
        }

        return dummy.next;
    }

    public ListNode mergeKLists1(ListNode[] lists) {
        return mergeKLists1(lists, 0, lists.length - 1);
    }

    private ListNode mergeKLists1(ListNode[] lists, int l, int r) {
        if (l == r) return lists[l];
        if (r == l + 1) return mergeTwoLists(lists[l], lists[r]);

        int mid = l + (r - l) / 2;
        ListNode leftNode = mergeKLists1(lists, l, mid);
        ListNode rightNode = mergeKLists1(lists, mid+1, r);
        return mergeTwoLists(leftNode, rightNode);
    }

    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummyNode = new ListNode(-1);
        ListNode node = dummyNode;

        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                node.next = l1;
                l1 = l1.next;
            } else {
                node.next = l2;
                l2 = l2.next;
            }

            node = node.next;
        }

        node.next = l1 == null ? l2 : l1;

        return dummyNode.next;
    }

    public static void main(String[] args) {
        var obj = new MergeKLists();

        ListNode node11 = new ListNode(1);
        ListNode node14 = new ListNode(4);
        ListNode node15 = new ListNode(5);
        node11.next = node14;
        node14.next = node15;


        ListNode node21 = new ListNode(1);
        ListNode node23 = new ListNode(3);
        ListNode node24 = new ListNode(4);
        node21.next = node23;
        node23.next = node24;

        ListNode[] lists = {node11, node21};
        ListNode ans = obj.mergeKLists1(lists);

        while (ans != null) {
            System.out.print(ans.val);
            System.out.print(" ");

            ans = ans.next;
        }
    }
}
