package leetcode.al2405;

import java.util.ArrayList;
import java.util.List;

public class Leet2816 {
    public static void main(String[] args) {
        Leet2816 l = new Leet2816();
        l.problem1();
        l.problem2();
    }

    private void problem1() {
        ListNode l3 = new ListNode(9);
        ListNode l2 = new ListNode(8, l3);
        ListNode l1 = new ListNode(1, l2);

        print(doubleIt(l1));
    }

    private void problem2() {
        ListNode l3 = new ListNode(9);
        ListNode l2 = new ListNode(9, l3);
        ListNode l1 = new ListNode(9, l2);

        print(doubleIt(l1));
    }

    private void print(ListNode head) {
        ListNode pointer = head;
        while (pointer != null) {
            System.out.print(pointer.val + ", ");
            pointer = pointer.next;
        }
        System.out.println();
    }

    // Note. ListNode의 길이는 1에서 10^4까지.
    public ListNode doubleIt(ListNode head) {
        // 1. ListNode를 돌면서 List에 수 저장
        List<Integer> cur = toArrayList(head);

        // 2. List에 있는 수 2배
        List<Integer> twice = getTwice(cur);

        // 3. List<Integer>를 탐색하면서 새로운 ListNode 만들고 return
        ListNode answer = toLinkedList(twice);

        // 4. head가 5이상일시 앞에 1 붙여주기
        if (cur.get(0) >= 5) {
            ListNode l = new ListNode(1, answer);
            answer = l;
        }

        return answer;
    }

    private List<Integer> toArrayList(ListNode head) {
        List<Integer> list = new ArrayList<>();
        ListNode pointer = head;
        while (pointer != null) {
            list.add(pointer.val);
            pointer = pointer.next;
        }
        return list;
    }

    private List<Integer> getTwice(List<Integer> cur) {
        List<Integer> list = new ArrayList<>(cur);
        int ten = 0;
        for (int i = list.size() - 1; i >= 0; i--) {
            int twice = list.get(i) * 2 + ten;
            list.set(i, twice % 10);
            ten = twice >= 10 ? 1 : 0;
        }
        return list;
    }

    private ListNode toLinkedList(List<Integer> twice) {
        int index = twice.size() - 1;
        ListNode tail = new ListNode(twice.get(index));
        ListNode pointer = tail;
        index--;
        while (index >= 0) {
            ListNode l = new ListNode(twice.get(index), pointer);
            pointer = l;
            index--;
        }
        return pointer;
    }

    // 다른 사람 풀이 -> 아주 간단하게 풀었다..!
    public ListNode doubleItOther(ListNode head) {
        ListNode head1 = new ListNode();
        head1.next = head;

        ListNode left = head1;
        ListNode right = head;
        while (right != null) {
            if (right.val * 2 >= 10) {
                left.val += 1;
            }
            right.val = (right.val * 2) % 10;
            left = left.next;
            right = right.next;
        }
        return head1.val > 0 ? head1 : head;
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
