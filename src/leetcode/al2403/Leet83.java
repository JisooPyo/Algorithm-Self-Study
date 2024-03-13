package leetcode.al2403;

public class Leet83 {
    public static void main(String[] args) {
        Leet83 l = new Leet83();
        l.problem1();
    }

    private void problem1() {
        ListNode l5 = new ListNode(3);
        ListNode l4 = new ListNode(3, l5);
        ListNode l3 = new ListNode(2, l4);
        ListNode l2 = new ListNode(1, l3);
        ListNode l1 = new ListNode(1, l2);
        printListNode(deleteDuplicates(l1));
    }

    private void printListNode(ListNode listNode) {
        if (listNode == null) {
            System.out.println("ListNode is null");
        }
        ListNode pointer = listNode;
        int index = 0;
        while (pointer != null) {
            System.out.println("index: " + index++ + ", " + "val: " + pointer.val);
            pointer = pointer.next;
        }
    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode cur = head;
        ListNode connect = head.next;
        while (connect != null) {
            cur.next = null;
            if (connect.val == cur.val) {
                connect = connect.next;
            } else {
                cur.next = connect;
                cur = connect;
                connect = connect.next;
            }
        }
        return head;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
