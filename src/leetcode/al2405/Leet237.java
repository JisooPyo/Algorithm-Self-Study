package leetcode.al2405;

/**
 * 237. Delete Node in a Linked List
 */
public class Leet237 {
    public static void main(String[] args) {
        Leet237 l = new Leet237();
        l.problem1();
        l.problem2();
    }

    private void problem1() {
        ListNode l1 = new ListNode(4);
        ListNode l2 = new ListNode(5);
        ListNode l3 = new ListNode(1);
        ListNode l4 = new ListNode(9);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;

        deleteNode(l2);
        print(l1);
    }

    private void problem2() {
        ListNode l1 = new ListNode(4);
        ListNode l2 = new ListNode(5);
        ListNode l3 = new ListNode(1);
        ListNode l4 = new ListNode(9);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;

        deleteNode(l3);
        print(l1);
    }

    private void print(ListNode l1) {
        ListNode pointer = l1;
        while (pointer != null) {
            System.out.print(pointer.val + ", ");
            pointer = pointer.next;
        }
        System.out.println();
    }

    public void deleteNode(ListNode node) {
        ListNode pointer = node;
        while (pointer.next.next != null) {
            pointer.val = pointer.next.val;
            pointer = pointer.next;
        }
        pointer.val = pointer.next.val;
        pointer.next = null;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
