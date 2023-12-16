package leetcode.explore.linkedList;

import java.util.HashSet;
import java.util.Set;

public class LinkedListCycle2 {
    public static void main(String[] args) {
        LinkedListCycle2 l = new LinkedListCycle2();
        ListNode l1 = new ListNode(3);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(0);
        ListNode l4 = new ListNode(-4);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l2;
        System.out.println(l.detectCycle(l1));

        ListNode m1 = new ListNode(1);
        ListNode m2 = new ListNode(2);
        m1.next = m2;
        m2.next = m1;
        System.out.println(l.detectCycle(m1));

        ListNode n1 = new ListNode(1);
        System.out.println(l.detectCycle(n1));
    }

    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }
        Set<ListNode> set = new HashSet<>();
        ListNode move = head;
        while (!set.contains(move) && move != null) {
            set.add(move);
            move = move.next;
        }
        return move;
    }

    // Set 사용하지 않고 two-pointer로 푸는 방법
    public ListNode detectCycle2(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        // Detect cycle
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {

                slow = head;

                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }

                return slow;
            }
        }

        return null;
    }
}
