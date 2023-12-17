package leetcode.explore.linkedList;

public class LInkedList7 {
    public static void main(String[] args) {
        LInkedList7 l = new LInkedList7();
        l.problem1();
        l.problem2();
        l.problem3();
    }

    private void problem3() {
        ListNode l1 = new ListNode(7);
        ListNode l2 = new ListNode(7);
        ListNode l3 = new ListNode(7);
        ListNode l4 = new ListNode(7);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        ListNode answer = removeElements(l1, 7);
        print(answer);
    }

    private void problem2() {
        ListNode answer = removeElements(null, 1);
        print(answer);
    }

    private void problem1() {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(6);
        ListNode l4 = new ListNode(3);
        ListNode l5 = new ListNode(4);
        ListNode l6 = new ListNode(5);
        ListNode l7 = new ListNode(6);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;
        l6.next = l7;
        ListNode answer = removeElements(l1, 6);
        print(answer);
    }

    private void print(ListNode answer) {
        if (answer == null) {
            System.out.println("answer is null");
        }
        while (answer != null) {
            System.out.print(answer.val + ", ");
            answer = answer.next;
        }
        System.out.println();
    }

    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        ListNode cur = head;
        while (cur != null) {
            if (cur.equals(head) && cur.val == val) {
                head = head.next;
                cur = head;
                continue;
            }
            if (cur.next != null && cur.next.val == val) {
                if (cur.next.next == null) {
                    cur.next = null;
                    cur = null;
                } else {
                    cur.next = cur.next.next;
                }
                continue;
            }
            cur = cur.next;
        }
        return head;
    }
}
