package leetcode.explore.linkedList;

public class LinkedList12 {
    public static void main(String[] args) {
        LinkedList12 l = new LinkedList12();
//        l.problem1();
//        l.problem2();
        l.problem3();
    }

    private void problem3() {
        ListNode l1 = new ListNode(9);
        ListNode l2 = new ListNode(9);
        ListNode l3 = new ListNode(9);
        ListNode l4 = new ListNode(9);
        ListNode l5 = new ListNode(9);
        ListNode l6 = new ListNode(9);
        ListNode l7 = new ListNode(9);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;
        l6.next = l7;
        ListNode m1 = new ListNode(9);
        ListNode m2 = new ListNode(9);
        ListNode m3 = new ListNode(9);
        ListNode m4 = new ListNode(9);
        m1.next = m2;
        m2.next = m3;
        m3.next = m4;
        ListNode answer = addTwoNumbers(l1, m1);
        print(answer);
    }

    private void problem2() {
        ListNode l1 = new ListNode(0);
        ListNode m1 = new ListNode(0);
        ListNode answer = addTwoNumbers(l1, m1);
        print(answer);
    }

    private void problem1() {
        ListNode l1 = new ListNode(2);
        ListNode l2 = new ListNode(4);
        ListNode l3 = new ListNode(3);
        l1.next = l2;
        l2.next = l3;
        ListNode m1 = new ListNode(5);
        ListNode m2 = new ListNode(6);
        ListNode m3 = new ListNode(4);
        m1.next = m2;
        m2.next = m3;
        ListNode answer = addTwoNumbers(l1, m1);
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

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int l1Size = getSize(l1);
        int l2Size = getSize(l2);
        ListNode longPoint = l1Size >= l2Size ? l1 : l2;
        ListNode shortPoint = l1Size >= l2Size ? l2 : l1;
        // 10의 자리
        int ten = 0;
        while (true) {
            // 짧은 linked list null check
            int shortVal = shortPoint == null ? 0 : shortPoint.val;
            int val = longPoint.val + shortVal + ten;

            // 올라가는 수 체크
            if (val >= 10) {
                ten = 1;
                val = val - 10;
            } else {
                ten = 0;
            }

            // 긴쪽에 더한 값으로 업데이트
            longPoint.val = val;
            if (longPoint.next != null) {
                longPoint = longPoint.next;
            } else {
                break;
            }
            if (shortPoint != null) {
                shortPoint = shortPoint.next;
            }
        }

        // 1이 남아 있으면 꼬리에 마저 달아주기
        if (ten == 1) {
            ListNode tail = new ListNode(1);
            longPoint.next = tail;
        }
        return l1Size >= l2Size ? l1 : l2;
    }

    private int getSize(ListNode listNode) {
        int size = 0;
        ListNode point = listNode;
        while (point != null) {
            point = point.next;
            size++;
        }
        return size;
    }
}
