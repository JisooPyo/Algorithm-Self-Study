package leetcode.explore.linkedList;

public class LinkedList9_x {
    public static void main(String[] args) {
        LinkedList9_x l = new LinkedList9_x();
        l.problem1();
        l.problem2();
    }

    private void problem2() {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        l1.next = l2;
        System.out.println(isPalindrome(l1));
    }

    private void problem1() {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(2);
        ListNode l4 = new ListNode(1);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        System.out.println(isPalindrome(l1));
    }

    private void print(ListNode answer) {
        if (answer == null) {
            System.out.println("answer is null");
        }
        while (answer != null) {
            System.out.print(answer.val + ", ");
            answer = answer.next;
        }
        System.out.println();
    }

    public boolean isPalindrome(ListNode head) {
        ListNode slow = head, fast = head, prev, temp;
        // slow, fast pointer로 중간 지점 찾기
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // 가운데를 기준으로 하여 기준과 가까운 오른쪽노드부터 노드 방향 바꾸기
        // ex1. 1 -> 2 -> 3 -> 4 -> 3 -> 2 -> 1
        // => 1 -> 2 -> 3 -> 4 <- 3 <- 2 <- 1
        // ex2. 1 -> 2 -> 3 -> 4 -> 4 -> 3 -> 2 -> 1
        // => 1 -> 2 -> 3 -> 4 -> 4 <- 3 <- 2 <- 1
        prev = slow;
        slow = slow.next;
        prev.next = null;
        while (slow != null) {
            temp = slow.next;
            slow.next = prev;
            prev = slow;
            slow = temp;
        }

        fast = head;
        // slow -> 가장 오른쪽 끝 노드
        slow = prev;

        // fast와 slow 값 비교
        while (slow != null) {
            if (fast.val != slow.val) return false;
            fast = fast.next;
            slow = slow.next;
        }
        return true;
    }
}
