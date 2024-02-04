package leetcode.explore.recursion;

public class Rec10 {

    // list1 = [1,2,4], list2 = [1,3,4]
    public static void main(String[] args) {
        Rec10 r = new Rec10();
        r.problem1();
    }

    private void problem1() {
        ListNode l3 = new ListNode(4);
        ListNode l2 = new ListNode(2, l3);
        ListNode l1 = new ListNode(1, l2);

        ListNode m3 = new ListNode(4);
        ListNode m2 = new ListNode(3, m3);
        ListNode m1 = new ListNode(1, m2);

        ListNode answer = mergeTwoLists(l1, m1);
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        ListNode head;
        if (list1.val <= list2.val) {
            head = list1;
            list1 = list1.next;
        } else {
            head = list2;
            list2 = list2.next;
        }
        head.next = mergeTwoLists(list1, list2);
        return head;
    }

}
