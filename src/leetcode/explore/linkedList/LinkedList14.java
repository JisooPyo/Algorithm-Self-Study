package leetcode.explore.linkedList;

import java.util.HashMap;
import java.util.Map;

public class LinkedList14 {
    public static void main(String[] args) {
        LinkedList14 l = new LinkedList14();
        l.problem1();
        l.problem2();
        l.problem3();
    }

    private void problem3() {
        Node n1 = new Node(3);
        Node n2 = new Node(3);
        Node n3 = new Node(3);
        n1.next = n2;
        n2.next = n3;
        n2.random = n1;
        print(n1);
        Node answer = copyRandomList(n1);
        print(answer);
    }

    private void problem2() {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        n1.next = n2;
        n1.random = n2;
        n2.random = n2;
        print(n1);
        Node answer = copyRandomList(n1);
        print(answer);
    }

    private void problem1() {
        Node n1 = new Node(7);
        Node n2 = new Node(13);
        Node n3 = new Node(11);
        Node n4 = new Node(10);
        Node n5 = new Node(1);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n1.random = null;
        n2.random = n1;
        n3.random = n5;
        n4.random = n3;
        n5.random = n1;
        print(n1);
        Node answer = copyRandomList(n1);
        print(answer);
    }

    private void print(Node answer) {
        Node point = answer;
        int index = 0;
        while (point != null) {
            System.out.print("index: " + index++);
            System.out.print(", val: " + point.val);
            System.out.print(", addr: " + onlyFive(System.identityHashCode(point)));
            System.out.print(", next: " + onlyFive(System.identityHashCode(point.next)));
            System.out.print(", random: " + onlyFive(System.identityHashCode(point.random)) + "\n");
            point = point.next;
        }
    }

    private String onlyFive(int i) {
        StringBuilder sb = new StringBuilder();
        sb.append("*");
        int count = 0;
        while (count < 5) {
            sb.append(i % 10);
            i = i / 10;
            count++;
        }
        return sb.toString();
    }

    // random 설정을 map을 이용하여 설정하였다.
    // 다른 사람의 풀이 중 original -> clone -> original -> clone 식으로 만든 뒤,
    // head.next.random = head.random.next; 로 random을 맞춰주고
    // 앞서 만들었던 o -> c -> o -> c를 이용해 c -> c -> c 가 되게 만들어 반환한 풀이도 있었다.
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }

        // 원래 노드, 복사한 노드 map에 저장하면서 next 먼저 입력
        Map<Node, Node> map = new HashMap<>();
        Node point = head;
        Node newHead = new Node(head.val);
        map.put(head, newHead);
        Node newPoint = newHead;
        while (true) {
            point = point.next;
            if (point == null) {
                break;
            }
            Node newNode = new Node(point.val);
            map.put(point, newNode);
            newPoint.next = newNode;
            newPoint = newPoint.next;
        }

        // random 입력
        point = head;
        newPoint = newHead;
        while (point != null) {
            if (point.random != null) {
                newPoint.random = map.get(point.random);
            }
            point = point.next;
            newPoint = newPoint.next;
        }

        return newHead;
    }

    private void printMap(Map<Node, Node> map) {
        System.out.println("map ------->");
        for (Node key : map.keySet()) {
            String keyStr = onlyFive(System.identityHashCode(key));
            String valueStr = onlyFive(System.identityHashCode(map.get(key)));
            System.out.println("key: " + keyStr + ", value: " + valueStr);
        }
    }

    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}
