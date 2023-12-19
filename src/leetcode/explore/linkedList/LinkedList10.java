package leetcode.explore.linkedList;

public class LinkedList10 {
    public static void main(String[] args) {
        DoublyLinkedList d = new DoublyLinkedList();
        System.out.println("1");
        d.addAtHead(2);
        d.print();
        System.out.println("2");
        d.deleteAtIndex(1);
        d.print();
        System.out.println("3");
        d.addAtHead(2);
        d.print();
        System.out.println("4");
        d.addAtHead(7);
        d.print();
        System.out.println("5");
        d.addAtHead(3);
        d.print();
        System.out.println("6");
        d.addAtHead(2);
        d.print();
        System.out.println("7");
        d.addAtHead(5);
        d.print();
        System.out.println("8");
        d.addAtTail(5);
        d.print();
        System.out.println("9");
        System.out.println("d.get(5) = " + d.get(5));
        System.out.println("10");
        d.deleteAtIndex(6);
        d.print();
        System.out.println("11");
        d.deleteAtIndex(4);
        d.print();
    }
}
