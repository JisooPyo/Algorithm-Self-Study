package leetcode.al2405;

import java.util.ArrayList;
import java.util.List;

public class Leet2487 {
    public static void main(String[] args) {
        Leet2487 l = new Leet2487();
        l.problem1();
        l.problem2();
    }

    private void problem1() {
        ListNode l5 = new ListNode(8);
        ListNode l4 = new ListNode(3, l5);
        ListNode l3 = new ListNode(13, l4);
        ListNode l2 = new ListNode(2, l3);
        ListNode l1 = new ListNode(5, l2);

        ListNode answeer = removeNodes(l1);
    }

    private void problem2() {
        ListNode l4 = new ListNode(1);
        ListNode l3 = new ListNode(1, l4);
        ListNode l2 = new ListNode(1, l3);
        ListNode l1 = new ListNode(1, l2);

        ListNode answeer = removeNodes(l1);
    }

    // "재귀로 풀면 될 것 같은데"까지만 떠오르고 구현을 못 해냄..
    // 다른 사람의 풀이는 크게 세 가지였다.
    // 1. Stack을 이용
    // 2. 재귀를 이용
    // 3. linked list 뒤집어서 풀이

    // 시간은 3번이 가장 짧았지만 2번은 가독성이 좋았다. 메모리 스택의 문제가 없다면 2번도 괜찮은 듯.

    // 다른 사람의 풀이 - 재귀
    public ListNode removeNodes(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode node = head;
        ListNode nxtGreater = removeNodes(node.next);

        node.next = nxtGreater;
        if (nxtGreater == null || node.val >= nxtGreater.val) {
            return node;
        }
        return nxtGreater;
    }

    // 다른 사람의 풀이 - linked list 뒤집기
    // 1. linked list를 뒤집는다.
    // 2. 뒤집힌 리스트를 탐색하며 노드의 값을 비교하고 제거한다.
    // 3. 다시 리스트를 뒤집어 반환한다.
    public ListNode removeNodes2(ListNode head) {
        if(head.next == null){
            return head;
        }
        ListNode prevNode = head;
        ListNode currentNode = head.next;

        while(currentNode != null){
            ListNode nextNode = currentNode.next;
            currentNode.next = prevNode;
            prevNode = currentNode;
            currentNode = nextNode;
        }
        head.next = null;
        head = prevNode;

        prevNode = head;
        currentNode = head.next;
        while(currentNode != null){
            if(currentNode.val < prevNode.val){
                currentNode = currentNode.next;
            }
            else{
                ListNode nextNode = currentNode.next;
                currentNode.next = prevNode;
                prevNode = currentNode;
                currentNode = nextNode;
            }

        }
        head.next = null;
        head = prevNode;
        return head;
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
