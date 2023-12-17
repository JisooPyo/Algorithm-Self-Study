package leetcode.explore.linkedList;

public class LinkedList5 {
    public static void main(String[] args) {
        LinkedList5 l = new LinkedList5();
        l.problem1();
        l.problem2();
        l.problem3();
    }

    private void problem3() {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        l1.next = l2;
        ListNode answer = removeNthFromEnd(l1, 1);
        print(answer);
    }

    private void problem2() {
        ListNode l1 = new ListNode(1);
        ListNode answer = removeNthFromEnd(l1, 1);
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
        ListNode answer = removeNthFromEnd(l1, 2);
        print(answer);
    }

    private void print(ListNode node) {
        ListNode move = node;
        while (move != null) {
            System.out.print(move.val + ", ");
            move = move.next;
        }
        System.out.println();
    }

    // 내가 떠올린 방식: 한 바퀴 돌고 개수를 세어 개수 - n + 1 번째의 노드 삭제
    // Follow up: Could you do this in one pass?

    // leetcode discuss
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast = head, slow = head;
        // slow -> head
        // fast -> head -> 노드 2 -> 노드 3
        for (int i = 0; i < n; i++) fast = fast.next;
        // node 길이가 n일때 -> head 제거 -> head.next return
        if (fast == null) return head.next;
        // slow와 fast가 n개만큼 차이가 나는 것을 이용
        // fast가 끝 노드 null에 도달했을 때 slow는 끝에서 n+1번째 노드(타겟노드 전 노드)에 도달하게 된다.
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        // 타겟노드 전 노드와 타겟노드 후 노드를 연결
        slow.next = slow.next.next;
        return head;
    }
}
