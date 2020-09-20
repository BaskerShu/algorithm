package LinkList;

/**
 * 707. 设计链表
 */
public class MyLinkedList {

    MyListNode head;

    /**
     * Initialize your data structure here.
     */
    public MyLinkedList() {
        this.head = null;
    }

    /**
     * Get the value of the index-th node in the linked list. If the index is invalid, return -1.
     */
    public int get(int index) {
        MyListNode n = head;

        while (n != null && index >= 0) {
            if (index == 0) {
                return n.val;
            }

            n = n.next;
            index--;
        }

        return -1;
    }

    /**
     * Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
     */
    public void addAtHead(int val) {
        MyListNode h = new MyListNode(val);
        h.next = head;
        this.head = h;
    }

    /**
     * Append a node of value val to the last element of the linked list.
     */
    public void addAtTail(int val) {
        MyListNode dummy = new MyListNode(-1);
        MyListNode n = dummy;
        dummy.next = head;

        while (n.next != null) {
            n = n.next;
        }
        n.next = new MyListNode(val);
        head = dummy.next;
    }

    /**
     * Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted.
     */
    public void addAtIndex(int index, int val) {
        MyListNode dummy = new MyListNode(-1);
        MyListNode n = dummy;
        dummy.next = head;

        while (n != null && index >= 0) {
            if (index == 0) {
                MyListNode temp = n.next;
                n.next = new MyListNode(val);
                n.next.next = temp;
                break;
            }
            n = n.next;
            index--;
        }

        head = dummy.next;
    }

    /**
     * Delete the index-th node in the linked list, if the index is valid.
     */
    public void deleteAtIndex(int index) {
        MyListNode dummy = new MyListNode(-1);
        MyListNode n = dummy;
        dummy.next = head;

        while (n.next != null && index >= 0) {
            if (index == 0) {
                n.next = n.next.next;
                break;
            }

            index--;
            n = n.next;
        }

        head = dummy.next;
    }
}

class MyListNode {
    int val;
    MyListNode next;

    public MyListNode(){}

    public MyListNode(int val) {
        this.val = val;
    }
}
