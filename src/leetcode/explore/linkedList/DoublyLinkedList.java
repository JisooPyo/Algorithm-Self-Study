package leetcode.explore.linkedList;

public class DoublyLinkedList {
    int val;
    DoubleNode head;

    public DoublyLinkedList() {
    }

    public int get(int index) {
        if (head == null) {
            return -1;
        }
        if (index >= getSize()) {
            return -1;
        }
        int curIndex = 0;
        DoubleNode cur = head;
        while (curIndex < index) {
            cur = cur.next;
            curIndex++;
        }
        return cur.val;
    }

    public void addAtHead(int val) {
        DoubleNode add = new DoubleNode();
        add.val = val;
        if (head == null) {
            head = add;
            return;
        }
        add.next = head;
        head.prev = add;
        head = add;
    }

    public void addAtTail(int val) {
        DoubleNode add = new DoubleNode();
        add.val = val;
        // head가 존재하지 않다면 head로 추가
        if (head == null) {
            head = add;
            return;
        }
        // 꼬리 찾기
        DoubleNode tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }
        tail.next = add;
        add.prev = tail;
    }

    public void addAtIndex(int index, int val) {
        int size = getSize();
        if (size < index) {
            return;
        }
        if (size == index) {
            addAtTail(val);
            return;
        }
        if (size == 0 || index == 0) {
            addAtHead(val);
            return;
        }
        // 추가 노드 정의
        DoubleNode add = new DoubleNode();
        add.val = val;

        // 이전 노드, 다음 노드 찾기
        DoubleNode prev = head;
        int prevIndex = 0;
        while (prevIndex != index - 1) {
            prev = prev.next;
            prevIndex++;
        }
        DoubleNode next = prev.next;

        // cur 연결
        add.prev = prev;
        add.next = next;

        // prev, next 연결
        prev.next = add;
        next.prev = add;
    }

    public void deleteAtIndex(int index) {
        int size = getSize();
        if (index == 0) {
            if (head.next == null) {
                head = null;
                return;
            }
            head = head.next;
            return;
        }
        if (index >= getSize()) {
            return;
        }
        // prev와 next 연결
        DoubleNode prev = head;
        int prevIndex = 0;
        while (prevIndex != index - 1) {
            prev = prev.next;
            prevIndex++;
        }
        DoubleNode next = prev.next.next;
        prev.next = next;
        if (index != size - 1) {
            next.prev = prev;
        }
    }

    public int getSize() {
        int size = 0;
        DoubleNode cur = head;
        while (cur != null) {
            cur = cur.next;
            size++;
        }
        return size;
    }

    public void print() {
        DoubleNode cur = head;
        int index = 0;
        while (cur != null) {
            System.out.print("index: " + index);
            System.out.print(" -> val: " + cur.val);
            String prev = cur.prev == null ? "null" : Integer.toString(cur.prev.val);
            System.out.print(", prev: " + prev);
            String next = cur.next == null ? "null" : Integer.toString(cur.next.val);
            System.out.print(", next: " + next + "\n");
            cur = cur.next;
            index++;
        }
        System.out.println("------------------------------------------\n");
    }

    public class DoubleNode {
        int val;
        DoubleNode prev;
        DoubleNode next;
    }

}


