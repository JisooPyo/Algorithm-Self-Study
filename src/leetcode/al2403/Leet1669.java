package leetcode.al2403;

public class Leet1669 {
    public static void main(String[] args) {
        Leet1669 l = new Leet1669();

        ListNode l6 = new ListNode(5);
        ListNode l5 = new ListNode(9, l6);
        ListNode l4 = new ListNode(6, l5);
        ListNode l3 = new ListNode(13, l4);
        ListNode l2 = new ListNode(1, l3);
        ListNode l1 = new ListNode(10, l2);

        ListNode m3 = new ListNode(1000002);
        ListNode m2 = new ListNode(1000001, m3);
        ListNode m1 = new ListNode(1000000, m2);

        ListNode answer = l.mergeInBetween(l1, 3, 4, m1);
    }

    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode beforeA = new ListNode();
        ListNode afterB;

        int index = 0;
        ListNode pointer1 = list1;
        while (index <= b) {
            if (index == a - 1) {
                beforeA = pointer1;
            }
            pointer1 = pointer1.next;
            index++;
        }
        afterB = pointer1;

        ListNode list2Tail = new ListNode();
        ListNode pointer2 = list2;
        while (pointer2.next != null) {
            pointer2 = pointer2.next;
        }
        list2Tail = pointer2;

        beforeA.next = list2;
        list2Tail.next = afterB;

        return list1;
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
