package leetcode.al2403;

import java.util.HashSet;
import java.util.Set;

public class Leet141 {
    public static void main(String[] args) {
        Leet141 l = new Leet141();
        ListNode l1 = new ListNode(3);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(0);
        ListNode l4 = new ListNode(-4);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l2;

        ListNode m1 = new ListNode(1);
        ListNode m2 = new ListNode(2);
        m1.next = m2;
        m2.next = m1;

        ListNode n1 = new ListNode(1);

        System.out.println(l.hasCycle(l1));
        System.out.println(l.hasCycle(m1));
        System.out.println(l.hasCycle(n1));
    }

    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        Set<ListNode> set = new HashSet<>();
        ListNode pointer = head;
        set.add(pointer);
        while (pointer.next != null) {
            if (set.contains(pointer.next)) {
                return true;
            }
            set.add(pointer.next);
            pointer = pointer.next;
        }
        return false;
    }

    // 다른 사람의 풀이
    // Two-Pointer로 푸는 것이 더 빠르다!
    public boolean hasCycle2(ListNode head) {
        if(head == null) return false;
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                return true;
            }
        }
        return false;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
