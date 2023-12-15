package leetcode.explore.linkedList;

public class MyLinkedList {
    Node head;

    public MyLinkedList() {
    }

    public int get(int index) {
        if (getSize() <= index) {
            return -1;
        }
        int cur = 0;
        Node target = head;
        if (index == 0) {
            return head.val;
        }
        while (cur < index) {
            cur++;
            target = target.next;
        }
        return target.val;
    }

    public void addAtHead(int val) {
        Node newHeadNode = new Node();
        newHeadNode.val = val;
        if (head == null) {
            head = newHeadNode;
            return;
        }
        newHeadNode.next = head;
        head = newHeadNode;
    }

    public void addAtTail(int val) {
        Node newNode = new Node();
        newNode.val = val;
        if (head == null) {
            head = newNode;
            return;
        }
        Node tail = head;
        while (true) {
            if (tail.next == null) {
                break;
            }
            tail = tail.next;
        }
        tail.next = newNode;
    }

    public void addAtIndex(int index, int val) {
        if (getSize() < index) {
            return;
        }
        Node curNode = new Node();
        curNode.val = val;
        if (index == 0) {
            addAtHead(val);
            return;
        }
        int curIdx = 0;
        Node prevNode = head;
        while (curIdx < index - 1) {
            curIdx++;
            prevNode = prevNode.next;
        }
        Node nextNode = prevNode.next;
        curNode.next = nextNode;
        prevNode.next = curNode;
    }

    public void deleteAtIndex(int index) {
        if (index == 0) {
            head = head.next;
            return;
        }
        if (getSize() <= index || index < -1) {
            return;
        }
        int curIdx = 0;
        Node prevNode = head;
        while (curIdx < index - 1) {
            curIdx++;
            prevNode = prevNode.next;
        }
        Node nextNode = prevNode.next.next;
        prevNode.next = nextNode;
    }

    public void print() {
        Node printNode = head;
        while (printNode != null) {
            System.out.print(printNode.val + ", ");
            printNode = printNode.next;
        }
        System.out.println();
    }

    public int getSize() {
        if (head == null) {
            return 0;
        }
        int size = 0;
        Node curNode = head;
        while (curNode != null) {
            size++;
            curNode = curNode.next;
        }
        return size;
    }

    class Node {
        int val;
        Node next;
    }
}


