package leetcode.explore.linkedList;

public class LinkedList4_x {
    public static void main(String[] args) {
        LinkedList4_x i = new LinkedList4_x();
        i.problem1();
        i.problem2();
        i.problem3();
    }

    private void problem3() {
        ListNode l1 = new ListNode(2);
        ListNode l2 = new ListNode(6);
        ListNode l3 = new ListNode(4);
        ListNode m1 = new ListNode(1);
        ListNode m2 = new ListNode(5);
        l1.next = l2;
        l2.next = l3;
        m1.next = m2;
        ListNode a1 = getIntersectionNode(l1, m1);
        System.out.println(a1 == null ? null : a1.val);
    }

    private void problem2() {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(9);
        ListNode l3 = new ListNode(1);
        ListNode m1 = new ListNode(3);
        ListNode c1 = new ListNode(2);
        ListNode c2 = new ListNode(4);
        l1.next = l2;
        l2.next = l3;
        l3.next = c1;
        c1.next = c2;
        m1.next = c1;
        ListNode a1 = getIntersectionNode(l1, m1);
        System.out.println(a1 == null ? null : a1.val);
    }

    private void problem1() {
        ListNode l1 = new ListNode(4);
        ListNode l2 = new ListNode(1);
        ListNode m1 = new ListNode(5);
        ListNode m2 = new ListNode(6);
        ListNode m3 = new ListNode(1);
        ListNode c1 = new ListNode(8);
        ListNode c2 = new ListNode(4);
        ListNode c3 = new ListNode(5);
        l1.next = l2;
        l2.next = c1;
        c1.next = c2;
        c2.next = c3;
        m1.next = m2;
        m2.next = m3;
        m3.next = c1;
        ListNode a1 = getIntersectionNode(l1, m1);
        System.out.println(a1 == null ? null : a1.val);
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        //boundary check
        if (headA == null || headB == null) return null;

        ListNode a = headA;
        ListNode b = headB;

        //if a & b have different len, then we will stop the loop after second iteration
        while (a != b) {
            //for the end of first iteration, we just reset the pointer to the head of another linkedlist
            a = a == null ? headB : a.next;
            b = b == null ? headA : b.next;
        }

        return a;
    }
}
