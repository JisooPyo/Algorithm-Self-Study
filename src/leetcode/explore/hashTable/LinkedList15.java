package leetcode.explore.hashTable;

public class LinkedList15 {
    public static void main(String[] args) {
        LinkedList15 l = new LinkedList15();
        l.problem1();
        l.problem2();
    }

    private void problem2() {
        ListNode l3 = new ListNode(2);
        ListNode l2 = new ListNode(1, l3);
        ListNode l1 = new ListNode(0, l2);
        ListNode answer = rotateRight(l1, 4);
        print(answer);
    }

    private void problem1() {
        ListNode l5 = new ListNode(5);
        ListNode l4 = new ListNode(4, l5);
        ListNode l3 = new ListNode(3, l4);
        ListNode l2 = new ListNode(2, l3);
        ListNode l1 = new ListNode(1, l2);
        ListNode answer = rotateRight(l1, 2);
        print(answer);
    }

    private void print(ListNode answer) {
        if (answer == null) {
            System.out.println("node는 null.");
        }
        ListNode point = answer;
        int index = 0;
        while (point != null) {
            System.out.print("index: " + index++);
            System.out.print(", val: " + point.val);
            System.out.println(", next: " + (point.next == null ? "null" : point.next.val));
            point = point.next;
        }
    }

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || k == 0) {
            return head;
        }
        // 꼬리 찾기, 전체 노드 수 세기
        int count = 1;
        ListNode pointer = head;
        while (pointer.next != null) {
            count++;
            pointer = pointer.next;
        }

        // 꼬리랑 머리랑 잇기
        pointer.next = head;

        // answer 앞의 노드를 찾아 연결 끊어주기
        int move = count - 1 - k % count;
        pointer = head;
        while (move > 0) {
            pointer = pointer.next;
            move--;
        }
        ListNode next = pointer.next;
        pointer.next = null;
        return next;
    }

    public class ListNode {
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
