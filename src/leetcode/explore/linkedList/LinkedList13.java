package leetcode.explore.linkedList;

public class LinkedList13 {
    public static void main(String[] args) {
        LinkedList13 l = new LinkedList13();
        l.problem1();
        l.problem2();
        l.problem3();
        l.problem4();
    }

    private void problem4() {
        Node n1 = new Node();
        n1.val = 1;
        Node o1 = new Node();
        o1.val = 2;
        Node p1 = new Node();
        p1.val = 3;
        n1.child = o1;
        o1.child = p1;
        Node answer = flatten(n1);
        print(answer);
    }

    private void problem3() {
        Node answer = flatten(null);
        print(answer);
    }

    private void problem2() {
        Node n1 = new Node();
        Node n2 = new Node();
        Node o1 = new Node();
        n1.next = n2;
        n1.child = o1;
        n2.prev = n1;
        n1.val = 1;
        n2.val = 2;
        o1.val = 3;
        Node answer = flatten(n1);
        print(answer);
    }

    private void problem1() {
        Node n1 = new Node();
        Node n2 = new Node();
        Node n3 = new Node();
        Node n4 = new Node();
        Node n5 = new Node();
        Node n6 = new Node();
        n1.val = 1;
        n2.val = 2;
        n3.val = 3;
        n4.val = 4;
        n5.val = 5;
        n6.val = 6;
        Node o1 = new Node();
        Node o2 = new Node();
        Node o3 = new Node();
        Node o4 = new Node();
        o1.val = 7;
        o2.val = 8;
        o3.val = 9;
        o4.val = 10;
        Node p1 = new Node();
        Node p2 = new Node();
        p1.val = 11;
        p2.val = 12;

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        o1.next = o2;
        o2.next = o3;
        o3.next = o4;
        p1.next = p2;

        n6.prev = n5;
        n5.prev = n4;
        n4.prev = n3;
        n3.prev = n2;
        n2.prev = n1;
        o4.prev = o3;
        o3.prev = o2;
        o2.prev = o1;
        p2.prev = p1;

        n3.child = o1;
        o2.child = p1;
        Node answer = flatten(n1);
        print(answer);
    }

    public void print(Node head) {
        Node cur = head;
        int index = 0;
        while (cur != null) {
            System.out.print("index: " + index);
            System.out.print(" -> val: " + cur.val);
            String prev = cur.prev == null ? "null" : Integer.toString(cur.prev.val);
            System.out.print(", prev: " + prev);
            String next = cur.next == null ? "null" : Integer.toString(cur.next.val);
            System.out.print(", next: " + next);
            String child = cur.child == null ? "null" : Integer.toString(cur.child.val);
            System.out.print(", child: " + child + "\n");
            cur = cur.next;
            index++;
        }
        System.out.println("------------------------------------------");
    }

    // 재귀 이용해야 할 것 같다..
    public Node flatten(Node head) {
        if (head == null) {
            return null;
        }
        Node answer = read(head);
        return answer;
    }

    private Node read(Node head) {
        Node point = head;
        while (point != null) {
            if (point.child != null) {
                Node temp = point.next;
                point.next = read(point.child);
                point.next.prev = point;
                point.child = null;
                while (point.next != null) {
                    point = point.next;
                }
                point.next = temp;
                if (temp != null) {
                    temp.prev = point;
                }
            }
            point = point.next;
        }
        return head;
    }
}
