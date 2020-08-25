package LinkList;

/**
 * 147. 对链表进行插入排序
 */
public class InsertionSortList {
    
    public ListNode insertionSortList(ListNode head) {
        ListNode dummyNode = new ListNode(Integer.MIN_VALUE);
        ListNode pre = dummyNode;
        ListNode node = head;
        dummyNode.next = head;

        while (node != null) {
            if (node.val >= pre.val) {
                pre = node;
                node = node.next;
            } else {
                ListNode n = dummyNode;
//                while (n.next != node) {
//                    if (node.val >= n.val && node.val < n.next.val) {
//                        pre.next = node.next;
//                        ListNode next = n.next;
//                        n.next = node;
//                        node.next = next;
//                        node = pre.next;
//                        break;
//                    }
//                    n = n.next;
//                }
                // 更优雅的写法
                while (n.next != node && n.next.val < node.val) {
                    n = n.next;
                }
                pre.next = node.next;
                node.next = n.next;
                n.next = node;
                node = pre.next;
            }
        }
        return dummyNode.next;
    }
}
