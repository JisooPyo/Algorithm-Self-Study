package leetcode.explore.recursion;

public class Rec2 {
    public static void main(String[] args) {
        Rec2 r = new Rec2();
        r.problem1();
    }

    private void problem1() {
        ListNode l4 = new ListNode(4);
        ListNode l3 = new ListNode(3, l4);
        ListNode l2 = new ListNode(2, l3);
        ListNode l1 = new ListNode(1, l2);
        ListNode answer = swapPairs(l1);
    }

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode temp = head.next;
        head.next = head.next.next;
        temp.next = head;
        temp.next.next = swapPairs(temp.next.next);
        return temp;
    }
}
