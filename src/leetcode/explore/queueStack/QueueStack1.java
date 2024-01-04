package leetcode.explore.queueStack;

import java.util.ArrayList;
import java.util.List;

public class QueueStack1 {
    public static void main(String[] args) {
        MyCircularQueue myCircularQueue = new MyCircularQueue(3);
        System.out.println(myCircularQueue.enQueue(1)); // return True
        System.out.println(myCircularQueue.enQueue(2)); // return True
        System.out.println(myCircularQueue.enQueue(3)); // return True
        System.out.println(myCircularQueue.enQueue(4)); // return False
        System.out.println(myCircularQueue.Rear());     // return 3
        System.out.println(myCircularQueue.isFull());   // return True
        System.out.println(myCircularQueue.deQueue());  // return True
        System.out.println(myCircularQueue.enQueue(4)); // return True
        System.out.println(myCircularQueue.Rear());     // return 4
    }

    public static class MyCircularQueue {
        List<Integer> queue;
        int maxSize;

        public MyCircularQueue(int k) {
            queue = new ArrayList<>();
            maxSize = k;
        }

        public boolean enQueue(int value) {
            if (queue.size() == maxSize) {
                return false;
            }
            queue.add(value);
            return true;
        }

        public boolean deQueue() {
            if (queue.size() == 0) {
                return false;
            }
            queue.remove(0);
            return true;
        }

        public int Front() {
            if (queue.size() == 0) {
                return -1;
            }
            return queue.get(0);
        }

        public int Rear() {
            if (queue.size() == 0) {
                return -1;
            }
            return queue.get(queue.size() - 1);
        }

        public boolean isEmpty() {
            return queue.size() == 0;
        }

        public boolean isFull() {
            return queue.size() == maxSize;
        }
    }
}
