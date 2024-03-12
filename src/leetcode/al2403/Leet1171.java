package leetcode.al2403;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class Leet1171 {
    public static void main(String[] args) {
        Leet1171 l = new Leet1171();
        ListNode l1 = new ListNode(2);
        ListNode l2 = new ListNode(3);
        ListNode l3 = new ListNode(-1);
        ListNode l4 = new ListNode(-2);
        ListNode l5 = new ListNode(-2);
        ListNode l6 = new ListNode(5);
        ListNode l7 = new ListNode(6);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;
        l6.next = l7;
        ListNode answer = l.removeZeroSumSublists(l1);
    }

    public ListNode removeZeroSumSublists(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        Set<Integer> sumSet = new HashSet<>();
        Stack<Integer> sumStack = new Stack<>();
        sumSet.add(0);
        sumStack.add(0);

        ListNode pointer = head;
        while (pointer != null) {
            stack.add(pointer);
            int sum = sumStack.peek() + pointer.val;
            if (sumSet.contains(sum)) {
                removeZeroSum(sum, stack, sumSet, sumStack);
                pointer = pointer.next;
                continue;
            }
            sumSet.add(sum);
            sumStack.add(sum);
            pointer = pointer.next;
        }

        if (stack.isEmpty()) {
            return null;
        }

        Stack<ListNode> reverseStack = new Stack<>();
        while (!stack.isEmpty()) {
            reverseStack.add(stack.pop());
        }
        ListNode answer = reverseStack.pop();
        ListNode pointerAnswer = answer;
        while (!reverseStack.isEmpty()) {
            pointerAnswer.next = reverseStack.pop();
            pointerAnswer = pointerAnswer.next;
        }
        pointerAnswer.next = null;
        return answer;
    }

    private void removeZeroSum(int sum, Stack<ListNode> stack, Set<Integer> sumSet, Stack<Integer> sumStack) {
        int count = 0;
        while (sumStack.peek() != sum) {
            sumSet.remove(sumStack.pop());
            count++;
        }

        for (int i = 1; i <= count + 1; i++) {
            stack.pop();
        }
    }

    // 다른 사람 풀이
    // 재귀로 풀었다.
    public ListNode removeZeroSumSublists2(ListNode head) {
        if (head == null)
            return head;
        ListNode prev = null;
        ListNode cur = head;
        int running_sum = 0;
        while (cur != null) {
            running_sum += cur.val;
            if (running_sum == 0) {
                if (prev == null)
                    head = cur.next;
                else
                    prev.next = cur.next;
                return removeZeroSumSublists(head);
            }
            cur = cur.next;
        }
        head.next = removeZeroSumSublists(head.next);
        return head;
    }

    public static class ListNode {
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
