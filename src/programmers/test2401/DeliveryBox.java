package programmers.test2401;

import java.util.Stack;

public class DeliveryBox {
    public static void main(String[] args) {
        DeliveryBox d = new DeliveryBox();

        int[] order1 = {4, 3, 1, 2, 5};
        int[] order2 = {5, 4, 3, 2, 1};
        System.out.println(d.solution(order1));
        System.out.println(d.solution(order2));
    }

    public int solution(int[] order) {
        Stack<Integer> sub = new Stack<>();
        Stack<Integer> truck = new Stack<>();
        int belt = 1;
        int len = order.length;
        loop1:
        for (int i = 0; i < len; i++) {
            while (true) {
                if (sub.size() > 0 && sub.peek() == order[i]) {
                    truck.push(sub.pop());
                    break;
                }
                if (belt < len) {
                    if (order[i] == belt) {
                        truck.push(belt);
                        belt++;
                        break;
                    } else {
                        sub.push(belt);
                        belt++;
                        continue;
                    }
                }
                if (belt == len) {
                    if (order[i] == belt) {
                        truck.push(belt);
                        break;
                    } else {
                        break loop1;
                    }
                }
            }
        }
        return truck.size();
    }
}
