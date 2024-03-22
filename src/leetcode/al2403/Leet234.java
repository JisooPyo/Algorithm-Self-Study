package leetcode.al2403;

import java.util.Stack;

public class Leet234 {
    public static void main(String[] args) {
        Leet234 l = new Leet234();
        ListNode l4 = new ListNode(1);
        ListNode l3 = new ListNode(2, l4);
        ListNode l2 = new ListNode(2, l3);
        ListNode l1 = new ListNode(1, l2);

        System.out.println(l.isPalindrome(l1));
    }

    // 내 풀이
    public boolean isPalindrome(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            stack.add(slow.val);
            slow = slow.next;
            fast = fast.next.next;
        }

        if (fast != null) {
            slow = slow.next;
        }
        while (!stack.isEmpty()) {
            if (stack.pop() != slow.val) {
                return false;
            }
            slow = slow.next;
        }

        return true;
    }

    // 다른 사람의 풀이
    // 1. array에 ListNode의 val을 차례로 저장한다.
    // 2. array for문을 돌리는데 처음과 끝에서 안쪽 방향으로 가면서 값이 같은지 확인한다.
    // array라서 확실히 빨랐다!
}
