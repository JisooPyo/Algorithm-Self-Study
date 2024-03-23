package leetcode.al2403;

import java.util.Stack;

public class Leet143 {

    public void reorderList(ListNode head) {
        if (head.next == null) {
            return;
        }

        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        Stack<ListNode> stack = new Stack<>();
        slow = slow.next;
        while (slow != null) {
            stack.add(slow);
            slow = slow.next;
        }

        ListNode pointer = head;
        ListNode next = head.next;
        while (!stack.isEmpty()) {
            ListNode pop = stack.pop();
            pop.next = next;
            pointer.next = pop;
            pointer = next;
            next = next.next;
        }

        pointer.next = null;
    }

    // 다른 사람의 풀이
    // 재귀를 이용하여 풀이
    public void reorderListOther(ListNode head) {
        if (head.next == null) {
            return;
        }
        reorder(head, head.next);
    }

    public ListNode reorder(ListNode head, ListNode curr) {
        ListNode temp;
        if (curr.next != null) {
            temp = reorder(head, curr.next);
        } else {
            temp = head;
        }
        if (temp == null) {
            return null;
        }
        if (temp == curr || temp.next == curr) {
            curr.next = null;
            return null;
        }

        curr.next = temp.next;
        temp.next = curr;
        return curr.next;
    }
}
