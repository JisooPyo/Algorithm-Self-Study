package leetcode.explore.linkedList;

public class LinkedList8_x {
    public static void main(String[] args) {
        LinkedList8_x l = new LinkedList8_x();
        l.problem1();
        l.problem2();
    }

    private void problem2() {
        ListNode l1 = new ListNode(2);
        ListNode l2 = new ListNode(1);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(5);
        ListNode l5 = new ListNode(6);
        ListNode l6 = new ListNode(4);
        ListNode l7 = new ListNode(7);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;
        l6.next = l7;
        ListNode answer = oddEvenList(l1);
        print(answer);
    }

    private void problem1() {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        ListNode answer = oddEvenList(l1);
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

    // 홀수 포인터 따로 짝수 포인터 따로
    // 짝수의 Head 기억하여 홀수 끝에 짝수 Head 붙이기
    public ListNode oddEvenList(ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode odd = head, even = head.next, evenHead = even;

        while (even != null && even.next != null) {
            // odd = 2, even = 1, evenHead = 1
            // odd = 3, even = 5, evenHead = 1
            // odd = 6, even = 4, evenHead = 1
            odd.next = odd.next.next;
            // 2 3 5 6 4 7
            // 2 3 6 4 7
            // 2 3 6 7
            even.next = even.next.next;
            // 2 1 5 6 4 7
            // 2 1 5 4 7
            // 2 1 5 4
            odd = odd.next;
            // odd = 3
            // odd = 6
            // odd = 7
            even = even.next;
            // even = 5
            // even = 4
            // even = null -> break
        }
        odd.next = evenHead;
        // 2 3 6 7 1 5 4
        return head;
    }
}
