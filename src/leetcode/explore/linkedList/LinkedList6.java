package leetcode.explore.linkedList;

public class LinkedList6 {
    public static void main(String[] args) {
        LinkedList6 l = new LinkedList6();
        l.problem1();
        l.problem2();
        l.problem3();
    }

    private void problem3() {
        ListNode l1 = null;
        ListNode answer = reverseList(l1);
        print(answer);
    }

    private void problem2() {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        l1.next = l2;
        ListNode answer = reverseList(l1);
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
        ListNode answer = reverseList2(l1);
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

    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode answer = head;
        while (head.next != null) {
            ListNode nextNode = head.next;
            head.next = head.next.next;
            nextNode.next = answer;
            answer = nextNode;
        }
        return answer;
    }

    // 재귀로 푸는 방법
    public ListNode reverseList2(ListNode head) {
        /* recursive solution */
        return reverseListInt(head, null);
    }

    private ListNode reverseListInt(ListNode head, ListNode newHead) {
        if (head == null)
            return newHead;
        ListNode next = head.next;
        head.next = newHead;
        return reverseListInt(next, head);
    }
}
