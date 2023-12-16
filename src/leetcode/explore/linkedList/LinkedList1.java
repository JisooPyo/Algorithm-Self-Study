package leetcode.explore.linkedList;

public class LinkedList1 {
    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addAtHead(1);
        myLinkedList.print();

        myLinkedList.addAtTail(3);
        myLinkedList.print();

        myLinkedList.addAtIndex(3, 2);
        myLinkedList.print();
    }

}
