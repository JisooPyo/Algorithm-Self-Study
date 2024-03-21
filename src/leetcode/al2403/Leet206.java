package leetcode.al2403;

import java.util.Stack;

public class Leet206 {
    public static void main(String[] args) {
        Leet206 l = new Leet206();

        ListNode l5 = new ListNode(5);
        ListNode l4 = new ListNode(4, l5);
        ListNode l3 = new ListNode(3, l4);
        ListNode l2 = new ListNode(2, l3);
        ListNode l1 = new ListNode(1, l2);

        ListNode answer = l.reverseList(l1);
        l.printListNode(answer);
    }

    private void printListNode(ListNode head) {
        StringBuilder sb = new StringBuilder();
        sb.append("val: ");

        ListNode pointer = head;
        while (pointer != null) {
            sb.append(pointer.val);
            sb.append(", ");
            pointer = pointer.next;
        }

        sb.deleteCharAt(sb.length() - 1);
        sb.deleteCharAt(sb.length() - 1);

        System.out.println(sb);
    }

    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }

        Stack<ListNode> stack = new Stack<>();
        ListNode pointer = head;
        while (pointer != null) {
            stack.add(pointer);
            pointer = pointer.next;
        }

        ListNode answer = stack.pop();
        ListNode answerPointer = answer;
        while (!stack.isEmpty()) {
            answerPointer.next = stack.pop();
            answerPointer = answerPointer.next;
        }

        answerPointer.next = null;

        return answer;
    }

    // 다른 사람 풀이
    public ListNode reverseList2(ListNode head) {
        ListNode prev = null;
        ListNode cur = head;
        ListNode next = null;

        while (cur != null) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }

        head = prev;
        return head;
    }
}
