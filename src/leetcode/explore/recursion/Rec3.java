package leetcode.explore.recursion;

public class Rec3 {
    public static void main(String[] args) {
        Rec3 r = new Rec3();
        ListNode l5 = new ListNode(5);
        ListNode l4 = new ListNode(4, l5);
        ListNode l3 = new ListNode(3, l4);
        ListNode l2 = new ListNode(2, l3);
        ListNode l1 = new ListNode(1, l2);
        ListNode answer = r.reverseList(l1);
    }

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }
        rec(head, head.next);
        return tail;
    }

    private void rec(ListNode head, ListNode next) {
        if (next.next != null) {
            rec(head.next, head.next.next);
        }
        head.next = null;
        next.next = head;
    }
}
