package leetcode.al2403;

public class Leet19 {
    public static void main(String[] args) {
        Leet19 l = new Leet19();
        ListNode l5 = new ListNode(5);
        ListNode l4 = new ListNode(4, l5);
        ListNode l3 = new ListNode(3, l4);
        ListNode l2 = new ListNode(2, l3);
        ListNode l1 = new ListNode(1, l2);

        ListNode m1 = new ListNode(1);
        // l.removeNthFromEnd(l1, 2);
        l.removeNthFromEnd(m1, 1);
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode[] records = new ListNode[32];
        ListNode pointer = head;
        int index = 1;
        records[index] = pointer;
        while (pointer.next != null) {
            index++;
            pointer = pointer.next;
            records[index] = pointer;
        }
        if (records[index - n] == null) {
            return head.next;
        }
        records[index - n].next = records[index - n + 2];
        return head;
    }
}
