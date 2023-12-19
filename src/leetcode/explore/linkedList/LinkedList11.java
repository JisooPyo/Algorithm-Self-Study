package leetcode.explore.linkedList;

public class LinkedList11 {
    public static void main(String[] args) {
        LinkedList11 l = new LinkedList11();
        l.problem1();
        l.problem2();
        l.problem3();
    }

    private void problem3() {
        ListNode l1 = null;
        ListNode m1 = new ListNode(0);
        ListNode answer = mergeTwoLists(l1, m1);
        print(answer);
    }

    private void problem2() {
        ListNode l1 = null;
        ListNode m1 = null;
        ListNode answer = mergeTwoLists(l1, m1);
        print(answer);
    }

    private void problem1() {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(4);
        l1.next = l2;
        l2.next = l3;
        ListNode m1 = new ListNode(1);
        ListNode m2 = new ListNode(3);
        ListNode m3 = new ListNode(4);
        m1.next = m2;
        m2.next = m3;
        ListNode answer = mergeTwoLists(l1, m1);
        print(answer);
    }

    public void print(ListNode head) {
        ListNode cur = head;
        int index = 0;
        while (cur != null) {
            System.out.print("index: " + index);
            System.out.print(" -> val: " + cur.val);
            String next = cur.next == null ? "null" : Integer.toString(cur.next.val);
            System.out.print(", next: " + next + "\n");
            cur = cur.next;
            index++;
        }
        System.out.println("------------------------------------------");
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null && list2 == null) {
            return null;
        }
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }

        ListNode head1 = list1;
        ListNode head2 = list2;
        ListNode head = head1.val <= head2.val ? head1 : head2;
        ListNode tail = head;
        if (head.equals(head1)) {
            head1 = head1.next;
        } else {
            head2 = head2.next;
        }

        while (!(head1 == null && head2 == null)) {
            if (head1 == null) {
                tail.next = head2;
                break;
            }
            if (head2 == null) {
                tail.next = head1;
                break;
            }
            if (head1.val <= head2.val) {
                tail.next = head1;
                head1 = head1.next;
            } else {
                tail.next = head2;
                head2 = head2.next;
            }
            tail = tail.next;
        }
        return head;
    }
}
