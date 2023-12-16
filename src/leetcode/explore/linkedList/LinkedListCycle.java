package leetcode.explore.linkedList;

import java.util.Objects;

public class LinkedListCycle {
    public static void main(String[] args) {
        LinkedListCycle l = new LinkedListCycle();
        ListNode l1 = new ListNode(3);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(0);
        ListNode l4 = new ListNode(-4);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l2;
        System.out.println(l.hasCycle(l1));

        ListNode m1 = new ListNode(1);
        ListNode m2 = new ListNode(2);
        m1.next = m2;
        m2.next = m1;
        System.out.println(l.hasCycle(m1));

        ListNode n1 = new ListNode(1);
        System.out.println(l.hasCycle(n1));
    }

    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return false;
        }
        ListNode slow = head.next;
        ListNode fast = head.next.next;
        while (slow != null && fast != null && fast.next != null && slow != fast) {
            slow = slow.next;
            fast = fast.next.next;
        }
        if (Objects.equals(slow, fast)) {
            return true;
        }
        return false;
    }
}
